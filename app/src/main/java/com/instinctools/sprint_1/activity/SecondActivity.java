package com.instinctools.sprint_1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.instinctools.sprint_1.R;
import com.instinctools.sprint_1.enums.Company;
import com.instinctools.sprint_1.fragments.BodyTextFragment;
import com.instinctools.sprint_1.fragments.CompanyFragment;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(MainActivity.EXTRA_TITLE_TAG);
            boolean order = intent.getBooleanExtra(MainActivity.EXTRA_ORDER_TAG, false);
            Company company = (Company) intent.getSerializableExtra(MainActivity.EXTRA_COMPANY_TAG);
            String bodyText = intent.getStringExtra(MainActivity.EXTRA_BODY_TAG);

            getSupportActionBar().setTitle(title);

            String companyName = getResources().getString(company.getResId());

            // Fragments
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (order) {
                fragmentTransaction.replace(R.id.frame_layout1, CompanyFragment.newInstance(company.getDrawableId(), companyName));
                fragmentTransaction.replace(R.id.frame_layout2, BodyTextFragment.newInstance(bodyText));
            } else {
                fragmentTransaction.replace(R.id.frame_layout1, BodyTextFragment.newInstance(bodyText));
                fragmentTransaction.replace(R.id.frame_layout2, CompanyFragment.newInstance(company.getDrawableId(), companyName));
            }

            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(RESULT_CANCELED);
            finish();
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        setResult(RESULT_OK);
        finish();
        return true;
    }
}
