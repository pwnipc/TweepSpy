package com.chalie.tweepspy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.buttonLogin) Button mLogin;
    @BindView(R.id.editTextUserName) EditText mEditTextUserName;

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
            String username = mEditTextUserName.getText().toString();
            if (username.isEmpty()){
                Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(MainActivity.this, TweepSpyList.class);
                intent.putExtra("username",username);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();
            }

        }

    }
}