package com.wilyra.halocompanion.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.calendarapi.model.User;
import com.wilyra.halocompanion.haloapi.tasks.EmblemImageTask;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilyr on 11/29/2015.
 */
public class UserAdapter extends ArrayAdapter<User> {



    static class ViewHolderUser {
        TextView userName;
        TextView userGamertag;
        ImageView userEmblem;
    }

    List<User> users;
    List<Bitmap> bitmaps = new ArrayList<>();
    Context mContext;

    public UserAdapter(Context context, User[] users) {
        super(context, R.layout.user_layout, users);
        this.users = new ArrayList<>();
        this.mContext = context;
        for (User u : users) {
            this.users.add(u);
            this.bitmaps.add(null);
        }
    }

    public UserAdapter(Context context, List<User> users) {
        super(context, R.layout.user_layout, users);
        this.mContext = context;
        this.users = new ArrayList<>(users);
        for (int i = 0; i < users.size(); i++)
            bitmaps.add(null);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolderUser viewHolder;

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.user_layout, parent, false);

            viewHolder = new ViewHolderUser();
            viewHolder.userName = (TextView) convertView.findViewById(R.id.userLogin);
            viewHolder.userGamertag = (TextView) convertView.findViewById(R.id.userGamertag);
            viewHolder.userEmblem = (ImageView) convertView.findViewById(R.id.emblemImageView);

            convertView.setTag(viewHolder);

        } else{
            viewHolder = (ViewHolderUser) convertView.getTag();
        }

        User item = this.users.get(position);

        if (item != null) {
            viewHolder.userName.setText(item.getLogin());
            viewHolder.userGamertag.setText(item.getGamerTag());
            if (bitmaps.get(position) == null) {
                EmblemImageTask emblemImageTask = new EmblemImageTask();
                emblemImageTask.setOnTaskFinishedListener(new EmblemImageTask.OnEmblemImageTaskFinishedListener() {
                    @Override
                    public MainActivity getMainActivity() {
                        return (MainActivity) mContext;
                    }

                    @Override
                    public void onEmblemImageTaskFinishedListener(Bitmap bm) {
                        if (bm == null)
                            bitmaps.set(position, BitmapFactory.decodeResource(((Activity) mContext).getResources(), android.R.drawable.ic_menu_help));
                        else
                            bitmaps.set(position, bm);
                        viewHolder.userEmblem.setImageBitmap(bitmaps.get(position));
                    }
                });
                emblemImageTask.execute(item.getGamerTag());
            } else
                viewHolder.userEmblem.setImageBitmap(bitmaps.get(position));
        }

        return convertView;
    }
}
