package com.example.admin.navigationdrawerwithswipetabs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link List_Donors.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link List_Donors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List_Donors extends Fragment {

    ListView donor_list;
    DbHelper dbhelper;

    View view;
    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransaction;

    Button menu_button;
    Handler handler = new Handler();
    Runnable refresh;

    DonorModel donorModel;
    ArrayList<String> people = new ArrayList<>();
//    final String[] AposDonors = {"A","P ", "O", "S"};
//    final String[] AnegDonors = {"A","N ", "E", "G"};
//    final String[] BposDonors = {"B","P ", "O", "S"};
//    final String[] BnegDonors = {"B","N ", "E", "G"};
//    final String[] ABposDonors = {"AB","P ", "O", "S"};
//    final String[] ABnegDonors = {"AB","N ", "E", "G"};
//    final String[] OposDonors = {"O","P ", "O", "S"};
//    final String[] OnegDonors = {"O","N ", "E", "G"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public List_Donors() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static List_Donors newInstance(String param1) {
        List_Donors fragment = new List_Donors();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
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

        view= inflater.inflate(R.layout.fragment_list__donors, container, false);

        String click_value = getArguments().getString("clicked_id");

        menu_button = (Button) view.findViewById(R.id.menubutton);

        donor_list = (ListView) view.findViewById(R.id.list_Aposdonors);

        if (click_value== "apos") {

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("A+ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);



        }

        else if(click_value== "aneg"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("A-ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);



           }

        else if(click_value== "bpos"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("B+ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);

        }

        else if(click_value== "bneg"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("B-ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);
        }

        else if(click_value== "abpos"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("AB+ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);
        }

        else if(click_value== "abneg"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("AB-ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);

        }

        else if(click_value== "opos"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("O-ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);

        }

        else if(click_value== "oneg"){

            dbhelper = new DbHelper(getActivity());
            Cursor data = dbhelper.getdonordetail("O-ve");

            Log.e("data",data.toString());
            data.getCount();
            dataextraction(data);
        }


        return view;
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(DonorModel bundle) {
        if (mListener != null) {
            mListener.onFragmentInteraction(bundle);
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
        void onFragmentInteraction(DonorModel bundle);
    }




public void dataextraction(Cursor data )
{
    if (data.getCount() > 0) {
        //CVmodel is a new datatype (object of class CVmodel); works same as the structure data type (collection of multiple datatypes and making one)
        final ArrayList<DonorModel> donor_details = new ArrayList<>();

        ArrayList<String> fullname_show = new ArrayList<>();
        while (!data.isLast()) {


            data.moveToNext();
            int id = data.getColumnIndex("id");
            int fullname = data.getColumnIndex("Fullname");
            int mobno = data.getColumnIndex("Mobno");
            int address = data.getColumnIndex("Address");
            int available = data.getColumnIndex("Available");
            int bloodgrp = data.getColumnIndex("BloodGrp");


            final String id_data = data.getString(id);
            String fullname_data = data.getString(fullname);
            String mobno_data = data.getString(mobno);
            String address_data = data.getString(address);
            String available_data = data.getString(available);
            String bloodgrp_data = data.getString(bloodgrp);

            final DonorModel donormodel = new DonorModel();
            donormodel.setId(id_data);
            donormodel.setFullname(fullname_data);
            donormodel.setMobno(mobno_data);
            donormodel.setAddress(address_data);
            donormodel.setAvailable(available_data);
            donormodel.setBloodgrp(bloodgrp_data);

            donor_details.add(donormodel);
            fullname_show.add(fullname_data);


            //  Log.e("fullname",fullname_data);



            // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, fullname_show);

            CustomAdapter listsadapter = new CustomAdapter(getActivity(), donor_details);
            donor_list.setAdapter(listsadapter);


            donor_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                               int index, long arg3) {

                    PopupMenu popupMenu = new PopupMenu(getActivity(),menu_button);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.delete:
                                    dbhelper = new DbHelper(getActivity());
                                    dbhelper.deletedonor(id_data);
                                    Toast.makeText(getActivity().getApplicationContext(),"Entry deleted successfully!!! ",Toast.LENGTH_LONG).show();
                                    break;

                                case R.id.share:
                                    Toast.makeText(getActivity().getApplicationContext(),"Under Construction ",Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.edit:
                                    Toast.makeText(getActivity().getApplicationContext(),"Under Construction ",Toast.LENGTH_LONG).show();
                                    break;

                                default:
                                    break;

                            }
                            return true;
                        }

                    });

                    popupMenu.show();
                    return true;
                }
            });

            donor_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                    Toast.makeText(getActivity(), parent.getAdapter().getItem(position).toString(), Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    //Bundle can be used to send multiple datatypes and object at a time to another page
                    bundle.putSerializable("details", donormodel);

                    Details details = new Details();
                    details.setArguments(bundle);

                     fragmentmanager = getFragmentManager();
                     fragmenttransaction = getFragmentManager().beginTransaction();

                    fragmenttransaction.replace(R.id.containerView, details);
                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };
                }
            });




        }
    }

   }
}

