package com.rhmn.arz.adapterCoins.adapterList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rhmn.arz.R;

import java.util.ArrayList;

public class ListPropertiesAdapter extends RecyclerView.Adapter<ListPropertiesAdapter.MyView> {

    Context context;
    private int position;

    public
    String[] labels = {
            "وازیر ها", "برداشت ها", "سابفه خرید و فروش"

    };

    public
    int[] images = {
            R.drawable.ic_variz,
            R.drawable.ic_bardasht,
            R.drawable.ic_baseline_history_24
    };

    public ListPropertiesAdapter(ArrayList<String> pl){
    }

    @NonNull
    @Override
    public ListPropertiesAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_row_2, parent, false);
        return new MyView(itemview);
    }



    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyView holder,  int position) {

//        holder.label.setText(pl.get(position).label);
        holder.label.setText(labels[position]);
//        holder.image.setImageResource(pl.get(position).image);
        holder.image.setImageResource(images[position]);
        if (position == labels.length-1){
            holder.view.setVisibility(View.INVISIBLE);


        }

//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (position){
//                    case 0:
//                        Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
//                        HomeFr.class.inte
//                        break;
//                    case 1:
//
//                        break;
//                    case 2:
//
//                        break;
//
//                }
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return labels.length;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public TextView label;
        public ImageView image;
        public View view;
        public RelativeLayout relativeLayout;


        public MyView( View itemView) {
            super(itemView);

            label = itemView.findViewById(R.id.textView1);
            image = itemView.findViewById(R.id.imageView1);
            view = itemView.findViewById(R.id.view);
            relativeLayout = itemView.findViewById(R.id.layout_relative_list);


        }

    }


}
