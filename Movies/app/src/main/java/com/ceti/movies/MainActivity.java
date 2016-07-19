package com.ceti.movies;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ceti.movies.Fragments.EstrenosFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        setupFragments(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void setupFragments(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new EstrenosFragment(),"Estrenos");
        viewPager.setAdapter(viewPagerAdapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> listFragment = new ArrayList<>();
        private List<String> titles = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return listFragment.size();
        }
        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }
        public void addFragment(Fragment fragment, String title){
            listFragment.add(fragment);
            titles.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
