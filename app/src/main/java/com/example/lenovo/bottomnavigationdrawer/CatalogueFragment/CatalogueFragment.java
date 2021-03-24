package com.example.lenovo.bottomnavigationdrawer.CatalogueFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.bottomnavigationdrawer.R;

public class CatalogueFragment extends Fragment {

    Button blouseButton, pantsButton, jacketButton, dressButton, topButton, shoesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.catalogue_fragment, container, false);

        blouseButton = fragmentView.findViewById(R.id.blouse_button);
        pantsButton = fragmentView.findViewById(R.id.pants_button);
        jacketButton = fragmentView.findViewById(R.id.jacket_button);
        dressButton = fragmentView.findViewById(R.id.dress_button);
        topButton = fragmentView.findViewById(R.id.top_button);
        shoesButton = fragmentView.findViewById(R.id.shoes_button);

        blouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CategoryFeed.class);
                intent.putExtra("category", "Blouse");
                startActivity(intent);
            }
        });

        pantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CategoryFeed.class);
                intent.putExtra("category", "Pants");
                startActivity(intent);
            }
        });

        jacketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CategoryFeed.class);
                intent.putExtra("category", "Jacket");
                startActivity(intent);
            }
        });

        dressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CategoryFeed.class);
                intent.putExtra("category", "Dress");
                startActivity(intent);
            }
        });

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CategoryFeed.class);
                intent.putExtra("category", "Top");
                startActivity(intent);
            }
        });

        shoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CategoryFeed.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });

        return fragmentView;
    }

}
