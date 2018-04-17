package pack.menimcellApp.seymur.azercell2.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.map.MapsActivity;
import pack.menimcellApp.seymur.azercell2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Ayar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Ayar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ayar extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Ayar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ayar.
     */
    // TODO: Rename and change types and number of parameters
    public static Ayar newInstance(String param1, String param2) {
        Ayar fragment = new Ayar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    DataUsage fMBUsage ;
    Roaming Roaming;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        inetConfig = new InternetSettings();


            fMBUsage = new DataUsage();


        Roaming = new Roaming();
    }

    InternetSettings inetConfig;
    int AppLogo = R.drawable.ic_action_bar_logo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ayar, container, false);
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).hideUpButton();
        }

        view.findViewById(R.id.simsimBtn).setOnClickListener(this);
        view.findViewById(R.id.RoamingBtn).setOnClickListener(this);
        view.findViewById(R.id.trafficUsage).setOnClickListener(this);
        view.findViewById(R.id.mapBtn).setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        if(getActivity() != null)

            ((BalanceMenu)getActivity()).AppLogo(AppLogo);
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.simsimBtn) {
            FragmentTransaction t = null;
            if (this.getFragmentManager() != null) {
                t = this.getFragmentManager().beginTransaction();
                t.replace(R.id.fragment_container,inetConfig);
                t.addToBackStack("e");
                t.commit();
            }



        }

        else if (view.getId() == R.id.RoamingBtn) {
            FragmentTransaction ft = null;
            if (this.getFragmentManager() != null) {
                ft = this.getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,Roaming,"back");
                ft.addToBackStack("back");
                ft.commit();
            }


        } else if (view.getId() == R.id.trafficUsage){
            FragmentTransaction ft = null;
            if (this.getFragmentManager() != null) {
                ft = this.getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,fMBUsage,"back");
                ft.addToBackStack("back");
                ft.commit();
            }



        }
        else if(view.getId() == R.id.mapBtn){
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            startActivity(intent);
        }
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
