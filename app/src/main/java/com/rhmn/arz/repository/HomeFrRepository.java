package com.rhmn.arz.repository;

import com.rhmn.arz.models.CoinsCapList;
import com.rhmn.arz.utils.Tools;

import retrofit2.Call;

public class HomeFrRepository {


    public Call<CoinsCapList> getCoinCap(String key){
        //callApi
        Call<CoinsCapList> call = Tools.getApiServicesInstance().getCoinsCap(key);

        return call;
    }
}
