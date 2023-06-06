package com.ybllcodes.parentapplication.utils;

import com.ybllcodes.parentapplication.pojo.ResultBean;

import okhttp3.Response;

public interface HttpCallback {
    void setMain(ResultBean resultBean);
    void setMainForPControl(ResultBean resultBean);
    void setMainForSControl(ResultBean resultBean);
}
