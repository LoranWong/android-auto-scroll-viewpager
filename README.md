# android-auto-scroll-viewpager
android viewpager which can auto scroll at specific interval
可以定时滚动的轮播推荐  viewpager

viewpager uses 使用 [CircleIndicator](https://github.com/ongakuer/CircleIndicator)

![image](https://github.com/JackWong025/android-auto-scroll-viewpager/blob/master/sample.gif)

#### In Xml
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    
        <android.support.v4.view.ViewPager
            android:id="@+id/viewpager"
            android:focusable="false"
            android:focusableInTouchMode="false"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:background="#cccccc" />
    
    
        <com.bao.android_auto_scroll_viewpager.CircleIndicator
            android:id="@+id/indicator"
            android:focusable="false"
            android:focusableInTouchMode="false"
            android:layout_alignParentBottom="true"
            android:layout_marginBottom="10dp"
            android:layout_centerHorizontal="true"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    
    
    </RelativeLayout>



    
#### In Java Code

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(imagePagerAdapter);

        //按如下顺序配置定时器
        circleIndicator.setViewPager(viewPager);
        pagerScheduleProxy = new PagerScheduleProxy(viewPager, 2); //param 2 is interval(s)
        circleIndicator.setOnPageChangeListener(pagerScheduleProxy.getOnPageChangeListener());


