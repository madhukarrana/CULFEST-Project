package jamshedpur.nit.culfest.com.culfest17;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentTabListAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments_tab_list = new ArrayList<>();
    private ArrayList<String> tab_titles_list = new ArrayList<>();

    public FragmentTabListAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment , String title) {
        fragments_tab_list.add(fragment);
        tab_titles_list.add(title);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments_tab_list.get(position);
    }

    @Override
    public int getCount() {
        return fragments_tab_list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_titles_list.get(position);
    }
}
