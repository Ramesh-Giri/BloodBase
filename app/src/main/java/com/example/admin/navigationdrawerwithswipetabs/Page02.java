package com.example.admin.navigationdrawerwithswipetabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class
Page02 extends Fragment{

    ExpandableAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Page02() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page02.
     */
    // TODO: Rename and change types and number of parameters
    public static Page02 newInstance(String param1, String param2) {
        Page02 fragment = new Page02();
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
        View view =  inflater.inflate(R.layout.fragment_page2, container, false);

        expListView = (ExpandableListView)view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("HOSPITAL");
        listDataHeader.add("AMBULANCE");
        listDataHeader.add("ELECTRICITY(Power Failure)");
        listDataHeader.add("FUNERAL VEHICLES");
        listDataHeader.add("POLICE STATION");
        listDataHeader.add("TELECOMMUNICATIONS");
        listDataHeader.add("OTHERS");

        // Adding child data
        List<String> hospitals = new ArrayList<String>();
        hospitals.add("Bir Hospital" +"                    " + "01-221988");
        hospitals.add("Patan Hospital (Lagankhel)" +"             " + "4522278");
        hospitals.add("Teaching Hospital (Maharajgunj)" +"    " + "4412707/4412505/4412808");
        hospitals.add("B & B Hospital (Gwarko)" +"          " + "4351930/4533206");
        hospitals.add("Teku Hospital (Teku)" +"             " + "4253396");
        hospitals.add("Blood Bank" +"                    " + "4225344");
        hospitals.add("Tilganga Eye Centre" +"          " + "4476575/4474937");
        hospitals.add("Kanti Children Hospital" +"          " + "4414798/4427452");
        hospitals.add("Kathmandu Model Hospital" +"          " + "4240805");
        hospitals.add("Medicare National Hospital" +"           " + "4467067");
        hospitals.add("Norvic Hospital" +"               " + "4258554");
        hospitals.add("National Kidney Centre" +"         " + "4429866/4426016");
        hospitals.add("Maternity Hospital" +"                    " + "4253276");


        List<String> ambulance = new ArrayList<String>();
        ambulance.add("Nepal Ambulance Service" +"                    " + "102");
        ambulance.add("Ambulance, Bishal Bazaar" +"                    " + "4244121");
        ambulance.add("Ambulance, Nepal Chamber" +"               " + "4230213/4222890");
        ambulance.add("Ambulance, Paropakar" +"               " + "4251614/4260869");
        ambulance.add("Ambulance, Red Cross" +"                    " + "4228094");
        ambulance.add("Lions Club of Kathmandu Central, Kathmandu" +"          " + "4472211");


        List<String> electricity = new ArrayList<String>();
        electricity.add(" Balaju" +"                    " + "4350896");
        electricity.add(" Baneshwor" +"               " + "4474161, 4471201");
        electricity.add(" Chabahil" +"                    " + "4474164");
        electricity.add("Kirtipur " +"                    " + "4330428");
        electricity.add("Maharajgunj " +"                    " + "4357219");
        electricity.add(" Kuleshwor" +"               " + "4272404, 4272402");
        electricity.add(" Ratna Park" +"               " + "4227061, 4225584");
        electricity.add("Lagankhel" +"               " + "5525618, 5521365");
        electricity.add(" Pulchowk" +"               " + "5523061, 5522043");
        electricity.add(" Bhaktapur" +"                    " + "6610065");
        electricity.add(" Thimi (Old)" +"                    " + "6610126");
        electricity.add("Thimi (New) " +"               " + "6610065, 6610319");


        List<String> funrlVeh = new ArrayList<String>();
        funrlVeh.add("Bir Hospital, Tundikhel" +"               " + "4221119");
        funrlVeh.add("Nepal Chamber of Commerce, Kantipath" +"     " + "4222890, 4230213");
        funrlVeh.add("Marwadi Sewa Samati, Phasikeb" +"       " + "4255540,4255740");
        funrlVeh.add("Nepal Tours Vehicle" +"          " + "+977 1 4002108");


        List<String> police = new ArrayList<String>();
        police.add("Police (Emergency)" +"                    " + "100");
        police.add("Central Jail Guard, Tripureshwor" +"           " + "4253398, 4253308");
        police.add("Dilli Bazar Khar Guard, Charkhal" +"           " + "4414335");
        police.add("District Police Office, Kathmandu" +"          " + "4261790, 4261945");
        police.add("District Police Office, Lalitpur" +"           " + "5521350, 5521207");
        police.add("District Police Office, Bhaktapur" +"         " + "6614821, 6614708");
        police.add("Interpol Section, Naxal" +"                    " + "4411210, 4412602");
        police.add("Police Traffic Office, Ramshah Path" +"                    " + "4227348, 4227351");
        police.add("Regional Police Unit Office, Hanumandhoka" +"                    " + "4262945, 4261360");

        List<String> telecom = new ArrayList<String>();
        telecom.add("Complaint for Maintenance, (Telephone,Telex)" +"         " + "198");
        telecom.add("Domestic Trunk, (Via Operator)" +"               " + "180");
        telecom.add("Enquiry" +"               " + "197");
        telecom.add("International Trunk Booking (For only India Through Operator)" +"     " + "187");
        telecom.add("Overseas Trunk Booking, (Via Operator)" +"          " + "186");
        telecom.add("STD & ISD Maintenance" +"               " + "182");



        List<String> Others = new ArrayList<String>();

        Others.add("Fire Brigade" +"                    " + "101");
        Others.add("Tourist Police (Bhrikuti Mandap)" +"             " + "4226359/4226403");
        Others.add("Nepal Tourism Board" +"                    " + "4256909/4256229");
        Others.add("Night Taxi" +"                    " + "4224374");
        Others.add("Tribhuvan International Airport (TIA)" +"                    " + "4472256/4472257");
        Others.add("KEEP (Kathmandu Environmental Education Project)" +"               " + "4259275");
        Others.add("Department of Immigration" +"                  " + "4223509/4222453");
        Others.add("International Flight Services, Kathmandu" +"                  " + "4470311, 4472835");
        Others.add("Night Taxi Service, Dharmapath" +"         " + "4244485, 4224375");
        Others.add("" +"                  " + "");


        listDataChild.put(listDataHeader.get(0), hospitals); // Header, Child data
        listDataChild.put(listDataHeader.get(1), ambulance);
        listDataChild.put(listDataHeader.get(2), electricity);
        listDataChild.put(listDataHeader.get(3), funrlVeh);
        listDataChild.put(listDataHeader.get(4), police);
        listDataChild.put(listDataHeader.get(5), telecom);
        listDataChild.put(listDataHeader.get(6), Others );
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
}
