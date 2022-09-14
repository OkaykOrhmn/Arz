package com.rhmn.arz.fragment.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhmn.arz.activity.Login;
import com.rhmn.arz.adapterCoins.adapterList.ListPropertiesAdapter;
import com.rhmn.arz.adapterCoins.adapterList.ListSettingsAdapter;
import com.rhmn.arz.databinding.FragmentProfileBinding;

import java.util.ArrayList;

public class ProfileFr extends Fragment {

    //binding
    private FragmentProfileBinding binding;
    //context
    private Context context = getContext();

    ArrayList<String> product = new ArrayList<>();

    ListPropertiesAdapter adapterProperties;
    ListSettingsAdapter adapterSettings;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayoutManager vertiLayoutManagerP = new LinearLayoutManager(context,
                RecyclerView.VERTICAL,false);
        binding.propertiesListProfile.setLayoutManager(vertiLayoutManagerP);
        adapterProperties = new ListPropertiesAdapter(product);
        binding.propertiesListProfile.setAdapter(adapterProperties);

        LinearLayoutManager vertiLayoutManagerS = new LinearLayoutManager(context,
                RecyclerView.VERTICAL,false);
        binding.settingsListProfile.setLayoutManager(vertiLayoutManagerS);
        adapterSettings = new ListSettingsAdapter(product);
        binding.settingsListProfile.setAdapter(adapterSettings);





        return root;
    }

    public void intent(){
        Intent intent = new Intent(context, Login.class);
        startActivity(intent);
    }
}