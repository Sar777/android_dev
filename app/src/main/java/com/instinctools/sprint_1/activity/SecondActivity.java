package com.instinctools.sprint_1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.instinctools.sprint_1.R;
import com.instinctools.sprint_1.fragments.FragmentBodyText;
import com.instinctools.sprint_1.fragments.FragmentCompany;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra(MainActivity.EXTRA_TITLE_TAG);
        boolean order = getIntent().getBooleanExtra(MainActivity.EXTRA_ORDER_TAG, false);
        int companyDrawableResId = getIntent().getIntExtra(MainActivity.EXTRA_COMPANY_IMG_TAG, 0);
        String companyName = getIntent().getStringExtra(MainActivity.EXTRA_COMPANY_NAME_TAG);
        String bodyText = getIntent().getStringExtra(MainActivity.EXTRA_BODY_TAG);

        getSupportActionBar().setTitle(title);

        // Fragments
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (order) {
            fragmentTransaction.add(R.id.content_second, FragmentCompany.newInstance(companyDrawableResId, companyName));
            fragmentTransaction.add(R.id.content_second, FragmentBodyText.newInstance(bodyText));
        }  else {
            fragmentTransaction.add(R.id.content_second, FragmentBodyText.newInstance(bodyText));
            fragmentTransaction.add(R.id.content_second, FragmentCompany.newInstance(companyDrawableResId, companyName));
        }

        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainIntent);
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
