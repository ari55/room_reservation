package com.example.relaxinn.views;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.relaxinn.R;
import com.example.relaxinn.entity.Room;

public class ServicesStructure extends LinearLayout {
    LinearLayout ll_smoke_breakfast_container, ll_linch_dinner_container;
    ImageView smoke, breakfast, lunch, dinner;

    public ServicesStructure(Context context, Room room) {
        super(context);

        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setOrientation(VERTICAL);

        ll_smoke_breakfast_container = new LinearLayout(context);
        ll_linch_dinner_container = new LinearLayout(context);

        ll_smoke_breakfast_container.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 5));
        ll_linch_dinner_container.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 5));
        ll_smoke_breakfast_container.setOrientation(HORIZONTAL);
        ll_linch_dinner_container.setOrientation(HORIZONTAL);

        smoke = new ImageView(context);
        breakfast = new ImageView(context);
        lunch = new ImageView(context);
        dinner = new ImageView(context);

        smoke.setLayoutParams(new LayoutParams(400, 400));
        breakfast.setLayoutParams(new LayoutParams(400, 400));

        lunch.setLayoutParams(new LayoutParams(400, 400));
        dinner.setLayoutParams(new LayoutParams(400, 400));

        smoke.setScaleType(ImageView.ScaleType.FIT_XY);
        breakfast.setScaleType(ImageView.ScaleType.FIT_XY);

        lunch.setScaleType(ImageView.ScaleType.FIT_XY);
        dinner.setScaleType(ImageView.ScaleType.FIT_XY);

        lunch.setImageResource(R.drawable.lunch);
        dinner.setImageResource(R.drawable.cena);
        if (room.isSmoker()) {

            smoke.setImageResource(R.drawable.fumeur);
        } else {

            smoke.setImageResource(R.drawable.fumeur_negative);
        }

        breakfast.setImageResource(R.drawable.break_fast);

        ll_smoke_breakfast_container.addView(smoke);
        ll_smoke_breakfast_container.addView(breakfast);

        ll_linch_dinner_container.addView(lunch);
        ll_linch_dinner_container.addView(dinner);

        addView(ll_smoke_breakfast_container);
        addView(ll_linch_dinner_container);
    }
}
