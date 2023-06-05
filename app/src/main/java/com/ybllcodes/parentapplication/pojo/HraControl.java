package com.ybllcodes.parentapplication.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HraControl implements Serializable {


    private Long id;

    private String setInstallPackageWhiteList;
    private String setWhiteUrlList;
    private Integer setNetFirwall;
    private String sMac;
    private String pMac;

    public HraControl(String pMac,String sMac){
        this.pMac = pMac;
        this.sMac = sMac;
        init();
    }

    public void init(){
        setNetFirwall = 0;
    }


}