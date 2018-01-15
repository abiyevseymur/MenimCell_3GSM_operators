package com.example.seymur.azercell2.fragments;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seymur.azercell2.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

import static com.example.seymur.azercell2.R.drawable.button;
import static com.example.seymur.azercell2.R.drawable.buttonpink;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Xercler.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Xercler#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Xercler extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Xercler() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Xercler.
     */
    // TODO: Rename and change types and number of parameters
    public static Xercler newInstance(String param1, String param2) {
        Xercler fragment = new Xercler();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    ProgressBar mprogressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    /////-----------------//////
//    int progresBarPercent = Integer.parseInt(getString(R.string.AllProgressNumb));
    int CallsProgressNumb = 54;
    int InternetProgressNumb = 73;
    int CreditsProgressNumb = 21;
    TextView tv;
    TextView ProgressTittle;

    int counter = 0;
    /////-----------------//////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_xercler, container, false);
        view.findViewById(R.id.aallProgressBtn).setOnClickListener(this);
        view.findViewById(R.id.callsSmsBtn).setOnClickListener(this);
        view.findViewById(R.id.internetBtn).setOnClickListener(this);
        view.findViewById(R.id.CreditBtn).setOnClickListener(this);

        mprogressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tv = (TextView) view.findViewById(R.id.percentage);
        ProgressTittle = (TextView) view.findViewById(R.id.nameOfCosts);
        getProgressNumb(Integer.parseInt(getString(R.string.AllProgressNumb)));
        return view;
    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new Xercler(), "Costs");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void getProgressNumb(int ProgressNumb){
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(counter, ProgressNumb);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                tv.setText(String.valueOf(animation.getAnimatedValue())+"%");
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(800);
        animator.start();
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, ProgressNumb);
        anim.setDuration(800);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
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
    //---------------------//
    GridLayout GDcalls;
    GridLayout GDAllProgres;
    GridLayout GDinternet;
    GridLayout GDcredit;
//---------------------//
    @Override
    public void onClick(View view) {




        GDAllProgres = (GridLayout) view.findViewById(R.id.aallProgressBtn);
        GDcalls = (GridLayout)view.findViewById(R.id.callsSmsBtn);
        GDinternet =(GridLayout)view.findViewById(R.id.internetBtn);
        GDcredit =(GridLayout)view.findViewById(R.id.CreditBtn);
        if(view.getId()==R.id.aallProgressBtn) {
            if(ProgressTittle.getText() != getResources().getString(R.string.allProgressTittle)) {
                getProgressNumb(Integer.parseInt(getString(R.string.AllProgressNumb)));
                ProgressTittle.setText(getResources().getString(R.string.allProgressTittle));
            }
        }
        else if(view.getId() == R.id.callsSmsBtn){
            if(ProgressTittle.getText() != getResources().getString(R.string.zengler)){
                getProgressNumb(Integer.parseInt(getString(R.string.CallsProgress)));
                ProgressTittle.setText(getResources().getString(R.string.zengler));
            }

        }
        else if (view.getId()==R.id.internetBtn){

            if(ProgressTittle.getText() !=  getResources().getString(R.string.internet)){
                getProgressNumb(Integer.parseInt(getString(R.string.InternetProgress)));
                ProgressTittle.setText(getResources().getString(R.string.internet));
            }

        }
        else if (view.getId()==R.id.CreditBtn){
            if(ProgressTittle.getText() !=  getResources().getString(R.string.kredit)){
                getProgressNumb(Integer.parseInt(getString(R.string.CreditsProgress)));
                ProgressTittle.setText( getResources().getString(R.string.kredit));
            }
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
//PROGRESS BAR

//    ----------------