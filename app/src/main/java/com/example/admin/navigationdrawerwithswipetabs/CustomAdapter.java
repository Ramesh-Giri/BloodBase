package com.example.admin.navigationdrawerwithswipetabs;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RameshGiri on 4/17/2017.
 */
public class CustomAdapter extends BaseAdapter {


    ImageView call, mail;
    Context c;
    List<DonorModel> donor_data;

    private static LayoutInflater inflater = null;

    @Override
    public int getCount() {
        return donor_data.size();
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
        v = inflater.inflate(R.layout.activity_layout, null);


        TextView Fullname = (TextView) v.findViewById(R.id.name);
        final TextView number = (TextView) v.findViewById(R.id.phone);
        TextView email = (TextView) v.findViewById(R.id.mail);

        Fullname.setText(donor_data.get(position).getFullname());

        final String num = donor_data.get(position).getMobno();

        number.setText(donor_data.get(position).getMobno());
        email.setText(donor_data.get(position).getMobno());


        call = (ImageView) v.findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent call;
                call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
                if (ActivityCompat.checkSelfPermission(c, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                c.startActivity(call);

            }

        });

        mail = (ImageView)v.findViewById(R.id.mailing);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + num));
                intent.putExtra("sms_body", "I am in Emergency of blood. Help me");
                c.startActivity(intent);

            }
        });
        return v;
    }

    public CustomAdapter(Context ctx, List<DonorModel> cv)
    {
        this.c=ctx;
        this.donor_data = cv;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
}

