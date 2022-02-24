package com.mys.apexcharts.pojo;

import com.mys.apexcharts.utils.BasePoJo;
import com.mys.apexcharts.utils.FieldDesc;

import java.util.ArrayList;

public class TokenPojo extends BaseTokenPojo {

    @FieldDesc(key = "currency")
    public String currency;
    @FieldDesc(key = "page")
    public Integer page;
    @FieldDesc(key = "pageCount")
    public Integer pageCount;
    @FieldDesc(key = "resultCount")
    public Integer resultCount;
    @FieldDesc(key = "resultPerPage")
    public Integer resultPerPage;
    @FieldDesc(key = "results", arrayType = Data.class)
    public ArrayList<Data> results;

    public TokenPojo() {
        super(null);
    }

    public TokenPojo(String jsonStr) {
        super(jsonStr);
    }

    public static class Data extends BasePoJo {
        @FieldDesc(key = "id")
        public String id;
        @FieldDesc(key = "coinIdInBlockchain")
        public String coinIdInBlockchain;
        @FieldDesc(key = "name")
        public String name;
        @FieldDesc(key = "symbol")
        public String symbol;
        @FieldDesc(key = "blockchain")
        public String blockchain;
        @FieldDesc(key = "images")
        public Image images;
        @FieldDesc(key = "priceInFiat")
        public String priceInFiat;
        @FieldDesc(key = "volumeInFiat")
        public String volumeInFiat;
        @FieldDesc(key = "capInFiat")
        public String capInFiat;
        @FieldDesc(key = "changes")
        public Change changes;

        public Data() {
            super(null);
        }

        public Data(String jsonStr) {
            super(jsonStr);
        }

        public static class Image extends BasePoJo {
            @FieldDesc(key = "thumb")
            public String thumb;
            @FieldDesc(key = "small")
            public String small;
            @FieldDesc(key = "large")
            public String large;

            public Image() {
                super(null);
            }

            public Image(String jsonStr) {
                super(jsonStr);
            }

        }

        public static class Change extends BasePoJo {
            @FieldDesc(key = "priceInFiat1h")
            public ChangeData priceInFiat1h;
            @FieldDesc(key = "priceInFiat24h")
            public ChangeData priceInFiat24h;
            @FieldDesc(key = "priceInFiat7d")
            public ChangeData priceInFiat7d;

            public Change() {
                super(null);
            }

            public Change(String jsonStr) {
                super(jsonStr);
            }

            public static class ChangeData extends BasePoJo {
                @FieldDesc(key = "percentage")
                public Double percentage;
                @FieldDesc(key = "valueDate")
                public String valueDate;

                public ChangeData() {
                    super(null);
                }

                public ChangeData(String jsonStr) {
                    super(jsonStr);
                }

            }
        }
    }

}
