package com.example.lenovo.bottomnavigationdrawer.HomeFragment.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.bottomnavigationdrawer.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public RecyclerAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);


        holder.textViewHead.setText(listItem.getName());
        holder.textViewDesc.setText(listItem.getPrice());
        holder.imageView.setImageBitmap(listItem.getImageBitmap());
        holder.cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Added to Cart", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewHead;
        TextView textViewDesc;
        ImageView imageView;
        Button cart_button;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.home_item_name);
            textViewDesc = itemView.findViewById(R.id.home_item_price);
            imageView = itemView.findViewById(R.id.home_item_image);
            cart_button = itemView.findViewById(R.id.cart_button);
        }

    }

}
