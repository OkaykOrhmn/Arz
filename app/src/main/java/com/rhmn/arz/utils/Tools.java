package com.rhmn.arz.utils;

import android.view.View;

import androidx.core.widget.NestedScrollView;

import com.rhmn.arz.api.ApiClientCoinCap;
import com.rhmn.arz.api.ApiServices;

public class Tools {

    private static ApiServices apiServices = null ;

    public static ApiServices getApiServicesInstance (){

        if (apiServices == null ){
            //client
            apiServices = ApiClientCoinCap.getClient().create(ApiServices.class);
        }

        return apiServices ;
    }

    public static void scrollToPosition(NestedScrollView scrollView , View targetView) {

        scrollView.postDelayed(() -> scrollView.smoothScrollTo(0, targetView.getTop()), 300);
    }
}
