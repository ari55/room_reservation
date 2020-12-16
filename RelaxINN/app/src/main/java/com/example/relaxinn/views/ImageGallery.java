package com.example.relaxinn.views;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.relaxinn.R;

public class ImageGallery extends LinearLayout {

    HorizontalScrollView hsv_gallery;
    LinearLayout ll_gallery;
    ImageView image_room_lit, image_room_toilet, image_room_salon;
    ImageView[] images;

    public ImageGallery(Context context, int id) {
        super(context);
        hsv_gallery = new HorizontalScrollView(context);
        ll_gallery = new LinearLayout(context);
        hsv_gallery.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ll_gallery.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ll_gallery.setOrientation(HORIZONTAL);


        image_room_lit = new ImageView(context);
        image_room_lit.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        image_room_lit.setScaleType(ImageView.ScaleType.FIT_XY);

        image_room_toilet = new ImageView(context);
        image_room_toilet.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        image_room_toilet.setScaleType(ImageView.ScaleType.FIT_XY);

        image_room_salon = new ImageView(context);
        image_room_salon.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        image_room_salon.setScaleType(ImageView.ScaleType.FIT_XY);

        Log.v("id", "" + id);
        switch (id) {
            case 1:
            case 9:

                image_room_lit.setImageResource(R.drawable.chambre_deux_lits_simples_au_calme);
                image_room_salon.setImageResource(R.drawable.chambre_deux_lit_salon);
                image_room_toilet.setImageResource(R.drawable.chambre_deux_toilete);
                break;
            case 2:

                image_room_lit.setImageResource(R.drawable.chambre_une_lit_double_au_calme_lit);
                image_room_salon.setImageResource(R.drawable.chambre_une_lit_double_au_calme_toilet_salon);
                image_room_toilet.setImageResource(R.drawable.chambre_une_lit_double_au_calme_toilet);
                break;
            case 7:
            case 3:
                image_room_lit.setImageResource(R.drawable.chambre_familiale_lit_double);
                image_room_salon.setImageResource(R.drawable.chambre_familiale_lit_unite);
                image_room_toilet.setImageResource(R.drawable.chambre_familiale_lit_unite_toilete);
                break;

            case 4:

                image_room_lit.setImageResource(R.drawable.chambre_hotel_amoreux_lit);
                image_room_salon.setImageResource(R.drawable.chambre_hotel_amoreux_kamasutra);
                image_room_toilet.setImageResource(R.drawable.chambre_hotel_amoreux_toilet);
                break;

            case 5:
                image_room_lit.setImageResource(R.drawable.chambre_swingers_lit);
                image_room_salon.setImageResource(R.drawable.chambre_swingers_salon);
                image_room_toilet.setImageResource(R.drawable.chambre_swingers_toilet);
                break;
            case 6:
                image_room_lit.setImageResource(R.drawable.chambre_deux_lit_simple_lit);
                image_room_salon.setImageResource(R.drawable.chambre_deux_lit_simple_salon);
                image_room_toilet.setImageResource(R.drawable.chambre_deux_lit_simple_toilet);
                break;

            case 8:
                image_room_lit.setImageResource(R.drawable.chambre_lit_double);
                image_room_salon.setImageResource(R.drawable.chambre_lit_double_salon);
                image_room_toilet.setImageResource(R.drawable.chambre_lit_double_toilet);

                break;

          /*  default:

                break;*/
        }


        ll_gallery.addView(image_room_lit);
        ll_gallery.addView(image_room_salon);
        ll_gallery.addView(image_room_toilet);


        hsv_gallery.addView(ll_gallery);

        addView(hsv_gallery);
    }
    /*
    *
    *

                <ImageView
                    android:layout_width="250dp"
                    android:layout_height="match_parent"
                    android:scaleType="fitXY"
                    android:src="@drawable/doublebedsample" />

                <ImageView
                    android:layout_width="250dp"
                    android:layout_height="match_parent"
                    android:scaleType="fitXY"
                    android:src="@drawable/doublebedsample" />

                <ImageView
                    android:layout_width="250dp"
                    android:layout_height="match_parent"
                    android:scaleType="fitXY"
                    android:src="@drawable/doublebedsample" />

            </LinearLayout>


        </HorizontalScrollView>
    </LinearLayout>
    *
    * */
}
