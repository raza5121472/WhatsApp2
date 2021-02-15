package com.razaacademy.whatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.razaacademy.whatsapp.databinding.ActivityMainBinding;
import com.razaacademy.whatsapp.menu.callsFragment;
import com.razaacademy.whatsapp.menu.chatsFragment;
import com.razaacademy.whatsapp.menu.statusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setUpWithViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbar);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void setUpWithViewPager(ViewPager viewPager){
        MainActivity.SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new chatsFragment(),"Chats");
        adapter.addFragment(new statusFragment(),"Status");
        adapter.addFragment(new callsFragment(),"Calls");
        viewPager.setAdapter(adapter);
    }
    private static class SectionPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        private void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_search: Toast.makeText(MainActivity.this,"Action Button Clicked",Toast.LENGTH_SHORT).show();
            break;
            case R.id.menu_more: Toast.makeText(MainActivity.this,"Menu More Button Clicked",Toast.LENGTH_SHORT).show();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void changeIcon(final int index){
        binding.fabAction.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0: binding.fabAction.setImageDrawable(getDrawable(R.drawable.chat)); break;
                    case 1: binding.fabAction.setImageDrawable(getDrawable(R.drawable.camera)); break;
                    case 2: binding.fabAction.setImageDrawable(getDrawable(R.drawable.call)); break;
                }
                binding.fabAction.show();
            }
        },400);

    }
}
