package pack.menimcellApp.seymur.azercell2.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.forFragments;

import static pack.menimcellApp.seymur.azercell2.R.color.white;
import static pack.menimcellApp.seymur.azercell2.fragments.Credit.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BalanceNew.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BalanceNew#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BalanceNew extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BalanceNew() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BalanceNew.
     */
    // TODO: Rename and change types and number of parameters
    public static BalanceNew newInstance(String param1, String param2) {
        BalanceNew fragment = new BalanceNew();
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
        ftransfer = new Transfer();
        fcredit = new Credit();
        froaming = new Roaming();

    }

    Context context;
    Button btnService1;
    Button btnService2;
    Button btnService3;
    Button btnService4;
    Button btnService5;
    Button btnService6;
    Button btnService7;
    Button btnService8;
    Button btnService9;
    Button btnService10;
    Context mContext;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balance_new, container, false);
        context = getContext();
        //recieve balance

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        //
        // Create Frist fragment here:
        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        // Add the fragment to the 'fragment_container' FrameLayout
        btnService1 = (Button) view.findViewById(R.id.buttonok);
        btnService1.setOnClickListener(this);
        btnService1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService1.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService1.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService1.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService1.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });
        btnService2 = (Button) view.findViewById(R.id.btnService2);
        btnService2.setOnClickListener(this);
        btnService2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService2.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService2.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService2.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService2.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService3 = (Button) view.findViewById(R.id.btnService3);
        btnService3.setOnClickListener(this);
        btnService3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService3.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService3.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService3.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService3.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService4 = (Button) view.findViewById(R.id.btnService4);
        btnService4.setOnClickListener(this);
        btnService4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService4.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService4.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService4.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService4.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService5 = (Button) view.findViewById(R.id.btnService5);
        btnService5.setOnClickListener(this);
        btnService5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService5.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService5.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService5.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService5.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService6 = (Button) view.findViewById(R.id.btnService6);
        btnService6.setOnClickListener(this);
        btnService6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService6.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService6.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService6.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService6.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService7 = (Button) view.findViewById(R.id.btnService7);
        btnService7.setOnClickListener(this);
        btnService7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService7.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService7.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService7.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService7.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService8 = (Button) view.findViewById(R.id.btnService8);
        btnService8.setOnClickListener(this);
        btnService8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService8.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService8.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService8.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService8.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService9 = (Button) view.findViewById(R.id.btnService9);
        btnService9.setOnClickListener(this);
        btnService9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService9.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService9.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService9.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService9.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });    btnService10 = (Button) view.findViewById(R.id.btnService10);
        btnService10.setOnClickListener(this);
        btnService10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("IMAGE", "motion event: " + motionEvent.toString());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        btnService10.setBackgroundResource(R.drawable.shadow_azercell_services);
                        btnService10.setPadding(0,50,0,20);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        btnService10.setBackgroundResource(R.drawable.shadow_opacity_azercell_services);
                        btnService10.setPadding(0,50,0,20);
                        break;
                    }
                }
                return false;
            }
        });

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
        mListener = null;
    }
    Transfer ftransfer;
    Credit fcredit;
    Roaming froaming;
    @Override
    public void onClick(View view) {

             if (view.getId() == R.id.buttonok) {
                 USSDcodes ussdCode = new USSDcodes();
                 Intent intentA = ussdCode.sendUssdCode(getString(R.string.balanceUSSDcode),getString(R.string.theBalanceWillSend),context);
                 startActivity(intentA);

            }
            else if(view.getId() == R.id.btnService2) {
                 Intent i = new Intent(Intent.ACTION_VIEW);
                 i.setData(Uri.parse("https://azercell.3dsecure.az/"));
                 if(getActivity() != null)
                     getActivity().startActivity(i);
             }
             else if(view.getId() == R.id.btnService3) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","credit");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService4) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","transfer");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService5) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","roaming");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService6) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","internet");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService7) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","callforwarding");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService8) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","callbarring");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService9) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","callscreening");
                 startActivity(intent);
             }
             else if(view.getId() == R.id.btnService10) {
                 Intent intent = new Intent(getActivity(), forFragments.class);
                 intent.putExtra("fragment","gizletcell");
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
