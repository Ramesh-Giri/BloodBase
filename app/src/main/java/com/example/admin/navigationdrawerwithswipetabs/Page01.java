package com.example.admin.navigationdrawerwithswipetabs;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Page01.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Page01#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page01 extends Fragment {


    ListView help_list;
    DbHelper dbhelper;


    EditText name,number,post,address,set_time;
    LinearLayout inputs;
    Button submit;
    Button ask;
    DbHelper dbHelper;

    String PostId;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    View view;

    private PostModel postModel = new PostModel();


    private static final int MY_PERMISSION_REQUEST_LOCATION = 1;


    //    final String[] list_help = {"H","E","L","P","M","E","O","u","t","help"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Page01() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page01.
     */
    // TODO: Rename and change types and number of parameters
    public static Page01 newInstance(String param1, String param2) {
        Page01 fragment = new Page01();
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
        view = inflater.inflate(R.layout.fragment_page1, container, false);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("Posts");

        // Creating new user node, which returns the unique key value
        // new user node would be /users/$userid/
        PostId = mFirebaseDatabase.push().getKey();

        name=(EditText) view.findViewById(R.id.fname);
        post=(EditText) view.findViewById(R.id.post);
        number=(EditText) view.findViewById(R.id.numb);
        address=(EditText) view.findViewById(R.id.adres);
        submit = (Button) view.findViewById(R.id.submit);
        ask = (Button) view.findViewById(R.id.ask4help);
        set_time = (EditText) view.findViewById(R.id.set_time);
        inputs= (LinearLayout)view.findViewById(R.id.inputs);

        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        set_time.setText(mydate);

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ask.setVisibility(View.INVISIBLE);
                inputs.setVisibility(View.VISIBLE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            String nm,pst,add,num,tym;

            @Override

            public void onClick(View v) {
//                if(ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
//                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)){
//                        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_LOCATION);
//
//                    }else {
//                        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_LOCATION);
//
//                    }
//                }else {
//                    LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
//                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//
//                    try{
//                        address.setText(hereLocation(location.getLatitude(),location.getLongitude()));
//                    }catch (Exception e)
//                    {
//                        e.printStackTrace();
//                        Toast.makeText(getActivity(),"Please Turn on Location",Toast.LENGTH_SHORT).show();
//                    }
//                }

                nm = name.getText().toString();
                pst = post.getText().toString();
                add = "Balaju,Kathmandu";
                num = number.getText().toString();
                tym = set_time.getText().toString();

                if(nm.isEmpty() || pst.isEmpty() || add.isEmpty() || num.isEmpty())
                {
                    Toast.makeText(getActivity(), "Fill all the fields", Toast.LENGTH_SHORT).show();

                }

                else {

                    postModel.setName(nm);
                    postModel.setNumber(num);
                    postModel.setAddress(add);
                    postModel.setPost(pst);
                    postModel.setTime(tym);

                    if (TextUtils.isEmpty(PostId)) {
                        PostId = mFirebaseDatabase.push().getKey();
                    }
                    mFirebaseDatabase.child(PostId).setValue(postModel);


                    dbHelper = new DbHelper(getActivity());
                    boolean data = dbHelper.insertpost(nm,num,add,pst,tym);
                    if(data) {

                        ask.setVisibility(View.VISIBLE);
                        inputs.setVisibility(View.INVISIBLE);

                        Toast.makeText(getActivity(), "Insertion Successful!!!", Toast.LENGTH_SHORT).show();
                        TabFragment tabFragment = new TabFragment();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, tabFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();


                    }
                    else {
                        Toast.makeText(getActivity(), "Error occured", Toast.LENGTH_SHORT).show();
                        getFragmentManager().popBackStack();
                    }
                }

            }
        });

        help_list = (ListView)view.findViewById(R.id.list_help);

        dbhelper = new DbHelper(getActivity());
        Cursor posts = dbhelper.getposts();

        final ArrayList<PostModel> post_details = new ArrayList<>();
        if(posts.getCount() > 1)
        {
            while (!posts.isLast()) {
                posts.moveToNext();
                int fullname = posts.getColumnIndex("Fullname");
                int mob = posts.getColumnIndex("Mobno");
                int add = posts.getColumnIndex("Address");
                int post = posts.getColumnIndex("Post");
                int time = posts.getColumnIndex("Time");

                String fullname_data = posts.getString(fullname);
                String mob_data = posts.getString(mob);
                String add_data = posts.getString(add);
                String post_data = posts.getString(post);
                String time_data = posts.getString(time);


                final PostModel postModel = new PostModel();
                postModel.setName(fullname_data);
                postModel.setNumber(mob_data);
                postModel.setAddress(add_data);
                postModel.setPost(post_data);
                postModel.setTime(time_data);

                post_details.add(postModel);

                CustomPostAdapter customPostAdapter = new CustomPostAdapter(getActivity(), post_details);
                help_list.setAdapter(customPostAdapter);
            }


        }
        return view;
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
