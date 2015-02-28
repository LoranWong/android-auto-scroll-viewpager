package com.bao.android_auto_scroll_viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {
    PagerScheduleProxy pagerScheduleProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(imagePagerAdapter);

        //按如下顺序配置定时器
        circleIndicator.setViewPager(viewPager);
        pagerScheduleProxy = new PagerScheduleProxy(viewPager, 2); //param 2 is interval(s)
        circleIndicator.setOnPageChangeListener(pagerScheduleProxy.getOnPageChangeListener());

    }

    @Override
    public void onStart() {
        super.onStart();
        if(pagerScheduleProxy!=null) pagerScheduleProxy.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(pagerScheduleProxy!=null) pagerScheduleProxy.onStop();
    }


}
