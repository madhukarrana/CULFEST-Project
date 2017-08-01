package jamshedpur.nit.culfest.com.culfest17;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class SubEvent extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private ArrayList<EventsDataModel> data;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        recyclerView = (RecyclerView) findViewById(R.id.sub_event_rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        toolbar = (Toolbar) findViewById(R.id.sub_event_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(ContextCompat.getColor(this , R.color.colorTitle));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(MERVAdapter.mainEventTitle);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(this , R.color.developers_status)));
        }

        data = new ArrayList<EventsDataModel>();

        switch(MERVAdapter.mainEventTitleIndex) {
            case 0:
                for(int i = 0;i < EventsData.megaEvents.length;i++) {
                    data.add(new EventsDataModel(EventsData.megaEvents[i], EventsData.megaEventImage[i]));
                } break;
            case 1:
                for(int i = 0;i < EventsData.dance.length;i++) {
                    data.add(new EventsDataModel(EventsData.dance[i], EventsData.danceImage[i]));
                } break;
            case 2:
                for(int i = 0;i < EventsData.dramatics.length;i++) {
                    data.add(new EventsDataModel(EventsData.dramatics[i], EventsData.dramaticsImage[i]));
                } break;
            case 3:
                for(int i = 0;i < EventsData.quizzing.length;i++) {
                    data.add(new EventsDataModel(EventsData.quizzing[i], EventsData.quizzingImage[i]));
                } break;
            case 5:
                for(int i = 0;i < EventsData.vocals.length;i++) {
                    data.add(new EventsDataModel(EventsData.vocals[i], EventsData.vocalsImage[i]));
                } break;
            case 6:
                for(int i = 0;i < EventsData.fine_arts.length;i++) {
                    data.add(new EventsDataModel(EventsData.fine_arts[i], EventsData.fineArtsImage[i]));
                } break;
            case 7:
                for(int i = 0;i < EventsData.informals.length;i++) {
                    data.add(new EventsDataModel(EventsData.informals[i], EventsData.informalsImage[i]));
                } break;
            case 4:
                for(int i = 0;i < EventsData.literary.length;i++) {
                    data.add(new EventsDataModel(EventsData.literary[i], EventsData.literaryImage[i]));
                } break;
        }

        adapter = new SERVAdapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpTo(this, new Intent(this,MainEvent.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
