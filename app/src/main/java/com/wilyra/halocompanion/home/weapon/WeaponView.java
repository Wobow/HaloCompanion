package com.wilyra.halocompanion.home.weapon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.wilyra.halocompanion.R;

/**
 * Created by wilyr on 11/25/2015.
 */
public class WeaponView extends RelativeLayout {


    public WeaponView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.weapons_view, this, true);
    }

    public WeaponView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.medal_view, this, true);
    }

    public void setWeaponStat(final WeaponGeneralStat ws)
    {
        final LinearLayout container = ((LinearLayout) findViewById(R.id.weapon_view_container));
        final RelativeLayout bglol = ((RelativeLayout) findViewById(R.id.background_weapon));
        final Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                bglol.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        container.setTag(target);
        Picasso.with(getContext()).load(ws.getWeapon().getSmallIconImageUrl()).into(((ImageView)findViewById(R.id.weapon_view_image)));
        //Picasso.with(getContext()).load(ws.getWeapon().getSmallIconImageUrl()).into(target);
        TableRow.LayoutParams rp = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.2f);
        rp.gravity = Gravity.CENTER_VERTICAL;
        WeaponElemView wem = new WeaponElemView(getContext());
        wem.setWeaponStat(ws.getWeapon().getName(), ws.getTotalKills() + " Kills", rp);
        container.addView(wem);
        wem = new WeaponElemView(getContext());
        wem.setWeaponStat("Headshots", ws.getTotalHeadshots(), rp);
        container.addView(wem);
        wem = new WeaponElemView(getContext());
        wem.setWeaponStat("Shots Fired", ws.getTotalShotsFired(), rp);
        container.addView(wem);
        wem = new WeaponElemView(getContext());
        wem.setWeaponStat("Accuracy", (Float.parseFloat(ws.getTotalShotsLanded()) == 0 || Float.parseFloat(ws.getTotalShotsFired()) == 0) ? "100%"  : String.format("%.0f%%", Float.parseFloat(ws.getTotalShotsLanded()) / (Float.parseFloat(ws.getTotalShotsFired())) * 100), rp);
        container.addView(wem);
    }

}