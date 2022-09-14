package com.rhmn.arz.adapterCoins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rhmn.arz.databinding.CoinsRowHorBinding;
import com.rhmn.arz.models.Coins;
import com.rhmn.arz.models.CoinsCapList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    Context context;

    ArrayList<CoinsCapList.Data> coins;
    private int position;

    public FavoriteAdapter(ArrayList<CoinsCapList.Data> coins){
        this.coins = coins ;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        CoinsRowHorBinding v = CoinsRowHorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteAdapter.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {

        CoinsCapList.Data item = coins.get(position);
        holder.binding.nameRowCoin.setText(item.name);
        holder.binding.symbolRowCoin.setText(item.symbol);
        holder.binding.priceRowCoin.setText(item.quote.usd.price.substring(0,9) + " $");
        Picasso.get().load("https://s2.coinmarketcap.com/static/img/coins/64x64/"+item.id+".png").into(holder.binding.coinRowImage);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CoinsRowHorBinding binding;

        public ViewHolder(@NonNull CoinsRowHorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }



}
