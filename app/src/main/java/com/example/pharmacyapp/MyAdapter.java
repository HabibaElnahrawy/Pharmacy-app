package com.example.pharmacyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacyapp.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Product> list;
    FloatingActionButton floatingActionButton;

    public MyAdapter(Context context, ArrayList<Product> list,FloatingActionButton floatingActionButton) {
        this.context = context;
        this.list = list;
        this.floatingActionButton=floatingActionButton;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            String name=list.get(position).getpName();
        String price=list.get(position).getpPrice();
        String image=list.get(position).getpImage();

        Product product=list.get(position);

        //holder.Product_name.setText(product.getpName());
        holder.Product_name.setText(name);
       // holder.Product_price.setText(product.getpPrice());
        holder.Product_price.setText(price);


        try{
            Picasso.get().load(image).into(holder.Product_image);
        }
        catch (Exception e){

        }
        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    addToCart(name,price,image);
                Toast.makeText(context, "added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
public int itemid=1;
    private void addToCart(String name, String price, String image) {


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Product_name;
        TextView Product_price;
        ImageView Product_image;
        Button addToCartBtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Product_name=itemView.findViewById(R.id.pro_name);
            Product_price=itemView.findViewById(R.id.pro_price);
            Product_image=itemView.findViewById(R.id.PrductImage);
            addToCartBtn=itemView.findViewById(R.id.cartBtn);
        }
    }

}
