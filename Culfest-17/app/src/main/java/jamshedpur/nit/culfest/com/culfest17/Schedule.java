package jamshedpur.nit.culfest.com.culfest17;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Aditya on 15-12-2016.
 */

public class Schedule extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentTabListAdapter adapter;


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
        View v= inflater.inflate(R.layout.fragment_schedule, container, false);
        getActivity().setTitle("Schedule");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.schedule_white);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.schedule)));


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(getContext() , R.color.schedule_status)));
        }

        tabLayout = (TabLayout) v.findViewById(R.id.schedule_tab_layout);
        viewPager = (ViewPager) v.findViewById(R.id.schedule_view_pager);



        adapter = new FragmentTabListAdapter(getChildFragmentManager());

        adapter.addFragment(new DayOneFragment(), "DAY 1");
        adapter.addFragment(new DayTwoFragment(), "DAY 2");
        adapter.addFragment(new DayThreeFragment(),"DAY 3");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);





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


}
