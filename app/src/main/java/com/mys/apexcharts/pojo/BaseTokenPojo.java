package com.mys.apexcharts.pojo;

import com.mys.apexcharts.utils.BasePoJo;
import com.mys.apexcharts.utils.FieldDesc;

public class BaseTokenPojo extends BasePoJo {

    @FieldDesc(key = "error")
    public String error;
    @FieldDesc(key = "successStatusCode")
    public String successStatusCode;

    public BaseTokenPojo() {
        super(null);
    }

    public BaseTokenPojo(String jsonStr) {
        super(jsonStr);
    }

}
