package com.bao.android_auto_scroll_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {

    private int drawableId;

    public static ImageFragment newInstance(int drawableId) {
        ImageFragment fragment = new ImageFragment();
        fragment.setDrawableId(drawableId);
        return fragment;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        ((ImageView)view.findViewById(R.id.imagefragment_image)).setImageResource(drawableId);

        return view;
    }
}
