package com.rhmn.arz.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.rhmn.arz.api.JsonInfoConvert;
import com.rhmn.arz.models.CoinsCapInfo;
import com.rhmn.arz.models.CoinsCapList;
import com.rhmn.arz.repository.HomeFrRepository;
import com.rhmn.arz.repository.InfoRepository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoFrViewModel extends ViewModel {

    public MutableLiveData<Object> sendActivationLiveData;
    public MutableLiveData<Boolean> isSuccessLiveData = new MutableLiveData<>() ;
    public MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>() ;
    public MutableLiveData<ArrayList<CoinsCapInfo>> coinsInfo = new MutableLiveData<>();

    public JsonInfoConvert jsonInfoConvert = new JsonInfoConvert();
    public InfoRepository repository = new InfoRepository();

    public LiveData<Object> getCoins(String key, String i){

        if(sendActivationLiveData == null){
            sendActivationLiveData = new MutableLiveData<>();
            //callApi
            callCoins(key, i);

        }
        return sendActivationLiveData;
    }

    public void callCoins(String key, String i){
        //CallApi
        Call<Object> call = repository.getInfoCoin(key, i);
        //Response
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d("KIII", "onResponse: "+new Gson().toJson(response.body()));
//                jsonInfoConvert.getObject(new Gson().toJson(response.body()));
                coinsInfo.setValue(jsonInfoConvert.getObject(new Gson().toJson(response.body()) , i));

//                try {
//                    if (response.body() != null) {
//
//                        isSuccessLiveData.setValue(true);
//                        sendActivationLiveData.setValue(response.body());
//
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

                Log.d("KIII", "onFailer: "+ t.getMessage());
                isSuccessLiveData.setValue(false);
                errorMessageLiveData.setValue(t.getMessage());
            }
        });
    }
}
