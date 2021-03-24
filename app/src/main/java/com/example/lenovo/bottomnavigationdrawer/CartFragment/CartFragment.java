package com.example.lenovo.bottomnavigationdrawer.CartFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.bottomnavigationdrawer.CartFragment.RecyclerView.ListItem;
import com.example.lenovo.bottomnavigationdrawer.CartFragment.RecyclerView.RecyclerAdapter;
import com.example.lenovo.bottomnavigationdrawer.R;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItem> listItems;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.cart_fragment, container, false);
        recyclerView = fragmentView.findViewById(R.id.recyclerViewCart);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Parse.initialize(getActivity().getApplicationContext());

        //final LinearLayout linearLayout = fragmentView.findViewById(R.id.linearLayout);

        /*ParseObject object = new ParseObject("Sample");

        object.put("Name", "Sample");
        object.put("Price", "200");
        object.put("Category", "Sample");

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "Photo is Sent", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "An Error Occurred", Toast.LENGTH_LONG).show();
                }
            }
        });*/

        final ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Items");
        query.whereEqualTo("Category", "Blouse");
        query.orderByDescending("createdAt");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {

                        int i = 0;
                        final int[] g = {0};
                        listItems = new ArrayList<>();

                        for (final ParseObject object : objects) {
                            i++;

                            final String itemName = object.get("Name").toString();
                            final String itemPrice = object.get("Price").toString();
                            final String itemCategory = object.get("Category").toString();
                            final ParseFile file = (ParseFile) object.get("image");

                            file.getDataInBackground( new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if (e == null && data != null) {

                                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                                        if (bitmap == null){
                                            Toast.makeText(getActivity().getApplicationContext(), "The bitmap passed for Adapter is null", Toast.LENGTH_LONG).show();
                                        }
                                        ListItem listItem = new ListItem(itemName, itemPrice, itemCategory, bitmap);

                                        listItems.add(listItem);
                                    }
                                }
                            });

                        }
                        adapter = new RecyclerAdapter(listItems,getContext());
                        recyclerView.setAdapter(adapter);
                    }
                }
            }
        });

        return fragmentView;

        /**listItems = new ArrayList<>();

        for (int i=0; i<5; i++){
            int imageResource = getResources().getIdentifier("item_cart1", "drawable", getActivity().getPackageName());

            ListItem listItem = new ListItem("Blue Jersey", "#12000", R.drawable.item_cart1);
            listItems.add(listItem);
        }

        adapter = new RecyclerAdapter(listItems, getContext());
        recyclerView.setAdapter(adapter);

        return fragmentView;*/
    }

    /*public Bitmap getParseFileBitmap(ParseFile file){


        file.getDataInBackground(new GetDataCallback() {
            @Override
            public void done(byte[] data, ParseException e) {
                if (e == null){
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                }
                return bitmap;
            }
        });

        return bitmap;
    }*/






















    /*final int j = i;
                            file.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {

                                    if (e == null && data != null) {
                                        g[0]++;
                                        Toast.makeText(getActivity().getApplicationContext(), Integer.toString(g[0]), Toast.LENGTH_LONG).show();

                                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                                        imageView = new ImageView(getActivity().getApplicationContext());
                                        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                                                ViewGroup.LayoutParams.MATCH_PARENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT
                                        ));

                                        imageView.setImageBitmap(bitmap);
                                        if (bitmap == null){
                                            Toast.makeText(getActivity().getApplicationContext(), "bitmap is null", Toast.LENGTH_LONG).show();
                                        }
                                        if (imageView == null){
                                            Toast.makeText(getActivity().getApplicationContext(), "imageView is null here", Toast.LENGTH_LONG).show();
                                        }
                                        linearLayout.addView(imageView);

                                    }

                                }
                            });
     */

}
