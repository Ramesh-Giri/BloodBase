package com.example.admin.navigationdrawerwithswipetabs;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Register.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {

    Spinner spinner_blood;
    EditText full_name, mobnum, address;
    CheckBox sun, mon, tues, wed, thurs, fri, sat;
    Button register, cancel;
    DbHelper dbHelper;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private DonorModel mDonorModel = new DonorModel();

    String userId;

    // Declaring a Location Manager
    protected LocationManager locationManager;
    // flag for GPS status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    // flag for GPS status
    boolean canGetLocation = false;

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude


    private static final int MY_PERMISSION_REQUEST_LOCATION = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register.
     */
    // TODO: Rename and change types and number of parameters
    public static Register newInstance(String param1, String param2) {
        Register fragment = new Register();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("donors");

        // Creating new user node, which returns the unique key value
        // new user node would be /users/$userid/
        userId = mFirebaseDatabase.push().getKey();

        sun = (CheckBox) view.findViewById(R.id.sun);
        mon = (CheckBox) view.findViewById(R.id.mon);
        tues = (CheckBox) view.findViewById(R.id.tues);
        wed = (CheckBox) view.findViewById(R.id.wed);
        thurs = (CheckBox) view.findViewById(R.id.thurs);
        fri = (CheckBox) view.findViewById(R.id.fri);
        sat = (CheckBox) view.findViewById(R.id.sat);

        full_name = (EditText) view.findViewById(R.id.fullname);
        mobnum = (EditText) view.findViewById(R.id.mob_num);
        address = (EditText) view.findViewById(R.id.address);

        spinner_blood = (Spinner) view.findViewById(R.id.spinner_blood);

        cancel = (Button) view.findViewById(R.id.cancel);


        register = (Button) view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {


            String f, m, a, selectedgrp, weekday = "";

            public void onClick(View v) {

//                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
//                        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
//
//                    } else {
//                        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
//
//                    }
//                } else {
////                    LocationManager locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
////                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//                    try {
//
//                        Location location_new = getLocation();
//
//                        address.setText(hereLocation(location_new.getLatitude(), location_new.getLongitude()));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Toast.makeText(getActivity(), "Please Turn on Location", Toast.LENGTH_SHORT).show();
//                    }
//                }


                f = full_name.getText().toString();
                m = mobnum.getText().toString();
                a = "Balaju,Kathmandu";
                selectedgrp = spinner_blood.getSelectedItem().toString();

                if (sun.isChecked())
                    weekday = weekday + " " + sun.getText().toString();
                if (mon.isChecked())
                    weekday = weekday + " " + mon.getText().toString();
                if (tues.isChecked())
                    weekday = weekday + " " + tues.getText().toString();
                if (wed.isChecked())
                    weekday = weekday + " " + wed.getText().toString();
                if (thurs.isChecked())
                    weekday = weekday + " " + thurs.getText().toString();
                if (fri.isChecked())
                    weekday = weekday + " " + fri.getText().toString();
                if (sat.isChecked())
                    weekday = weekday + " " + sat.getText().toString();


                if (f.isEmpty() || m.isEmpty() || a.isEmpty()) {
                    Toast.makeText(getActivity(), "Fill all the fields", Toast.LENGTH_SHORT).show();

                } else {

                    mDonorModel.setFullname(f);
                    mDonorModel.setMobno(m);
                    mDonorModel.setAddress(a);
                    mDonorModel.setAvailable(weekday);
                    mDonorModel.setBloodgrp(selectedgrp);

                    if (TextUtils.isEmpty(userId)) {
                        userId = mFirebaseDatabase.push().getKey();
                    }

                    mFirebaseDatabase.child(userId).setValue(mDonorModel);

                    dbHelper = new DbHelper(getActivity());
                    boolean data = dbHelper.insertdetails(f, m, a, weekday, selectedgrp);
                    if (data) {
                        Toast.makeText(getActivity(), "Insertion Successful", Toast.LENGTH_SHORT).show();

                        TabFragment tabFragment = new TabFragment();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, tabFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    } else {
                        Toast.makeText(getActivity(), "Error occured", Toast.LENGTH_SHORT).show();
                        getFragmentManager().popBackStack();
                    }


                }
            }

        });

        cancel = (Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TabFragment tabFragment = new TabFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerView, tabFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        return view;
    }


    public Location getLocation() {
        try {
            locationManager = (LocationManager) getActivity()
                    .getSystemService(Context.LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        }
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST_LOCATION:{
                if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(getActivity(),android.Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                        try{
                            address.setText(hereLocation(location.getLatitude(),location.getLongitude()));
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                            Toast.makeText(getActivity(),"Not Found",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getActivity(),"No Permission granted",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

    }

    //get nearest city name
    public String hereLocation(double lat, double lon)
    {
        String curCity = "", city,area;
        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        List<Address> addressList;
        try {
            addressList = geocoder.getFromLocation(lat,lon,1);
            if(addressList.size() > 0)
            {
                city = addressList.get(0).getLocality();
                area = addressList.get(0).getAddressLine(0);

                curCity = area+", "+city;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return curCity;
    }
}
