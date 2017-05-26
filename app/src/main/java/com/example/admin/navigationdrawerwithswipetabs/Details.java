package com.example.admin.navigationdrawerwithswipetabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Details.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Details extends Fragment {

    TextView fullname, mobno, address, available, bloodgrp;
    Button cancel;
    DonorModel donormodel;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String ARG_model = "details";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Details() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Details newInstance(DonorModel bundle) {
        Details fragment = new Details();

        Bundle args = new Bundle();

        args.putSerializable(ARG_model, bundle);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            donormodel = (DonorModel) getArguments().getSerializable(ARG_model);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_details, container, false);

        fullname = (TextView)view.findViewById(R.id.d_fullname);
        mobno = (TextView)view.findViewById(R.id.d_mobno);
        address = (TextView)view.findViewById(R.id.d_address);
        available = (TextView)view.findViewById(R.id.d_available);
        bloodgrp = (TextView)view.findViewById(R.id.d_bloodgrp);

//        cancel = (Button)view.findViewById(R.id.d_cancel);
//       cancel.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//           }
//       });


            fullname.setText(donormodel.getFullname());
            mobno.setText(donormodel.getMobno());
            address.setText(donormodel.getAddress());
            available.setText(donormodel.getAvailable());
            bloodgrp.setText(donormodel.getBloodgrp());


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(DonorModel uri) {
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
        void onFragmentInteraction(DonorModel uri);
    }
}
