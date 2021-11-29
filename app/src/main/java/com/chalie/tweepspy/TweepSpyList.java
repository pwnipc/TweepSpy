package com.chalie.tweepspy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweepSpyList extends AppCompatActivity {
    @BindView(R.id.textViewUserName) TextView mTextViewUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweep_spy_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mTextViewUserName.setText(username);

    }
}