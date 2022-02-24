package com.mys.apexcharts.pojo;

import com.mys.apexcharts.utils.BasePoJo;
import com.mys.apexcharts.utils.FieldDesc;

import java.util.ArrayList;

public class TokenKChartPojo extends BaseTokenPojo {

    @FieldDesc(key = "prices", arrayType = Price.class)
    public ArrayList<Price> prices;

    public TokenKChartPojo() {
        super(null);
    }

    public TokenKChartPojo(String jsonStr) {
        super(jsonStr);
    }

    public static class Price extends BasePoJo {
        @FieldDesc(key = "date")
        public String date;
        @FieldDesc(key = "currencyPriceDate")
        public String currencyPriceDate;
        @FieldDesc(key = "price")
        public String price;

        public Price() {
            super(null);
        }

        public Price(String jsonStr) {
            super(jsonStr);
        }

    }

    public static class ApexchartsData extends BasePoJo {
        @FieldDesc(key = "x")
        public String x;
        @FieldDesc(key = "y")
        public String y;

        public ApexchartsData() {
            super(null);
        }

        public ApexchartsData(String jsonStr) {
            super(jsonStr);
        }

        public ApexchartsData(String x, String y) {
            super(null);
            this.x = x;
            this.y = y;
        }

    }

}
