package com.ybllcodes.parentapplication;

import static com.ybllcodes.parentapplication.utils.Constant.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.ybllcodes.parentapplication.pojo.HraControl;
import com.ybllcodes.parentapplication.pojo.ResultBean;
import com.ybllcodes.parentapplication.utils.Constant;
import com.ybllcodes.parentapplication.utils.HttpCallback;
import com.ybllcodes.parentapplication.utils.OkHttpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HttpCallback {
    private static final String SN = "parent01";
//    Button btnNetwork;
    Button btn_reg,btnBind,btnUnBind,btnEnter;
    EditText et_mac;
    {
        OkHttpUtils.setHttpCallback(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_reg = findViewById(R.id.btn_register_pmac);
        btn_reg.setOnClickListener(this);
        btnBind = findViewById(R.id.btn_bind);
        btnBind.setOnClickListener(this);
        btnUnBind = findViewById(R.id.btn_unbind);
        btnUnBind.setOnClickListener(this);
        btnEnter = findViewById(R.id.btn_enter_control);
        btnEnter.setOnClickListener(this);

        et_mac = findViewById(R.id.et_getmac);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_register_pmac:
                String registerUrl = USER_URL + REGISTER_MAC;
                Map<String,String> mapReg = new HashMap<>();
                mapReg.put("mac","parent01");
                mapReg.put("type","0");
                //注册SN号
                OkHttpUtils.sendMapHttp(registerUrl,mapReg);
                break;
            case R.id.btn_bind:
                String bindUrl = USER_URL + Constant.BIND_PS;
                Map<String,String> map = new HashMap<>();
                map.put("stuMac",et_mac.getText().toString());
                map.put("parMac",SN);
                OkHttpUtils.sendMapHttp(bindUrl,map);
                break;
            case R.id.btn_unbind:
                String unbindUrl = USER_URL + Constant.UNBIND_PS;
                Map<String,String> unmap = new HashMap<>();
                unmap.put("stuMac",et_mac.getText().toString());
                unmap.put("parMac",SN);
                OkHttpUtils.sendMapHttp(unbindUrl,unmap);
                break;
            case R.id.btn_enter_control:
                String controlUrl = CONTROL_URL + GETMSG_FROM_P;
                Map<String,String> controlMap = new HashMap<>();
                controlMap.put("parMac",SN);
                System.out.println(controlUrl);
                OkHttpUtils.sendMapHttp(controlUrl,controlMap);
                break;
        }
//        Intent networkIntent = new Intent(MainActivity.this,NetworkMainActivity.class);
//        startActivity(networkIntent);
    }

    @Override
    public void setMain(ResultBean resultBean) {
        boolean flag = resultBean.isFlag();
        String msg = resultBean.getMsg();
        if(flag){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setMainForPControl(ResultBean resultBean) {
        boolean flag = resultBean.isFlag();
        String msg = resultBean.getMsg();
        List<HraControl> hraControls = JSON.parseArray(resultBean.getResult(), HraControl.class);
        System.out.println("=====");
        for (HraControl hraControl : hraControls) {
            System.out.println(hraControl);
        }
    }

    @Override
    public void setMainForSControl(ResultBean resultBean) {

    }
}