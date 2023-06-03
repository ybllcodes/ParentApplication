package com.ybllcodes.parentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class NetworkMainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch networkSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_main);
        networkSwitch = findViewById(R.id.switch_network);
        networkSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String value = isChecked?"1":"0";
        //发送请求： http://localhost:8888/setrule?sid=01&&pid=02&type=201&value=1
        if(isChecked){
            //开启 - 发送请求：
        }




        Toast.makeText(this,isChecked?"开启网络管控":"关闭网络管控",Toast.LENGTH_SHORT).show();
    }
}