package com.brahmasys.bts.joinme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.brahmasys.bts.joinme.R;

public class Screen17 extends android.support.v4.app.Fragment  {
    FrameLayout frameLayoutbck,frameLayoutacity;
    ImageView imageView6;
    ImageView imageViewbck;
    RatingBar myratingBar;
    TextView reporttext,updatetext;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        final View v=inflater.inflate(R.layout.screen17,container,false);
        frameLayoutbck= (FrameLayout) v.findViewById(R.id.frameLayoutbck);
        frameLayoutacity= (FrameLayout) v.findViewById(R.id.frameLayoutactity);
        imageViewbck= (ImageView) v.findViewById(R.id.backbtnimage);
        reporttext= (TextView) v.findViewById(R.id.reportactitytext);
        updatetext= (TextView) v.findViewById(R.id.updateactivitytext);
        imageViewbck.setClickable(true);
        imageViewbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Screen16.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                getActivity().finish();}
        });
        reporttext.setClickable(true);
        reporttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                switch (v.getId()) {
                    case R.id.reportactitytext:
                        fragment = new Fragment();
                        replaceFragment1(fragment);
                        break;
                }
            }
        });
        updatetext.setClickable(true);
        updatetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager=getFragmentManager();
                Update_Activity update_activity =new Update_Activity();
                    fragmentManager.beginTransaction()
                            .replace(R.id.flContent,update_activity)
                            .addToBackStack(null)
                            .commit();



            }

        });
        final RatingBar minimumRating = (RatingBar)v.findViewById(R.id.myRatingBar);
        minimumRating.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View view, MotionEvent event)
            {
                float touchPositionX = event.getX();
                float width = minimumRating.getWidth();
                float starsf = (touchPositionX / width) * 5.0f;
                int stars = (int)starsf + 1;
                minimumRating.setRating(stars);
                return true;
            }
        });
        ImageView createrimage= (ImageView) v.findViewById(R.id.createrimage);
        createrimage.setClickable(true);
        createrimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager=getFragmentManager();
                Screen13 screen13=new Screen13();
                    fragmentManager.beginTransaction()
                            .replace(R.id.flContent,screen13)
                            .addToBackStack(null)
                            .commit();





            }
        });

        return v;
    }
    private void replaceFragment1(Fragment fragmen) {
        Fragment reportfrgmnt=new ReportFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flContent,reportfrgmnt);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void replaceFragment(Fragment fr) {
        Fragment mygroup=new Mygroup();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flContent,mygroup);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    Intent i = new Intent(getActivity(), Screen16.class);
                    startActivity(i);
                    getActivity().overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        });
    }
}