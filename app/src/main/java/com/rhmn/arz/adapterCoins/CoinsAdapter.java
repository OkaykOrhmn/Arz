package com.rhmn.arz.adapterCoins;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.rhmn.arz.R;
import com.rhmn.arz.databinding.CoinsRowBinding;
import com.rhmn.arz.models.CoinsCapList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.ViewHolder> {

    Context context;

    ArrayList<CoinsCapList.Data> coins;
    private int position;

    public CoinsAdapter(ArrayList<CoinsCapList.Data> coins){
        this.coins = coins ;
    }

    @NonNull
    @Override
    public CoinsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        CoinsRowBinding v = CoinsRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CoinsAdapter.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull CoinsAdapter.ViewHolder holder, int position) {
        CoinsCapList.Data item = coins.get(position);
        holder.binding.nameRowCoin.setText(item.name);
        holder.binding.symbolRowCoin.setText(item.symbol);
        holder.binding.priceRowCoin.setText(item.quote.usd.price.substring(0,9) + " $");
        holder.binding.rank.setText(String.valueOf(item.id));
        Picasso.get().load("https://s2.coinmarketcap.com/static/img/coins/64x64/"+item.id+".png")
                .into(holder.binding.coinRowImage);
        holder.binding.layoutRowCoin.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("id", item.id);
            Navigation.findNavController(view).navigate(R.id.action_homeFr_to_coinInfoFr, bundle);
        });

    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CoinsRowBinding binding;

        public ViewHolder(@NonNull CoinsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
