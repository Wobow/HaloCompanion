package com.wilyra.halocompanion.home.medal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.wilyra.halocompanion.R;

/**
 * Created by wilyr on 11/25/2015.
 */
public class MedalView extends RelativeLayout {
    private TextView mMedalTitle;
    private TextView mMedalValue;

    public ImageView getmMedalImage() {
        return mMedalImage;
    }

    public TextView getmMedalValue() {
        return mMedalValue;
    }

    public TextView getmMedalTitle() {
        return mMedalTitle;
    }

    private ImageView mMedalImage;

    public MedalView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.medal_view, this, true);
        mMedalValue = (TextView) findViewById(R.id.medalValue);
        mMedalImage = (ImageView) findViewById(R.id.medalDetailimage);
    }

    public MedalView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.medal_view, this, true);
    }

    public void setMedalStat(final MedalGeneralStat ms)
    {
        mMedalValue = (TextView) findViewById(R.id.medalValue);
        mMedalImage = (ImageView) findViewById(R.id.medalDetailimage);
        final Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Bitmap bm = Bitmap.createBitmap(bitmap,
                        ms.getMedal().getSpriteLocation().getLeft(),
                        ms.getMedal().getSpriteLocation().getTop(),
                        ms.getMedal().getSpriteLocation().getWidth(),
                        ms.getMedal().getSpriteLocation().getHeight());
                mMedalImage.setImageBitmap(bm);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Log.e("Picasso Error", "Error while loading image");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        };
        mMedalImage.setTag(target);
        Picasso.with(getContext()).load(ms.getMedal().getSpriteLocation().getSpriteSheetUri()).into(target);
        mMedalValue.setText(String.valueOf(ms.getCount()));
    }

}