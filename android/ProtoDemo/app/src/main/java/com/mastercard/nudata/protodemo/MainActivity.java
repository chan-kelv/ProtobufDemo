package com.mastercard.nudata.protodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager schoolViewPager;
    TabLayout schoolTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> pagerFragments = new ArrayList<>();
        pagerFragments.add(new CreateUserFragment());
        pagerFragments.add(new CreateUserFragment());

        schoolViewPager = findViewById(R.id.pager_person);
        FragmentStatePagerAdapter adapter = new SchoolPageAdapter(getSupportFragmentManager(), pagerFragments);
        schoolViewPager.setAdapter(adapter);

        schoolTabLayout = findViewById(R.id.pagertab_person);
        schoolTabLayout.setupWithViewPager(schoolViewPager);
    }
}
