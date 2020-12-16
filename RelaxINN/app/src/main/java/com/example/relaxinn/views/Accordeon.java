package com.example.relaxinn.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.relaxinn.R;

public class Accordeon extends LinearLayout {
    LinearLayout container_tv_ll, ll_btn_container, ll_contenu;
    TextView tv_info;
    ImageView iv_triangule;

    Boolean onView;


    public Accordeon(Context context, String desc, @Nullable LinearLayout container) {
        super(context);
        setOrientation(VERTICAL);


        setLayoutParams(
                new LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        );

        //   setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        onView = false;
        container_tv_ll = new LinearLayout(context);
        tv_info = new TextView(context);
        iv_triangule = new ImageView(context);
        ll_btn_container = new LinearLayout(context);
        ll_contenu = new LinearLayout(context);

        ll_contenu.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ll_contenu.setOrientation(VERTICAL);

        ll_contenu.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_dark));

        ll_contenu.setVisibility(GONE);


        ll_btn_container.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 20));
        //  ll_btn_container.setBackgroundColor(context.getResources().getColor(android.R.color.black));

        tv_info.setText(desc);
        tv_info.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 80));
        tv_info.setTextSize(33);
        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        tv_info.setTypeface(boldTypeface);
        tv_info.setTextColor(context.getResources().getColor(R.color.blue));
        tv_info.setGravity(Gravity.CENTER);

        container_tv_ll.setOrientation(HORIZONTAL);

        container_tv_ll.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 240));

        // iv_triangule.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 20));
        container_tv_ll.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));

        setPadding(0, 0, 0, 10);

        ll_btn_container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("s", "funciona");

                if (onView) {
                    iv_triangule.setImageResource(R.drawable.triangulo);
                    ll_contenu.setVisibility(GONE);

                } else {
                    iv_triangule.setImageResource(R.drawable.triangulo_reverse);
                    ll_contenu.setVisibility(VISIBLE);

                }

                invalidate();
                onView = !onView;
            }
        });
        iv_triangule.setImageResource(R.drawable.triangulo);
        iv_triangule.setScaleType(ImageView.ScaleType.CENTER);
        iv_triangule.setLayoutParams(new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
        container_tv_ll.addView(tv_info);
        ll_btn_container.addView(iv_triangule);
        container_tv_ll.addView(ll_btn_container);


        addView(container_tv_ll);
        if (container != null) {
            ll_contenu.addView(container);
        }

        addView(ll_contenu);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);


    }
}
