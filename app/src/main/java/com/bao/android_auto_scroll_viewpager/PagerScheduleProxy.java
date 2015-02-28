package com.bao.android_auto_scroll_viewpager;


import android.os.Handler;
import android.support.v4.view.ViewPager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PagerScheduleProxy {

    int mCurrentItem = 0;
    int mInterval = 0;
    ScheduledExecutorService mScheduledExecutorService;
    ViewPager viewPager;

    public PagerScheduleProxy(ViewPager viewPager, int interval) {
        this.viewPager = viewPager;
        this.mInterval = interval;
    }

    /*
      * 换行切换任务
      */
    private class ScrollTask implements Runnable {

        public void run() {
            mCurrentItem = (mCurrentItem + 1) % viewPager.getAdapter().getCount();
            mHandler.obtainMessage().sendToTarget(); // 通过Handler切换图片
        }
    }


    // 切换当前显示的图片
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(mCurrentItem);// 切换当前显示的图片
        }
    };

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //重新计时
            if(mScheduledExecutorService != null) mScheduledExecutorService.shutdownNow();
            mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            mScheduledExecutorService .schedule(new ScrollTask(), mInterval, TimeUnit.SECONDS);
            mCurrentItem = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return onPageChangeListener;
    }



    public void onStart(){
        mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //当Fragment显示出来后，每隔一段时间切换一次图片显示
        mScheduledExecutorService .schedule(new ScrollTask(), mInterval, TimeUnit.SECONDS);
    }


    public void onStop(){
        //当Fragment不可见的时候停止切换
        if(mScheduledExecutorService!=null) mScheduledExecutorService.shutdownNow();
    }


}
