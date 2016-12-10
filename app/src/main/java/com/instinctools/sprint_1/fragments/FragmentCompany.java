package com.instinctools.sprint_1.fragments;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.instinctools.sprint_1.R;

/**
 * Created by orion on 9.12.16.
 */

public class FragmentCompany extends Fragment {
    private static final String BUNDLE_IMAGE_COMPANY_TAG = "IMG_COMPANY";
    private static final String BUNDLE_NAME_COMPANY_TAG = "NAME_COMPANY";

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, viewGroup, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.img_company);
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            drawable = getResources().getDrawable(getArguments().getInt(BUNDLE_IMAGE_COMPANY_TAG), null);
        else
            drawable = getResources().getDrawable(getArguments().getInt(BUNDLE_IMAGE_COMPANY_TAG));

        imageView.setImageDrawable(drawable);

        TextView textView = (TextView) view.findViewById(R.id.tv_company_name);
        textView.setText(getArguments().getString(BUNDLE_NAME_COMPANY_TAG));
        return view;
    }

    public static FragmentCompany newInstance(int res, String name) {
        FragmentCompany fragment = new FragmentCompany();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_IMAGE_COMPANY_TAG, res);
        bundle.putString(BUNDLE_NAME_COMPANY_TAG, name);
        fragment.setArguments(bundle);
        return fragment;
    }
}
