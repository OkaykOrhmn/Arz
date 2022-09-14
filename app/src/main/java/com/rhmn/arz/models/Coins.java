package com.rhmn.arz.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Coins {

    @SerializedName("data")
    public ArrayList<Coin> coins = new ArrayList();

    public class Coin{

        @SerializedName("id")
        public String id;

        @SerializedName("symbol")
        public String symbol;

        @SerializedName("name")
        public String nameCoin;

        @SerializedName("priceUsd")
        public String price;

        @SerializedName("rank")
        public int rank;

    }


}
