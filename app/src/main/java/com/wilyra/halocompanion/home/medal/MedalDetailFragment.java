package com.wilyra.halocompanion.home.medal;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.wilyra.halocompanion.R;

import org.w3c.dom.Text;

/**
 * Created by wilyr on 11/25/2015.
 */
public class MedalDetailFragment extends Fragment {

    private MedalGeneralStat medal;

    public MedalDetailFragment()
    {

    }

    public static MedalDetailFragment newInstance(MedalGeneralStat ms)
    {
        MedalDetailFragment me = new MedalDetailFragment();
        me.medal = ms;
        return (me);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medal_detail_layout, container, false);

        ((TextView)view.findViewById(R.id.medalDetailTitle)).setText(String.format("%s (%s)", medal.getMedal().getName(), medal.getMedal().getClassification()));
        ((TextView)view.findViewById(R.id.medalDetailDesc)).setText(medal.getMedal().getDescription());
        final View rView = view;
        final Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Bitmap bm = Bitmap.createBitmap(bitmap,
                        medal.getMedal().getSpriteLocation().getLeft(),
                        medal.getMedal().getSpriteLocation().getTop(),
                        medal.getMedal().getSpriteLocation().getWidth(),
                        medal.getMedal().getSpriteLocation().getHeight());
                ((ImageView)rView.findViewById(R.id.medalDetailimage)).setImageBitmap(bm);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        Picasso.with(getActivity()).load(medal.getMedal().getSpriteLocation().getSpriteSheetUri()).into(target);
        return (view);
    }
}
