package com.example.android.androidme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageId;
    private int mListIndex;
    private static final String IMAGE_ID = "image_id";
    private static final String LIST_INDEX = "list_index";

    public BodyPartFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        if (savedInstanceState != null) {
            setImageId(savedInstanceState.getIntegerArrayList(IMAGE_ID));
            setListIndex(savedInstanceState.getInt(LIST_INDEX));
        }

        final ImageView imageView = rootView.findViewById(R.id.imgBodyPart);

        if (mImageId != null) {
            imageView.setImageResource(mImageId.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListIndex < mImageId.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }

                    imageView.setImageResource(mImageId.get(mListIndex));
                }
            });
        }

        return imageView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID, (ArrayList<Integer>) mImageId);
        outState.putInt(LIST_INDEX, mListIndex);
    }

    public void setImageId(List<Integer> mImageId) {
        this.mImageId = mImageId;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
}
