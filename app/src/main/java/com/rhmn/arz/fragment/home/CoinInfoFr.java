package com.rhmn.arz.fragment.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhmn.arz.databinding.FragmentCoinInfoBinding;
import com.rhmn.arz.viewmodels.InfoFrViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CoinInfoFr extends Fragment {

    private FragmentCoinInfoBinding binding;
//    private ArrayList<CoinsCapInfo> coinsCapInfos = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        InfoFrViewModel infoFrViewModel = new ViewModelProvider(this).get(InfoFrViewModel.class);

        binding = FragmentCoinInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("CoinId", Context.MODE_PRIVATE);
        String i = getArguments().getString("id");

        Log.d("KIAA", "onCreateView: "+i);
        infoFrViewModel.getCoins("f972eed1-cf4c-48a7-bbd2-c1c6bdddc27b", i )
                .observe(getViewLifecycleOwner(), o -> {
                    Log.d("KIII", "onChanged: "+o);
//                    binding.nameInfo.setText(coinsCapInfos.get(0).infoName);
//                    Log.d("KIII", "onCreateView: "+ coinsCapInfos.get(0).infoName);




                });

        infoFrViewModel.coinsInfo.observe(getViewLifecycleOwner(), coinsCapInfos -> {
            binding.nameCoinInfo.setText(coinsCapInfos.get(0).infoName);
            binding.symbolCoinInfo.setText(coinsCapInfos.get(0).infoSymbol);
            Picasso.get().load(coinsCapInfos.get(0).image).into(binding.ImageCoinInfo);

        });


        return root;
    }
}