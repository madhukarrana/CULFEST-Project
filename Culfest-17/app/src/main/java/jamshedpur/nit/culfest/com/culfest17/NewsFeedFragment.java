package jamshedpur.nit.culfest.com.culfest17;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Aditya on 26-12-2016.
 */

public class NewsFeedFragment extends Fragment{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<NewsModel> data;
    private DatabaseReference databaseReference;

    ProgressBar progressBar;
    ProgressDialog p;
    LinearLayout ll;

    public NewsFeedFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news_feed, container , false);
        getActivity().setTitle("Notifications");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.notifications_white);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.notifications)));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(getContext() , R.color.notification_status)));
        }

        ll=(LinearLayout)rootView.findViewById(R.id.progressbar_view);
        progressBar=(ProgressBar)rootView.findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#9900ff"), PorterDuff.Mode.MULTIPLY);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_news);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        databaseReference = FirebaseDatabase.getInstance().getReference().child("news");
        databaseReference.keepSynced(true);

        data = new ArrayList<NewsModel>();


        data.clear();
        //  data.add(new ScheduleDataModel("Event","Venue","Time"));


        p=new ProgressDialog(getContext());
        p.setMessage("Loading News Feed...");
        p.setCancelable(false);
       // p.show();
        ll.setVisibility(View.VISIBLE);

        adapter = new NewsAdapter(data,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        recyclerView.addOnItemTouchListener(new RecylcerTouchListener(getContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View v, int position) {
                //Toast.makeText(getActivity(),"OnClick "+position,Toast.LENGTH_SHORT).show();
                recyclerView.getAdapter().notifyDataSetChanged();

                String message=data.get(data.size()-1-position).getMessage();

                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setMessage(message);
                builder.setNegativeButton("CLOSE",null);
                builder.setCancelable(false);
                builder.setTitle(data.get(data.size()-1-position).getTitle());
                AlertDialog alertDialog=builder.create();
                alertDialog.show();







            }

            @Override
            public void onLongClick(View v, int position) {
                //Toast.makeText(getActivity(),"OnLongClick "+position,Toast.LENGTH_SHORT).show();
            }
        }));


        databaseReference.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                data.clear();
                ll.setVisibility(View.GONE);
                p.dismiss();
               // Toast.makeText(getContext(), "DataFetched", Toast.LENGTH_SHORT).show();
                for(com.google.firebase.database.DataSnapshot ds: dataSnapshot.getChildren())
                {
                    NewsModel val=ds.getValue(NewsModel.class);
                    data.add(val);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


       /* ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                ll.setVisibility(View.GONE);
                p.dismiss();
                Toast.makeText(getContext(), "DataFetched", Toast.LENGTH_SHORT).show();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    NewsModel val=ds.getValue(NewsModel.class);
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


    static class RecylcerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private ClickListener clickListener;
        public RecylcerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener)
        {
            this.clickListener=clickListener;
           // Log.d("Adi","Contructor called");
            gestureDetector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    //Log.d("Adi","OnSingleTapUp");
                    return true;
                }


                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clickListener!=null)
                    {
                        clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                    }
                    //Log.d("Adi","OnLongPress");
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

           // Log.d("Adi","OnInterceptTouchEvent "+gestureDetector.onTouchEvent(e)+" "+e);
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
