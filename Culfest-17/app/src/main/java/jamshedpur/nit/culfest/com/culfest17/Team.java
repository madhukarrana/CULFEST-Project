package jamshedpur.nit.culfest.com.culfest17;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Aditya on 15-12-2016.
 */

public class Team extends Fragment {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<TeamDataModel> data;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v= inflater.inflate(R.layout.fragment_team, container, false);
        getActivity().setTitle("Team");
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.team_white);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.team)));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(getContext() , R.color.team_status)));
        }

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_team);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recyclerView.setItemAnimator(new DefaultItemAnimator());





        data = new ArrayList<TeamDataModel>();
        for (int i = 0; i < TeamData.name.length; i++) {
            data.add(new TeamDataModel(TeamData.name[i], TeamData.post[i],TeamData.contact_no[i],TeamData.email[i]));
        }

        adapter = new TeamAdapter(data,getContext());

        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecylcerTouchListener(getActivity(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View v, int position) {
                //Toast.makeText(getActivity(),"OnClick "+position,Toast.LENGTH_SHORT).show();
                //MyAdapter.selected_item = position;
                recyclerView.getAdapter().notifyDataSetChanged();
                //listener.onDrawerItemSelected(v, position);
                //loadSelection(position);
                //mDrawerLayout.closeDrawer(containerView);
                //v.setBackgroundColor(Color.CYAN);

                Intent intent = new Intent(getActivity(), TeamActivity.class);
                intent.putExtra("Position", position);
                startActivity(intent);
                //getActivity().finish();


            }

            @Override
            public void onLongClick(View v, int position) {
               // Toast.makeText(getActivity(),"OnLongClick "+position,Toast.LENGTH_SHORT).show();
            }
        }));






        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();
    }



    static class RecylcerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private ClickListener clickListener;
        public RecylcerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener)
        {
            this.clickListener=clickListener;
          //  Log.d("Adi","Contructor called");
            gestureDetector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                  //  Log.d("Adi","OnSingleTapUp");
                    return true;
                }


                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clickListener!=null)
                    {
                        clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                    }
                  //  Log.d("Adi","OnLongPress");
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

          //  Log.d("Adi","OnInterceptTouchEvent "+gestureDetector.onTouchEvent(e)+" "+e);
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
