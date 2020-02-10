package com.recore.bbsalonadmin.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.recore.bbsalonadmin.Fragment.AccountFragment;
import com.recore.bbsalonadmin.Fragment.DashboardFragment;
import com.recore.bbsalonadmin.Fragment.HomeFragment;
import com.recore.bbsalonadmin.Fragment.OrdersFragment;
import com.recore.bbsalonadmin.Fragment.ProductsFragment;
import com.recore.bbsalonadmin.Fragment.SearchFragment;
import com.recore.bbsalonadmin.R;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager)findViewById(R.id.container);
        tabLayout = (TabLayout)findViewById(R.id.tabPage);

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dashboard_24px);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home_24px);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_book_24px);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_label_24px);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_search_24px);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_person_24px);

        tabLayout.setPadding(20, 4,20,4);

    }

    //view pager class
    private class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int i) {
            switch (i){

                case 0:
                    return new DashboardFragment();
                case 1:
                    return new HomeFragment();
                case 2:
                    return new OrdersFragment();
                case 3:
                    return new ProductsFragment();
                case 4:
                    return new SearchFragment();
                case 5:
                    return new AccountFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Dashboard";
                case 1:
                    return "Home";
                case 2:
                    return  "Orders";
                case 3:
                    return  "Products";
                case 4:
                    return  "Search";
                case 5:
                    return  "Account";

            }
            return null;
        }
    }

}
