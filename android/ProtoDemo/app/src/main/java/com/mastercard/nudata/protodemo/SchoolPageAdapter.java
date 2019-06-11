package com.mastercard.nudata.protodemo;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SchoolPageAdapter extends FragmentStatePagerAdapter {
    List<Fragment> pagerFragments;

    public SchoolPageAdapter(FragmentManager fm, List<Fragment> pagerFragments) {
        super(fm);
        this.pagerFragments = pagerFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerFragments.get(position);
    }

    @Override
    public int getCount() {
        return pagerFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Create";
            case 1:
                return "Decode";
            default:
                return null;
        }
    }
}
