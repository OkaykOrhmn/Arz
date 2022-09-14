package com.rhmn.arz.fragment.home;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rhmn.arz.R;
import com.rhmn.arz.adapterCoins.CoinsAdapter;
import com.rhmn.arz.models.CoinsCapList;
import com.rhmn.arz.adapterCoins.FavoriteAdapter;
import com.rhmn.arz.api.ApiClientCoinCap;
import com.rhmn.arz.api.ApiServices;
import com.rhmn.arz.api.Connectivity;
import com.rhmn.arz.databinding.FragmentHomeBinding;
import com.rhmn.arz.viewmodels.HomeFrViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFr extends Fragment {

    private FragmentHomeBinding binding;
    private CoinsAdapter coinsAdapter;
    private FavoriteAdapter favoriteAdapter;
    private ApiServices apiServices;

    private static final String TAG = "KIANOOSH";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        HomeFrViewModel homeFrViewModel = new ViewModelProvider(this).get(HomeFrViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.spinnerHome.setVisibility(View.VISIBLE);
        binding.homeFrAll.setVisibility(View.INVISIBLE);

        if (Connectivity.isConnected(getContext())) {

            homeFrViewModel.getCoins("f972eed1-cf4c-48a7-bbd2-c1c6bdddc27b").observe(getViewLifecycleOwner(), coinsCapList -> {
                favoriteAdapter = new FavoriteAdapter(coinsCapList.data);
                LinearLayoutManager layoutManagerH = new LinearLayoutManager(getContext(),
                        RecyclerView.HORIZONTAL, false);
                binding.recyclerPupHome.setAdapter(favoriteAdapter);
                binding.recyclerPupHome.setLayoutManager(layoutManagerH);
                binding.recyclerPupHome.setHasFixedSize(true);

                coinsAdapter = new CoinsAdapter(coinsCapList.data);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                        RecyclerView.VERTICAL, false);
                binding.recyclerAllHome.setAdapter(coinsAdapter);
                binding.recyclerAllHome.setLayoutManager(layoutManager);
                binding.recyclerAllHome.setHasFixedSize(true);

                binding.spinnerHome.setVisibility(View.INVISIBLE);
                binding.homeFrAll.setVisibility(View.VISIBLE);
            });



            homeFrViewModel.errorMessageLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                }
            });


        } else {

            Dialog dialog = new Dialog(getContext());
            dialog.setContentView(R.layout.connection_error);
            ImageView alert = dialog.findViewById(R.id.image_dialog);
            ProgressBar progressBar = dialog.findViewById(R.id.progress_dialog);
            Button ex = dialog.findViewById(R.id.exit);
            ex.setOnClickListener(view -> {
                getActivity().finish();
            });
            Button ag = dialog.findViewById(R.id.again);
            ag.setOnClickListener(view -> {
                alert.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                Handler h = new Handler();
                Runnable r = () -> {
                    getActivity().recreate();

                };
                h.postDelayed(r, 2000);
            });
            dialog.show();
        }
        return root;
    }
}