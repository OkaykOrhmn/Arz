package com.rhmn.arz.repository;

import com.rhmn.arz.models.CoinsCapList;
import com.rhmn.arz.utils.Tools;

import retrofit2.Call;

public class InfoRepository {


    public Call<Object> getInfoCoin(String key, String i){
        //callApi
        Call<Object> call = null;
            call = Tools.getApiServicesInstance().getCoinsCapList(key, i );

        return call;
    }
}
