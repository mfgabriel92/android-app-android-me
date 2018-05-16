package com.example.android.androidme;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int hId;
    private int bId;
    private int lId;
    private boolean isTablet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.tablet_layout) != null) {
            isTablet = true;

            GridView mGrid = findViewById(R.id.imgGrid);
            mGrid.setNumColumns(2);

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

    @Override
    public void onImageSelected(int pos) {
        int part = pos / 12;
        int index = pos - 12 * part;

        if (isTablet) {
            BodyPartFragment fragment = new BodyPartFragment();

            switch (part) {
                case 0:
                    fragment.setImageId(AndroidImageAssets.getHeads());
                    fragment.setListIndex(index);
                    getSupportFragmentManager().beginTransaction().replace(R.id.flHeadContainer, fragment).commit();
                    break;
                case 1:
                    fragment.setImageId(AndroidImageAssets.getBodies());
                    fragment.setListIndex(index);
                    getSupportFragmentManager().beginTransaction().replace(R.id.flBodyContainer, fragment).commit();
                    break;
                case 2:
                    fragment.setImageId(AndroidImageAssets.getLegs());
                    fragment.setListIndex(index);
                    getSupportFragmentManager().beginTransaction().replace(R.id.flLegContainer, fragment).commit();
                    break;
            }
        } else {
            switch (part) {
                case 0:
                    hId = index;
                    break;
                case 1:
                    bId = index;
                    break;
                case 2:
                    lId = index;
                    break;
                default:
                    break;
            }

            Bundle bundle = new Bundle();
            bundle.putInt("head", hId);
            bundle.putInt("body", bId);
            bundle.putInt("leg", lId);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(bundle);

            Button mBtnNext = findViewById(R.id.btnNext);
            mBtnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }
    }
}
