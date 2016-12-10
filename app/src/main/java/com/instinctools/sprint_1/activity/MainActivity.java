package com.instinctools.sprint_1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.instinctools.sprint_1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int[] mDrawableCompanyImg = {
            R.drawable.i_logo_apple,
            R.drawable.i_logo_samsung,
            R.drawable.i_logo_lg,
            R.drawable.i_logo_xiaomi,
    };

    public static final String EXTRA_TITLE_TAG = "TITLE";
    public static final String EXTRA_BODY_TAG = "BODY";
    public static final String EXTRA_ORDER_TAG = "ORDER";
    public static final String EXTRA_COMPANY_NAME_TAG = "COMPANY_NAME";
    public static final String EXTRA_COMPANY_IMG_TAG = "COMPANY_IMG";

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
        mButton = (Button) findViewById(R.id.bt_send);
        mButton.setOnClickListener(this);

        mEditTextTitle = (EditText) findViewById(R.id.et_title);
        mEditTextBody = (EditText) findViewById(R.id.et_body);
        mCheckBox = (CheckBox) findViewById(R.id.cb_order_fragments);
        mSpinner = (Spinner) findViewById(R.id.spinner_pictures);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() != R.id.bt_send)
            return;

        if (mEditTextTitle.getText().length() == 0 || mEditTextBody.getText().length() == 0) {
            Snackbar.make(mButton, getString(R.string.string_empty_views), Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TITLE_TAG, mEditTextTitle.getText().toString());
        intent.putExtra(EXTRA_BODY_TAG, mEditTextBody.getText().toString());
        intent.putExtra(EXTRA_ORDER_TAG, mCheckBox.isChecked());
        intent.putExtra(EXTRA_COMPANY_NAME_TAG, mSpinner.getSelectedItem().toString());
        intent.putExtra(EXTRA_COMPANY_IMG_TAG, mDrawableCompanyImg[mSpinner.getSelectedItemPosition()]);
        startActivity(intent);
    }
}
