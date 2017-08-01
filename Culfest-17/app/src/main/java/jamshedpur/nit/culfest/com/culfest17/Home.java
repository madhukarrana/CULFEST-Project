package jamshedpur.nit.culfest.com.culfest17;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aditya on 27-12-2016.
 */

public class Home extends Fragment {

    private DatabaseReference databaseReference;
    private ViewFlipper viewFlipper;
    private float lastX;
    private TextView title,description;
    private ImageView im[];
    private static final int TIMER_LENGTH1= 3600*24;
    private static final int TIMER_LENGTH2= 3600;
    private static final int TIMER_LENGTH3= 60;
    private static int i=0;
    private TextView tvDay, tvHour, tvMinute, tvSecond, tvEvent;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;
    private TimerView mTimerView1,mTimerView2,mTimerView3;
    private static long h=0,m=0,s=0,d=0;
    private String images[];
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("CULFEST");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.culfest4);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.home)));

        context=getActivity();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(getContext() , R.color.home_status)));
        }

        viewFlipper=(ViewFlipper)v.findViewById(R.id.viewflipper);
        title=(TextView)v.findViewById(R.id.title);
        Typeface face=Typeface.createFromAsset(getContext().getAssets(),"fonts/LONDO___.TTF");
        title.setTypeface(face);
        description=(TextView)v.findViewById(R.id.description);
        Typeface face1=Typeface.createFromAsset(getContext().getAssets(),"fonts/PrinsesstartaBoldDEMO.ttf");
        description.setTypeface(face1);












        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        initUI(v);
        countDownStart();
        Typeface face3=Typeface.createFromAsset(getContext().getAssets(),"fonts/LONDO___.TTF");
        tvDay.setTypeface(face3);
        tvHour.setTypeface(face3);
        tvMinute.setTypeface(face3);
        tvSecond.setTypeface(face3);
        im=new ImageView[5];

       im[0]=(ImageView)v.findViewById(R.id.one);
       im[1]=(ImageView)v.findViewById(R.id.two);
        im[2]=(ImageView)v.findViewById(R.id.three);
      im[3]=(ImageView)v.findViewById(R.id.four);
      im[4]=(ImageView)v.findViewById(R.id.five);

        description.setText(Html.fromHtml("<strong>“Culfest”</strong>- A name having its own euphoric charm, spotless aura and still arcadian in its roots.  All combining to give rousing atmosphere amidst the tranquil and nebulous Indian spring time emanating vivacity of NIT Jamshedpur in India having blissful hearts welcoming talent across the culture rich nation." +
                "<br><br>" +
                "<strong>Culfest – the cultural fest of NIT Jamshedpur</strong> to be held on 10-12th of February is one of the most highly anticipated events of the year. The virtue of it resonates with the idea of creativity, enthusiasm, ambition, passion and an ocean of unfettered energy waiting to exude. Year after year, it has gone bigger and better in terms of the scale, participation and grandeur and this year it seems to take a step ahead. Witnessing a footfall of over 6000 since the last few editions it is consistently attracting a demographic diversity that few can boast of, Culfest remains an unrivalled platform for showcasing the energy and creativity of the youth." +
                "<br><br>" +
                "This year Culfest promises to be bigger and better, set to encompass a wider array of glamorous events and reach new heights of hysteria! With the theme being Wanderlust- esprit d’ adventure- watch us bring the best of everything around the globe all under the 350 acre campus!!! So if you proclaim yourself to be an adventurer..then gear up!! This one’s just for you!!"));




        databaseReference= FirebaseDatabase.getInstance().getReference().child("Images");
        databaseReference.keepSynced(true);
        images=new String[5];

        title.setText("CULFEST\'17");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int i=0;
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    String im=ds.getValue(String.class);
                    images[i++]=im;
                }
                setImages();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

    void setImages()
    {

        Picasso.with(context).load(images[0]).placeholder(R.drawable.h1).into(im[0]);
        Picasso.with(context).load(images[1]).placeholder(R.drawable.h1).into(im[1]);
        Picasso.with(context).load(images[2]).placeholder(R.drawable.h1).into(im[2]);
        Picasso.with(context).load(images[3]).placeholder(R.drawable.h1).into(im[3]);
        Picasso.with(context).load(images[4]).placeholder(R.drawable.h1).into(im[4]);
    }


    @SuppressLint("SimpleDateFormat")
    private void initUI(View v) {
        //linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) v.findViewById(R.id.ll2);
        tvDay = (TextView) v.findViewById(R.id.txtTimerDay);
        tvHour = (TextView) v.findViewById(R.id.txtTimerHour);
        tvMinute = (TextView) v.findViewById(R.id.txtTimerMinute);
        tvSecond = (TextView) v.findViewById(R.id.txtTimerSecond);
        //tvEvent = (TextView) findViewById(R.id.tvevent);
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Here Set your Event Date
                    Date eventDate = dateFormat.parse("2017-02-10");
                    Date currentDate = new Date();
                    if (!currentDate.after(eventDate)) {
                        long diff = eventDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        if(i==0)
                        {
                            float f1=0,f2=0,f3=0;
                            f1=((24-hours)*360)/24;
                           // mTimerView1.setStartValue(f1);
                            //Toast.makeText(getApplicationContext(),"  "+f+" ", Toast.LENGTH_SHORT).show();
                            f2=((60-minutes)*360)/60;
                           // mTimerView2.setStartValue(f2);
                            //Toast.makeText(getApplicationContext(),"  "+f+" ", Toast.LENGTH_SHORT).show();
                            f3=((60-seconds)*360)/60;
                           // mTimerView3.setStartValue(f3);
                            //Toast.makeText(getApplicationContext(),"  "+f3+" ", Toast.LENGTH_SHORT).show();
                          //  mTimerView1.start((int)hours*3600);
                            //mTimerView2.start((int)minutes*60);
                            //mTimerView3.start((int)seconds);
                            i++;
                            d=days;
                            h=hours;
                            m=minutes;
                            s=seconds;
                        }
                        if(minutes!=m)
                        {
                           // mTimerView3.setStartValue(0);
                           // mTimerView3.start(TIMER_LENGTH3);
                            m=minutes;
                        }
                        if(hours!=h)
                        {
                           // mTimerView2.setStartValue(0);
                           // mTimerView2.start(TIMER_LENGTH2);
                            h=hours;
                        }
                        if(days!=d)
                        {
                          //  mTimerView1.setStartValue(0);
                          //  mTimerView1.start(TIMER_LENGTH1);
                            d=days;
                        }
                        tvDay.setText("" + String.format("%02d", days));
                        tvHour.setText("" + String.format("%02d", hours));
                        tvMinute.setText("" + String.format("%02d", minutes));
                        tvSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        //linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.GONE);
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }




    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen to swap
            case MotionEvent.ACTION_DOWN:
            {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                float currentX = touchevent.getX();

                // if left to right swipe on screen
                if (lastX < currentX)
                {
                    // If no more View/Child to flip
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Left and current Screen will go OUT from Right
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                    // Show the next Screen
                    viewFlipper.showNext();
                }

                // if right to left swipe on screen
                if (lastX > currentX)
                {
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;
                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Right and current Screen will go OUT from Left
                    viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                    viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                }
                break;
            }
        }
        return false;
    }

    @Override
    public void onAttach(Context context) {
        countDownStart();
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    class ImageDownloader extends AsyncTask<Integer,Void,Void>
    {
        @Override
        protected Void doInBackground(Integer... params) {
            int index=params[0];
            Picasso.with(context).load(images[index]).placeholder(R.drawable.h1).into(im[index]);
            return null;
        }
    }

}

