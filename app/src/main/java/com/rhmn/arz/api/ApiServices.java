package com.rhmn.arz.api;

import com.rhmn.arz.models.Coins;
import com.rhmn.arz.models.CoinsCapList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiServices {

    //https://api.coincap.io/v2/assets
    @GET("/v2/assets")
    Call<Coins> getCoins() ;
//    Call<Coins> getCoins(@Header("auth") String token ) ;


    //https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest
    @GET("/v1/cryptocurrency/listings/latest")
    Call<CoinsCapList> getCoinsCap(@Header("X-CMC_PRO_API_KEY") String token );


    //https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?id=1
    @GET("/v1/cryptocurrency/info?")
    Call<Object> getCoinsCapList(@Header("X-CMC_PRO_API_KEY") String token , @Query("id") String id_coin);



}
