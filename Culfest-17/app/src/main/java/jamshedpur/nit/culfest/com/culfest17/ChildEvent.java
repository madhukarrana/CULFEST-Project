package jamshedpur.nit.culfest.com.culfest17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static java.security.AccessController.getContext;

public class ChildEvent extends AppCompatActivity {

    CollapsingToolbarLayout event_collapsing_toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentTabListAdapter adapter;
    private Toolbar toolbar;
    private List<String> eventListTitle;
    private HashMap<String, List<String>> eventListDetail;
    ImageView eventImage;
    FirebaseRemoteConfig remoteConfig;
    FirebaseRemoteConfigSettings configSettings;
    long cacheExpiration=14920;
    Boolean value;
    DatabaseReference databaseReference;
     ArrayList<ReminderModel> data;
    
    ProgressDialog p;
    RelativeLayout rl;
    Button reminder;

    public static String actionBarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_child_event);
       // setupWindowAnimations();

        tabLayout = (TabLayout) findViewById(R.id.tab_layout_child_event);
        viewPager = (ViewPager) findViewById(R.id.view_pager_child_event);
        toolbar = (Toolbar) findViewById(R.id.collapsing_tool_bar_child_event);
        eventImage = (ImageView) findViewById(R.id.events_image);
        rl=(RelativeLayout)findViewById(R.id.button_layout);
        reminder=(Button)findViewById(R.id.reminder);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("reminder");
        databaseReference.keepSynced(true);
        
        data=new ArrayList<ReminderModel>();

        p=new ProgressDialog(this);
        p.setMessage("Loading Event Details .....");
        p.show();
        p.setCancelable(false);
        
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                p.dismiss();
                //Toast.makeText(getApplicationContext(), "DataFetched", Toast.LENGTH_SHORT).show();
                for(com.google.firebase.database.DataSnapshot ds: dataSnapshot.getChildren())
                {
                    ReminderModel val=ds.getValue(ReminderModel.class);
                    data.add(val);
                }
                
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        
        

        remoteConfig=FirebaseRemoteConfig.getInstance();
        configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();

        remoteConfig.setConfigSettings(configSettings);
        remoteConfig.setDefaults(R.xml.defaults);


        if (remoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration = 0;
        }

        getValue();
        remoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                           // Toast.makeText(getApplicationContext(), "Fetch Succeeded", Toast.LENGTH_SHORT).show();
                                getValue();
                                p.dismiss();
                            // Once the config is successfully fetched it must be activated before newly fetched
                            // values are returned.
                            remoteConfig.activateFetched();
                        } else {
                           // Toast.makeText(getApplicationContext(), "Fetch Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


        if(true)
        {
            rl.setVisibility(View.VISIBLE);
        }
        else
        {
            p.dismiss();
            rl.setVisibility(View.GONE);
        }


        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // format "10-FEB-2017 04:00:00"
                //setReminder(actionBarTitle,"10-FEB-2017 04:00:00","10-FEB-2017 06:00:00");

                switch(actionBarTitle)
                {
                    case "RADIANCE":
                        setReminder(data.get(0).getEvent(),data.get(0).getFrom(),data.get(0).getTo());
                        break;
                    case "CHOREO NIGHT":
                       setReminder(data.get(1).getEvent(),data.get(1).getFrom(),data.get(1).getTo());
                        break;
                    case "HALLA BOL":
                       setReminder(data.get(2).getEvent(),data.get(2).getFrom(),data.get(2).getTo());
                        break;
                    case "JOURNALISM":
                        setReminder(data.get(3).getEvent(),data.get(3).getFrom(),data.get(3).getTo());
                        break;
                    case "THEME QUIZ":
                        setReminder(data.get(4).getEvent(),data.get(4).getFrom(),data.get(4).getTo());
                        break;
                    case "POSHAK":
                        setReminder(data.get(5).getEvent(),data.get(5).getFrom(),data.get(5).getTo());
                        break;
                    case "DISTORTION":
                        setReminder(data.get(6).getEvent(),data.get(6).getFrom(),data.get(6).getTo());
                        break;
                    case "FOOT LOOSE":
                        setReminder(data.get(7).getEvent(),data.get(7).getFrom(),data.get(7).getTo());
                        break;
                    case "DANCE DUO":
                        setReminder(data.get(8).getEvent(),data.get(8).getFrom(),data.get(8).getTo());
                        break;
                    case "SHAKE ON BEAT":
                        setReminder(data.get(9).getEvent(),data.get(9).getFrom(),data.get(9).getTo());
                        break;
                    case "MONO ACTING":
                        setReminder(data.get(10).getEvent(),data.get(10).getFrom(),data.get(10).getTo());
                        break;
                    case "MERI MAGGI":
                        setReminder(data.get(11).getEvent(),data.get(11).getFrom(),data.get(11).getTo());
                        break;
                    case "RANGMANCH":
                        setReminder(data.get(12).getEvent(),data.get(12).getFrom(),data.get(12).getTo());
                        break;
                    case "MIME":
                        setReminder(data.get(13).getEvent(),data.get(13).getFrom(),data.get(13).getTo());
                        break;
                    case "INDIA QUIZ":
                        setReminder(data.get(14).getEvent(),data.get(14).getFrom(),data.get(14).getTo());
                        break;
                    case "ENTERTAINMENT QUIZ":
                        setReminder(data.get(15).getEvent(),data.get(15).getFrom(),data.get(15).getTo());
                        break;
                    case "JAM":
                        setReminder(data.get(16).getEvent(),data.get(16).getFrom(),data.get(16).getTo());
                        break;
                    case "POTPOURRI":
                        setReminder(data.get(17).getEvent(),data.get(17).getFrom(),data.get(17).getTo());
                        break;
                    case "DEBATE":
                        setReminder(data.get(18).getEvent(),data.get(18).getFrom(),data.get(18).getTo());
                        break;
                    case "WIT-A-STORY":
                        setReminder(data.get(19).getEvent(),data.get(19).getFrom(),data.get(19).getTo());
                        break;
                    case "POETRY SLAM":
                        setReminder(data.get(20).getEvent(),data.get(20).getFrom(),data.get(20).getTo());
                        break;
                    case "CREATIVE WRITING":
                        setReminder(data.get(21).getEvent(),data.get(21).getFrom(),data.get(21).getTo());
                        break;
                    case "SSMQ":
                        setReminder(data.get(22).getEvent(),data.get(22).getFrom(),data.get(22).getTo());
                        break;
                    case "EASTERN VOCALS":
                        setReminder(data.get(23).getEvent(),data.get(23).getFrom(),data.get(23).getTo());
                        break;
                    case "WESTERN VOCALS":
                        setReminder(data.get(24).getEvent(),data.get(24).getFrom(),data.get(24).getTo());
                        break;
                    case "DUET VOCALS":
                        setReminder(data.get(25).getEvent(),data.get(25).getFrom(),data.get(25).getTo());
                        break;
                    case "GROUP SONG":
                        setReminder(data.get(26).getEvent(),data.get(26).getFrom(),data.get(26).getTo());
                        break;
                    case "RANGOLI":
                        setReminder(data.get(27).getEvent(),data.get(27).getFrom(),data.get(27).getTo());
                        break;
                    case "FACE PAINTING":
                        setReminder(data.get(28).getEvent(),data.get(28).getFrom(),data.get(28).getTo());
                        break;
                    case "T-SHIRT PAINTING":
                        setReminder(data.get(29).getEvent(),data.get(29).getFrom(),data.get(29).getTo());
                        break;
                    case "CLAY DOH":
                        setReminder(data.get(30).getEvent(),data.get(30).getFrom(),data.get(30).getTo());
                        break;
                    case "TRIATHLON":
                        setReminder(data.get(31).getEvent(),data.get(31).getFrom(),data.get(31).getTo());
                         break;
                    case "SOAP CARVING":
                        setReminder(data.get(32).getEvent(),data.get(32).getFrom(),data.get(32).getTo());
                        break;
                    case "FUTSAL":
                       rl.setVisibility(View.GONE);
                        break;
                    case "TECHNO CRICKET":
                        rl.setVisibility(View.GONE);
                        break;
                    case "FACE-OFF":
                        setReminder(data.get(35).getEvent(),data.get(35).getFrom(),data.get(35).getTo());
                        break;
                    case "RJ HUNT":
                        setReminder(data.get(36).getEvent(),data.get(36).getFrom(),data.get(36).getTo());
                        break;
                    case "TREASURE HUNT":
                        setReminder(data.get(37).getEvent(),data.get(37).getFrom(),data.get(37).getTo());
                        break;
                    case "ANTAKSHRI":
                        setReminder(data.get(38).getEvent(),data.get(38).getFrom(),data.get(38).getTo());
                        break;
                    case "UNPLUGGED":
                        setReminder(data.get(39).getEvent(),data.get(39).getFrom(),data.get(39).getTo());
                        break;
                    case "COS PLAY":
                        setReminder(data.get(40).getEvent(),data.get(40).getFrom(),data.get(40).getTo());
                        break;
                    case "BLIND DATE":
                        setReminder(data.get(41).getEvent(),data.get(41).getFrom(),data.get(41).getTo());
                        break;
                    case "PAPER DANCE":
                       setReminder(data.get(42).getEvent(),data.get(42).getFrom(),data.get(42).getTo());
                        break;
                }



            }
        });



        event_collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_events_layout);

        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this , R.color.face_painting));
        }
        event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                R.color.face_painting));

        Animation eventsImageAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right_events_imge);
        eventImage.startAnimation(eventsImageAnimation);
        eventsImageAnimation.setRepeatMode(Animation.REVERSE);
        eventsImageAnimation.setRepeatCount(Animation.INFINITE);




        actionBarTitle = SERVAdapter.subEventTitle;

        toolbar.setTitleTextColor(ContextCompat.getColor(this , R.color.colorTitle));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

   // setting collapsing toolbar title and color ---------------------------
        event_collapsing_toolbar.setTitle(actionBarTitle);

        switch(actionBarTitle) {
            case "RADIANCE":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.fashion);
                break;
            case "CHOREO NIGHT":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.choreonite);
                break;
            case "HALLA BOL":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.halla_bol);
                break;
            case "JOURNALISM":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.journnalism);
                break;
            case "THEME QUIZ":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.theme);
                break;
            case "POSHAK":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.poshak2);
                break;
            case "DISTORTION":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.distortion);
                break;
            case "FOOT LOOSE":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.footloose);
                break;
            case "DANCE DUO":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.danceduo);
                break;
            case "SHAKE ON BEAT":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.shakeonbeat);
                break;
            case "MONO ACTING":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.monoacting);
                break;
            case "MERI MAGGI":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.instkichdi);
                break;
            case "RANGMANCH":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.rangmanc);
                break;
            case "MIME":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.mime);
                break;
            case "INDIA QUIZ":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.india2);
                break;
            case "ENTERTAINMENT QUIZ":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.entertainment);
                break;
            case "JAM":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.jam2);
                break;
            case "POTPOURRI":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.hindi_potpuri2);
                break;
            case "DEBATE":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.debate2);
                break;
            case "WIT-A-STORY":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.wit_a_story2);
                break;
            case "POETRY SLAM":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.poetry);
                break;
            case "CREATIVE WRITING":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.creative_writing2);
                break;
            case "SSMQ":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.ssmq);
                break;
            case "EASTERN VOCALS":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.eastern);
                break;
            case "WESTERN VOCALS":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.western);
                break;
            case "DUET VOCALS":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.duet_song);
                break;
            case "GROUP SONG":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.groupsong);
                break;
            case "RANGOLI":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.rangoli2);
                break;
            case "FACE PAINTING":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.face2);
                break;
            case "T-SHIRT PAINTING":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.tshirt);
                break;
            case "CLAY DOH":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.clay2);
                break;
            case "TRIATHLON":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.traithlon2);
                break;
            case "SOAP CARVING":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.soap_carving);
                break;
            case "FUTSAL":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.futsal);
                break;
            case "TECHNO CRICKET":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.techno2);
                break;
            case "FACE-OFF":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.faceoff);
                break;
            case "RJ HUNT":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.rj2);
                break;
            case "TREASURE HUNT":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.treasure2);
                break;
            case "ANTAKSHRI":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.antakshari2);
                break;
            case "UNPLUGGED":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.unplugged);
                break;
            case "COS PLAY":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.cos_play);
                break;
            case "BLIND DATE":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.blind_date);
                break;
            case "PAPER DANCE":
                event_collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),
                        R.color.face_painting));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this , R.color.face_painting));
                eventImage.setImageResource(R.drawable.paper_dance);
                break;


        }

        adapter = new FragmentTabListAdapter(getSupportFragmentManager());

        adapter.addFragment(new AboutFragment() , "DESCRIPTION");
        adapter.addFragment(new RulesFragment() , "RULES");
        adapter.addFragment(new CoordinatorFragment(), "COORDINATOR");
        adapter.addFragment(new PrizeFragment(), "PRIZE");

    //  adapter.addFragment(new CoordinatorFragment(), "COORDINATOR CULFEST 17");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupWindowAnimations() {



    }

    private void getValue() {
        value=remoteConfig.getBoolean("reminder_button");
    }

    public void setReminder(String title,String starttime,String endtime)
    {
        Calendar start = Calendar.getInstance();
        try {
            start.setTime(new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss").parse(starttime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar end = Calendar.getInstance();
        try {
            end.setTime(new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss").parse(endtime));
        } catch (ParseException e) {
            e.printStackTrace();
        }



        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", start.getTimeInMillis());
        intent.putExtra("allDay", false);
        intent.putExtra("endTime",end.getTimeInMillis());
        intent.putExtra("title", title);
        //intent.putExtra("location","NIT Jamshedpur");
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpTo(this, new Intent(this, SubEvent.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
