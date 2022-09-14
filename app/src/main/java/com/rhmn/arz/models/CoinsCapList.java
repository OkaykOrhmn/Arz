package com.rhmn.arz.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CoinsCapList {


    @SerializedName("data")
    public ArrayList<Data> data = new ArrayList<>();

    public class Data{

        @SerializedName("id")
        public String id = "";

        @SerializedName("name")
        public String name = "";

        @SerializedName("symbol")
        public String symbol = "";

        @SerializedName("quote")
        public Quote quote;

        public class Quote{

            @SerializedName("USD")
            public Usd usd;

            public class Usd{

                @SerializedName("price")
                public String price;
            }
        }

    }
}
