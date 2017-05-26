package com.example.admin.navigationdrawerwithswipetabs;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RameshGiri on 4/17/2017.
 */
public class CustomPostAdapter extends BaseAdapter {


    TextView uname, post, num, add,time;
    Context c;
    List<PostModel> post_data;

    private static LayoutInflater inflater = null;



    @Override
    public int getCount() {
        return post_data.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        v = inflater.inflate(R.layout.activity_layout_help, null);


        post = (TextView) v.findViewById(R.id.upost);
        uname = (TextView) v.findViewById(R.id.uname);
        num = (TextView) v.findViewById(R.id.unum);
        add = (TextView) v.findViewById(R.id.uadd);
        time = (TextView) v.findViewById(R.id.tym);


        uname.setText(post_data.get(position).getName());
        post.setText(post_data.get(position).getPost());
        num.setText(post_data.get(position).getNumber());
        add.setText(post_data.get(position).getAddress());
        time.setText(post_data.get(position).getTime());

        return v;
    }

    public CustomPostAdapter(Context ctx, List<PostModel> cv)
    {
        this.c=ctx;
        this.post_data = cv;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
}