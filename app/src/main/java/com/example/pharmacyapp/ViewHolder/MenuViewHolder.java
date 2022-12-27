package com.example.pharmacyapp.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacyapp.Interface.ItemClickListener;
import com.example.pharmacyapp.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView MenuName;
    public ImageView imageView;
    private ItemClickListener itemClickListener;
    public MenuViewHolder(View item_view){
        super(item_view);
        //MenuName=(TextView) item_view.findViewById(R.id.menu_name);
        //imageView=(ImageView) item_view.findViewById(R.id.menu_image);
     //   item_view.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
