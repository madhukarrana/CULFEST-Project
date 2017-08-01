package jamshedpur.nit.culfest.com.culfest17;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


public class FirstActivity extends AppCompatActivity {

    private Toolbar toolbar;
    RelativeLayout dimmedBackground;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton fab1, fab2, fab3,fab4,fab5;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    DrawerLayout drawerLayout;
    NavigationDrawerFragment drawerfragment;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dimmedBackground.setVisibility(View.GONE);
        setContentView(R.layout.activity_first);
        //setUpWindowAnimator();

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setIcon(android.R.drawable.ic_dialog_map);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dimmedBackground=(RelativeLayout)findViewById(R.id.dimmedBackground);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinatorlayout);


        drawerfragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerfragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        MyAdapter.selected_item = 0;
        NavigationDrawerFragment.recyclerView.getAdapter().notifyDataSetChanged();


        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.floating_menu);
        fab1 = (FloatingActionButton) findViewById(R.id.floating_facebook);
        fab2 = (FloatingActionButton) findViewById(R.id.floating_twitter);
        fab3 = (FloatingActionButton) findViewById(R.id.floating_website);
        fab4 = (FloatingActionButton) findViewById(R.id.floating_instagram);
        fab5 = (FloatingActionButton) findViewById(R.id.floating_youtube);



        materialDesignFAM.setClosedOnTouchOutside(true);




        materialDesignFAM.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {

                if(opened)
                {
                    materialDesignFAM.setBackgroundColor(Color.parseColor("#99ffffff"));
                    //dimmedBackground.setVisibility(View.VISIBLE);
                }
                else
                {
                    materialDesignFAM.setBackgroundColor(Color.parseColor("#00000000"));
                   // dimmedBackground.setVisibility(View.GONE);
                }

            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent facebookIntent = getOpenFacebookIntent(FirstActivity.this);
                startActivity(facebookIntent);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent twitterIntent = getOpenTwitterIntent(FirstActivity.this);
                startActivity(twitterIntent);
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent twitterIntent = getOpenWebsiteIntent(FirstActivity.this);
                startActivity(twitterIntent);
                //fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.replace(R.id.frameholder,new Team());
                // fragmentTransaction.commit();
                //MyAdapter.selected_item = 5;
                //NavigationDrawerFragment.recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instagramIntent = getOpenInstagramIntent(FirstActivity.this);
                startActivity(instagramIntent);
            }
        });

        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent youtubeIntent = getOpenYouTubeIntent(FirstActivity.this);
                startActivity(youtubeIntent);
            }
        });



        if(isNetworkAvailable())
        {
        }
        else
        {
            Snackbar snackbar=Snackbar.make(coordinatorLayout,"No Internet Connection",Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.RED);
            snackbar.show();
        }



    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setUpWindowAnimator() {

        Slide slide = new Slide();
        slide.setDuration(1000);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(slide);
        }

    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/260118660758335"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/utk.nitjsr"));
        }
    }

    public static Intent getOpenTwitterIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.twitter.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/sec_cul"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/sec_cul"));
        }
    }

    public static Intent getOpenWebsiteIntent(Context context) {

        try {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.culfest.co.in"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.culfest.co.in"));
        }
    }

    public static Intent getOpenInstagramIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/_u/culfest.nitjsr"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/culfest.nitjsr"));
        }
    }

    public static Intent getOpenYouTubeIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.youtube", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/user/CulfestNitJSR"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/user/CulfestNitJSR")); //catches and opens a url to the desired page
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if(this.drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            if(materialDesignFAM.isOpened())
            {
                materialDesignFAM.setBackgroundColor(Color.parseColor("#00000000"));
                materialDesignFAM.close(true);
            }
            else
            {
                if (MyAdapter.selected_item==0) {

                    new AlertDialog.Builder(this)
                            .setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    FirstActivity.this.finish();
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();
                    return;
                }
                else
                {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameholder,new Home());
                    fragmentTransaction.commit();
                    MyAdapter.selected_item = 0;
                    NavigationDrawerFragment.recyclerView.getAdapter().notifyDataSetChanged();
                }

                //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();




            }





        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }



}


