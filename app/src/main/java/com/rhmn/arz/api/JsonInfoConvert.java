package com.rhmn.arz.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.rhmn.arz.models.CoinsCapInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonInfoConvert {

    private ArrayList<CoinsCapInfo> coinsCapInfos = new ArrayList<>();
    private Context context;



    public ArrayList<CoinsCapInfo> getObject(Object o , String id ) {
        if (o != null) {
            try {
                JSONObject res = new JSONObject(String.valueOf(o));
                JSONObject data = res.getJSONObject("data");
                JSONObject number = data.getJSONObject(id);
                CoinsCapInfo coin = new CoinsCapInfo();
                coin.id = number.getInt("id");
                coin.infoName = number.getString("name");
                coin.infoSymbol = number.getString("symbol");
                coin.image = number.getString("logo");
                coinsCapInfos.clear();
                coinsCapInfos.add(coin);
                Log.d("KIII", "getObject: "+ coin.id);
                Log.d("KIII", "getObject: "+ coin.infoName);

            } catch (JSONException e) {
                e.printStackTrace();
            }
//            JSONObject res = new JSONObject(String.valueOf(o));
//            JSONArray data = res.getJSONArray("data");
//            for (int i = 0; i < data.length(); i++) {
//                JSONObject u = data.getJSONObject(i);
//                Users_model user = new Users_model();
//                user.id = u.getInt("id");
//                user.email = u.getString("email");
//                user.name = u.getString("first_name");
//                user.family = u.getString("last_name");
//                user.image = u.getString("avatar");
//                users.add(user);

//            }
        }
        return coinsCapInfos;
    }
}
