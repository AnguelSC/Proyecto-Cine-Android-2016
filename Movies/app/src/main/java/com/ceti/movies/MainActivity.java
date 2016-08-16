package com.ceti.movies;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.ceti.movies.Fragments.ContactoFragment;
import com.ceti.movies.Fragments.EstrenosFragment;
import com.ceti.movies.Fragments.ProductoFragment;
import com.ceti.movies.Fragments.ProximoFragment;

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

        new AlertDialogWrapper.Builder(this)
                .setTitle("Peliculas de estreno")
                .setMessage("Deseas ir a ver las peliculas de estreno?")
                .setPositiveButton("Ir",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewPager.setCurrentItem(2);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No gracias", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void setupFragments(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new EstrenosFragment(),"Estrenos");
        viewPagerAdapter.addFragment(new ProximoFragment(),"Proximos");
        viewPagerAdapter.addFragment(new ContactoFragment(),"Contacto");
        viewPagerAdapter.addFragment(new ProductoFragment(),"Productos");
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
