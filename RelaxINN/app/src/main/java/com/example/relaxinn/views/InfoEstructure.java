package com.example.relaxinn.views;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoEstructure extends LinearLayout {
    ImageView img_view;
    TextView tv_implementation;

    public InfoEstructure(Context context, String text, int img) {
        super(context);

        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        setOrientation(HORIZONTAL);

        tv_implementation = new TextView(context);

        tv_implementation.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 70));
        tv_implementation.setTextSize(30);
        tv_implementation.setTextColor(Color.BLACK);
        tv_implementation.setText(text);

        addView(tv_implementation);

        img_view = new ImageView(context);
        img_view.setLayoutParams(new LayoutParams(0, 400, 40));

        img_view.setScaleType(ImageView.ScaleType.FIT_XY);
        img_view.setImageResource(img);

        addView(img_view);


    }
}
