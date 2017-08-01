package jamshedpur.nit.culfest.com.culfest17;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    int selectedPos=0;

     static RecyclerView recyclerView;
    private MyAdapter adapter;

    private FragmentManager fragmentmanager;
    private FragmentTransaction fragmenttransaction;
    FirebaseRemoteConfig remoteConfig;
    FirebaseRemoteConfigSettings configSettings;
    long cacheExpiration=14920;
    Boolean flag;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private DrawerLayout.DrawerListener listener;
    private static final String PREFS_TEXT="textprefs";
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;
    private static final String KEY_USER_LEARDER_DRAWER="user_learned_drawer";
    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer=Boolean.valueOf(getFromPreferences(getActivity(),KEY_USER_LEARDER_DRAWER,"false"));
        if(savedInstanceState!=null)
        {
            mFromSavedInstanceState=true;
        }

        fragmentmanager=getFragmentManager();
        fragmenttransaction=fragmentmanager.beginTransaction();



    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout= inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView=(RecyclerView)layout.findViewById(R.id.recyclerView);
        adapter=new MyAdapter(getActivity(),getdata());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecylcerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View v, int position) {
                //Toast.makeText(getActivity(),"OnClick "+position,Toast.LENGTH_SHORT).show();
                MyAdapter.selected_item = position;
                recyclerView.getAdapter().notifyDataSetChanged();
                //listener.onDrawerItemSelected(v, position);
                loadSelection(position);
                mDrawerLayout.closeDrawer(containerView);
                //v.setBackgroundColor(Color.CYAN);
            }

            @Override
            public void onLongClick(View v, int position) {
              //  Toast.makeText(getActivity(),"OnLongClick "+position,Toast.LENGTH_SHORT).show();
            }
        }));

        remoteConfig=FirebaseRemoteConfig.getInstance();
        configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();

        remoteConfig.setConfigSettings(configSettings);
        remoteConfig.setDefaults(R.xml.defaults);


        if (remoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration = 0;
        }


        remoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                          // Toast.makeText(getContext(), "Fetch Succed",Toast.LENGTH_SHORT).show();

                            getValue();


                            // Once the config is successfully fetched it must be activated before newly fetched
                            // values are returned.
                            remoteConfig.activateFetched();
                        } else {
                          //  Toast.makeText(getContext(), "Fetch Failed",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        loadSelection(0);
        return layout;
    }

    public void getValue() {

        flag=remoteConfig.getBoolean("schedule_view");
    }

    private void loadSelection(int position) {




        getValue();


        switch(position)
        {

            case 0:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new Home());
                fragmenttransaction.commit();

                break;
            case 1:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new MainEvent());
                fragmenttransaction.commit();
                break;
            case 2:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new NewsFeedFragment());
                fragmenttransaction.commit();
                break;
            case 3:
                if(true)
                {
                    fragmenttransaction = fragmentmanager.beginTransaction();
                    fragmenttransaction.replace(R.id.frameholder,new Schedule());
                    fragmenttransaction.commit();
                }else
                {

                    MyAdapter.selected_item=0;
                    adapter.notifyDataSetChanged();
                    AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                    builder.setMessage("To be declared soon");
                    builder.setNegativeButton("CLOSE",null);
                    builder.setCancelable(false);
                    builder.setTitle("Schedule");
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                    fragmenttransaction = fragmentmanager.beginTransaction();
                    fragmenttransaction.replace(R.id.frameholder,new Home());
                    fragmenttransaction.commit();
                }

                break;
            case 4:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new Map());
                fragmenttransaction.commit();

                break;
            case 5:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new Sponsor());
                fragmenttransaction.commit();
                break;
            case 6:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new Team());
                fragmenttransaction.commit();
                break;
            case 7:
                fragmenttransaction = fragmentmanager.beginTransaction();
                fragmenttransaction.replace(R.id.frameholder,new Developers());
                fragmenttransaction.commit();
                break;

        }



    }


    public static List<Information> getdata(){
        List<Information> data=new ArrayList<>();
        int icon[]={R.drawable.home,R.drawable.events,R.drawable.notification,R.drawable.schedule,R.drawable.maps,R.drawable.sponsor,R.drawable.team,R.drawable.developers};
        String title[]={"Home","Events","Notification","Schedule","Maps","Past Sponsors","Team","Developers"};
        for(int i=0;i<icon.length && i<title.length;i++)
        {
            Information current=new Information();
            current.title=title[i];
            current.iconId=icon[i];
            data.add(current);
        }

        return data;
    }


    public void setUp(int id, DrawerLayout drawerlayout, final Toolbar toolbar) {
        containerView=getActivity().findViewById(id);
        mDrawerLayout=drawerlayout;
        mDrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerlayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer=true;
                    saveToPreferences(getActivity(),KEY_USER_LEARDER_DRAWER,mUserLearnedDrawer+"");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset<0.5)
                {
                    toolbar.setAlpha(1-slideOffset);
                }

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };

        if(!mUserLearnedDrawer && !mFromSavedInstanceState)
        {
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


    }

    private static void saveToPreferences(Context context,String preferenceKey,String preferenceValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREFS_TEXT,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(preferenceKey,preferenceValue);
        editor.apply();
    }
    private static String getFromPreferences(Context context,String preferenceKey,String defaultValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREFS_TEXT,Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceKey,defaultValue);
    }

   static class RecylcerTouchListener implements RecyclerView.OnItemTouchListener{

       private GestureDetector gestureDetector;
       private ClickListener clickListener;
        public RecylcerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener)
        {
            this.clickListener=clickListener;
            Log.d("Adi","Contructor called");
            gestureDetector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Log.d("Adi","OnSingleTapUp");
                    return true;
                }


                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clickListener!=null)
                    {
                        clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                    }
                    Log.d("Adi","OnLongPress");
                }

            });
        }


       @Override
       public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
           View child=rv.findChildViewUnder(e.getX(),e.getY());
           if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e))
           {
               clickListener.onClick(child,rv.getChildPosition(child));
           }

           Log.d("Adi","OnInterceptTouchEvent "+gestureDetector.onTouchEvent(e)+" "+e);
           return false;
       }

       @Override
       public void onTouchEvent(RecyclerView rv, MotionEvent e) {
           Log.d("Adi","OnTouchEvent"+e);
       }

       @Override
       public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

       }
   }


    public static interface ClickListener{
        public void onClick(View v, int position);
        public void onLongClick(View v, int position);
    }

}
