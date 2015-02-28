package com.bao.android_auto_scroll_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ImagePagerAdapter extends FragmentPagerAdapter {

    int [] resIds = new int[]{R.drawable.tips_viewpager0,R.drawable.tips_viewpager1,R.drawable.tips_viewpager2,R.drawable.tips_viewpager3};

    public ImagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int i) {
        return ImageFragment.newInstance(resIds[i]);
    }

    @Override public int getCount() {
        return resIds.length;
    }


}