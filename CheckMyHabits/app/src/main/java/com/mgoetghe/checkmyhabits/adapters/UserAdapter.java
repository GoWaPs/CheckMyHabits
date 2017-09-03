package com.mgoetghe.checkmyhabits.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgoetghe.checkmyhabits.R;
import com.mgoetghe.checkmyhabits.models.User;

import java.util.List;

/**
 * Created by mgoet on 03-09-17.
 */

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_element,parent, false);
        }

        UserViewHolder viewHolder = (UserViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new UserViewHolder();
            viewHolder.userNameTextView = (TextView) convertView.findViewById(R.id.user_name);
            viewHolder.userIconImage = (ImageView) convertView.findViewById(R.id.user_icon);
            convertView.setTag(viewHolder);
        }

        User user = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.userNameTextView.setText(user.getName());
        viewHolder.userIconImage.setImageResource(user.getIconId());

        return convertView;
    }

    private class UserViewHolder{
        public TextView userNameTextView;
        public ImageView userIconImage;
    }
}
