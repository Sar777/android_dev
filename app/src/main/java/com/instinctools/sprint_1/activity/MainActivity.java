package com.instinctools.sprint_1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.instinctools.sprint_1.R;
import com.instinctools.sprint_1.enums.Company;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_TITLE_TAG = "TITLE";
    public static final String EXTRA_BODY_TAG = "BODY";
    public static final String EXTRA_ORDER_TAG = "ORDER";
    public static final String EXTRA_COMPANY_TAG = "COMPANY";

    private Button mButton;
    private EditText mEditTextTitle;
    private EditText mEditTextBody;
    private Spinner mSpinner;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.btn_send);
        mButton.setOnClickListener(this);

        mEditTextTitle = (EditText) findViewById(R.id.et_title);
        mEditTextBody = (EditText) findViewById(R.id.et_body);
        mCheckBox = (CheckBox) findViewById(R.id.cb_order_fragments);
        mSpinner = (Spinner) findViewById(R.id.spinner_pictures);

        List<String> companyList = new ArrayList<>();
        for (Company company : Company.values())
            companyList.add(getResources().getString(company.getResId()));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, companyList);
        mSpinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() != R.id.btn_send)
            return;

        if (TextUtils.isEmpty(mEditTextTitle.getText()) || TextUtils.isEmpty(mEditTextBody.getText())) {
            Snackbar.make(mButton, getString(R.string.string_empty_views), Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TITLE_TAG, mEditTextTitle.getText().toString());
        intent.putExtra(EXTRA_BODY_TAG, mEditTextBody.getText().toString());
        intent.putExtra(EXTRA_ORDER_TAG, mCheckBox.isChecked());
        intent.putExtra(EXTRA_COMPANY_TAG, Company.values()[mSpinner.getSelectedItemPosition()]);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_CANCELED) {
                mEditTextTitle.getText().clear();
                mEditTextBody.getText().clear();
                mCheckBox.setChecked(false);
                mSpinner.setSelection(0);
            }
        }
    }
}
