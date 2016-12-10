package com.instinctools.sprint_1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.instinctools.sprint_1.R;

/**
 * Created by orion on 9.12.16.
 */

public class FragmentBodyText extends Fragment {
    private static final String BUNDLE_BODY_TEXT_TAG = "BODY_TEXT";

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body_text, viewGroup, false);

        TextView textView = (TextView) view.findViewById(R.id.tv_body_text);
        textView.setText(getArguments().getString(BUNDLE_BODY_TEXT_TAG));
        return view;
    }

    public static FragmentBodyText newInstance(String text) {
        FragmentBodyText fragment = new FragmentBodyText();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_BODY_TEXT_TAG, text);
        fragment.setArguments(bundle);
        return fragment;
    }
}
