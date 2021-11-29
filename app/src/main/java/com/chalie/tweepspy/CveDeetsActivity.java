package com.chalie.tweepspy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CveDeetsActivity extends AppCompatActivity {
    @BindView(R.id.textViewCve) TextView mCve;
    @BindView(R.id.textViewProduct) TextView mAffectedProduct;
    @BindView(R.id.textViewDescription) TextView mCveDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cve_deets);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String tweetedCve = intent.getStringExtra("tweetedCve");
        String affectedProduct = intent.getStringExtra("affectedProduct");
        String description = intent.getStringExtra("description");

        mCve.setText("CVE ID: "+tweetedCve);
        mAffectedProduct.setText("Affected Product: "+affectedProduct);
        mCveDescription.setText("Bug Description \n"+description);
    }
}