package com.wilyra.halocompanion.home.weapon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wilyra.halocompanion.R;

/**
 * Created by wilyr on 11/25/2015.
 */
public class WeaponElemView extends RelativeLayout {

    String mTitle;
    String mContent;

    public WeaponElemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.weapon_elem_view, this, true);
    }

    public WeaponElemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.medal_view, this, true);
    }

    public void setWeaponStat(String title, String content, TableRow.LayoutParams rp)
    {
        ((TextView)findViewById(R.id.weapon_elem_title)).setText(title);
        ((TextView)findViewById(R.id.weapon_elem_content)).setText(content);
        this.setLayoutParams(rp);
    }

}
