package jamshedpur.nit.culfest.com.culfest17;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DayThreeFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ScheduleDataModel> data;
    private DatabaseReference databaseReference;
    private ProgressDialog p;


    public DayThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_day_three, container , false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_three);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        databaseReference = FirebaseDatabase.getInstance().getReference().child("feb12");
        databaseReference.keepSynced(true);

        data = new ArrayList<ScheduleDataModel>();
       /* for (int i = 0; i < ScheduleData.event.length; i++) {
            data.add(new ScheduleDataModel(ScheduleData.event[i], ScheduleData.venue[i],
                    ScheduleData.time[i]));
        }*/

        data.clear();
        //  data.add(new ScheduleDataModel("Event","Venue","Time"));



        adapter = new ScheduleAdapter(data,3,getContext());
        recyclerView.setAdapter(adapter);


        adapter.notifyDataSetChanged();

        p=new ProgressDialog(getContext());
        p.setMessage("Loading Schedule...");
        p.show();

        databaseReference.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                data.clear();
                p.dismiss();
                //Toast.makeText(getContext(), "DataFetched", Toast.LENGTH_SHORT).show();
                for(com.google.firebase.database.DataSnapshot ds: dataSnapshot.getChildren())
                {
                    ScheduleDataModel val=ds.getValue(ScheduleDataModel.class);
                    data.add(val);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    ScheduleDataModel val=ds.getValue(ScheduleDataModel.class);
                    data.add(val);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
        return rootView;
    }

}
