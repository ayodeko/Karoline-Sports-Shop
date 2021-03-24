package com.example.lenovo.bottomnavigationdrawer.CatalogueFragment.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);


        holder.textViewHead.setText(listItem.getName());
        holder.textViewDesc.setText(listItem.getPrice());
        if (listItem.getImageBitmap() == null){
            Toast.makeText(context, "Bitmap is not gotten in Adapter", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Bitmap is gotten in Adapter", Toast.LENGTH_LONG).show();
        }
        holder.imageView.setImageBitmap(listItem.getImageBitmap());
        holder.textViewIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newQuantity = listItem.getQuantity() + 1;
                listItem.setQuantity(newQuantity);
                holder.textViewQuantity.setText(Integer.toString(newQuantity));
            }
        });
        holder.textViewDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listItem.getQuantity() >1){
                    int newQuantity = listItem.getQuantity() - 1;
                    listItem.setQuantity(newQuantity);
                    holder.textViewQuantity.setText(Integer.toString(newQuantity));
                }
                else{
                    Toast.makeText(context, "The Quantity cannot be reduced further", Toast.LENGTH_LONG).show();
                }
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
        TextView textViewMaterial;
        TextView textViewQuantity;
        TextView textViewIncrease;
        TextView textViewDecrease;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.cart_item_name);
            textViewDesc = itemView.findViewById(R.id.cart_item_price);
            imageView = itemView.findViewById(R.id.cart_item_image);
            textViewMaterial = itemView.findViewById(R.id.cart_item_material);
            textViewQuantity = itemView.findViewById(R.id.cart_item_quantity);
            textViewDecrease = itemView.findViewById(R.id.cart_item_decrease);
            textViewIncrease = itemView.findViewById(R.id.cart_item_increase);
        }

    }

}
