package com.example.android.androidme;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageId(AndroidImageAssets.getHeads());
            headFragment.setListIndex(1);
            fragmentManager.beginTransaction().add(R.id.flHeadContainer, headFragment).commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageId(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(1);
            fragmentManager.beginTransaction().add(R.id.flBodyContainer, bodyFragment).commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageId(AndroidImageAssets.getLegs());
            legFragment.setListIndex(1);
            fragmentManager.beginTransaction().add(R.id.flLegContainer, legFragment).commit();
        }
    }
}
