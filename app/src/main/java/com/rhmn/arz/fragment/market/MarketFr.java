package com.rhmn.arz.fragment.market;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

import com.google.android.material.tabs.TabLayout;
import com.rhmn.arz.models.Coins;
import com.rhmn.arz.adapterCoins.CoinsAdapter;
import com.rhmn.arz.adapterCoins.FavoriteAdapter;
import com.rhmn.arz.api.ApiServices;
import com.rhmn.arz.databinding.FragmentMarketBinding;

import java.util.ArrayList;


public class MarketFr extends Fragment {

    //binding
    private FragmentMarketBinding binding;
    private FragmentTransaction ft;
    NavController navController;
    private CoinsAdapter coinsAdapter;
    private FavoriteAdapter favoriteAdapter;
    private ApiServices apiServices ;

    private ArrayList<Coins.Coin> strings = new ArrayList<>();

    private static final String TAG = "KIANOOSH";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMarketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ///////////////////////////tablayout///////

        binding.tabLayoutMarket.removeAllTabs();

        TabLayout.Tab tab4 = binding.tabLayoutMarket.newTab();
        tab4.setText("فیات");
        binding.tabLayoutMarket.addTab(tab4, 0);

        TabLayout.Tab tab3 = binding.tabLayoutMarket.newTab();
        tab3.setText("مارجین");
        binding.tabLayoutMarket.addTab(tab3, 1);

        TabLayout.Tab tab2 = binding.tabLayoutMarket.newTab();
        tab2.setText("علاقه مندی ها");
        binding.tabLayoutMarket.addTab(tab2, 2);

        TabLayout.Tab tab1 = binding.tabLayoutMarket.newTab();
        tab1.setText("همه ارز ها");
        binding.tabLayoutMarket.addTab(tab1, 3);

        binding.tabLayoutMarket.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectTab(binding.tabLayoutMarket.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                selectTab(binding.tabLayoutMarket.getSelectedTabPosition());
            }
        });

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {

                        binding.tabLayoutMarket.getTabAt(3).select();
                    }
                }, 0);



        return root;
    }

    private void selectTab(int position) {
        switch (position) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;

        }
    }


}