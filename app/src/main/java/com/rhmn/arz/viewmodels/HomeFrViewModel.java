package com.rhmn.arz.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rhmn.arz.models.CoinsCapList;
import com.rhmn.arz.repository.HomeFrRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFrViewModel extends ViewModel {

    public MutableLiveData<CoinsCapList> sendActivationLiveData;
    public MutableLiveData<Boolean> isSuccessLiveData = new MutableLiveData<>() ;
    public MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>() ;

    public HomeFrRepository repository = new HomeFrRepository();

    public LiveData<CoinsCapList> getCoins(String key){

        if(sendActivationLiveData == null){
            sendActivationLiveData = new MutableLiveData<>();
            //callApi
            callCoins(key);

        }
        return sendActivationLiveData;
    }

    public void callCoins(String key){
        //CallApi
        Call<CoinsCapList> call = repository.getCoinCap(key);
        //Response
        call.enqueue(new Callback<CoinsCapList>() {
            @Override
            public void onResponse(Call<CoinsCapList> call, Response<CoinsCapList> response) {
                Log.d("VIEWMODELCALLTEST", "onResponse: "+ response.body());
                try {
                    if (response.body() != null) {

                        isSuccessLiveData.setValue(true);
                        sendActivationLiveData.setValue(response.body());

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CoinsCapList> call, Throwable t) {

                Log.d("VIEWMODELCALLTEST", "onFailer: "+ t.getMessage());
                isSuccessLiveData.setValue(false);
                errorMessageLiveData.setValue(t.getMessage());
            }
        });
    }

}
