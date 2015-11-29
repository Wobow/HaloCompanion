package com.wilyra.halocompanion.matches;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.wilyra.halocompanion.MetadataContainer;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.haloapi.model.Map;
import com.wilyra.halocompanion.haloapi.model.gamevariant.GameVariant;
import com.wilyra.halocompanion.haloapi.model.match.Result;

import java.util.UUID;

/**
 * Created by wilyr on 11/27/2015.
 */
public class MatchAdapter extends ArrayAdapter<Result> implements IMetaDataAdapter {
    private final Context mContext;
    private final Result[] values;
    private MetadataContainer metadataContainer;
    static class ViewHolderMatch {
        TextView mapName;
        TextView gameMode;
        TextView killsNbr;
        ImageView mapImage;
    }

    public MatchAdapter(Context context, Result[] values) {
        super(context, R.layout.match_view, values);
        this.mContext = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolderMatch viewHolder;

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.match_view, parent, false);

            viewHolder = new ViewHolderMatch();
            viewHolder.gameMode = (TextView) convertView.findViewById(R.id.gameType);
            viewHolder.killsNbr = (TextView) convertView.findViewById(R.id.killsView);
            viewHolder.mapImage = (ImageView) convertView.findViewById(R.id.mapImage);
            viewHolder.mapName = (TextView) convertView.findViewById(R.id.mapVariant);
            convertView.setTag(viewHolder);

        } else{
            viewHolder = (ViewHolderMatch) convertView.getTag();
        }
        final UUID mapId = values[position].getMapId();
        Bitmap bm = metadataContainer.getMapImageFromId(mapId);
        Map map = metadataContainer.getMapWithId(mapId);
        if (bm == null) {
            Picasso.with(getContext()).load(map.getImageUrl()).resize(192, 108).centerCrop().into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    metadataContainer.setMapImageFromId(bitmap, mapId);
                    viewHolder.mapImage.setImageBitmap(bitmap);
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
        } else {
            viewHolder.mapImage.setImageBitmap(bm);
        }


        viewHolder.mapName.setText(map.getName());
        viewHolder.killsNbr.setText(String.valueOf(values[position].getPlayers()[0].getTotalKills()));
        viewHolder.gameMode.setText(getGameMode(values[position].getId().getGameMode()));
        return (convertView);
    }

    private String getGameMode(int gameMode) {
        switch (gameMode) {
            case 1:
                return ("Arena");
            case 2:
                return ("Campaign");
            case 3:
                return ("Custom");
            case 4:
                return ("Warzone");
            default:
                return ("Unknown");
        }
    }

    @Override
    public void setMedataData(MetadataContainer container) {
        this.metadataContainer = container;
    }
}