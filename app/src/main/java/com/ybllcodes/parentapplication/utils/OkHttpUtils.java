package com.ybllcodes.parentapplication.utils;

import com.alibaba.fastjson.JSON;
import com.ybllcodes.parentapplication.pojo.HraControl;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120,TimeUnit.SECONDS)
            .writeTimeout(120,TimeUnit.SECONDS)
            .build();
    private static final MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

    public static String sendHttp(String url, HraControl hc){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //请求详情

                OkHttpClient okHttpClient = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");


                //1.获取封装请求体requestBody
                String s = JSON.toJSONString(hc);
                System.out.println(s);
                RequestBody body = RequestBody.create(mediaType, s);

                //
                Request build = new Request.Builder()
                        .post(body)
                        .url(url)
                        .addHeader("content-type", "application/json")
                        .build();
                try {
                    okHttpClient.newCall(build).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            };
        }).start();


        return "123";

    }
}
