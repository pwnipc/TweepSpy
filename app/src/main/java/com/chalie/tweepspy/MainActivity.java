package com.chalie.tweepspy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.buttonLogin) Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLogin){
            Toast.makeText(MainActivity.this, "Logging in...", Toast.LENGTH_LONG).show();
        }

    }
}