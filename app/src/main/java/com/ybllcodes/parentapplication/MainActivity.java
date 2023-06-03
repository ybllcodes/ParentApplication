package com.ybllcodes.parentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNetwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNetwork = findViewById(R.id.btn_network_control);
        btnNetwork.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent networkIntent = new Intent(MainActivity.this,NetworkMainActivity.class);
        startActivity(networkIntent);
    }
}