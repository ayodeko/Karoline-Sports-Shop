package com.example.lenovo.bottomnavigationdrawer.CatalogueFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lenovo.bottomnavigationdrawer.CatalogueFragment.RecyclerView.ListItem;
import com.example.lenovo.bottomnavigationdrawer.CatalogueFragment.RecyclerView.RecyclerAdapter;
import com.example.lenovo.bottomnavigationdrawer.R;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class CategoryFeed extends AppCompatActivity {


    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;

    List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_feed);

        Intent intent = getIntent();
        final String activeCategory = intent.getStringExtra("category");

        recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Parse.initialize(getApplicationContext());
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
                        for (ParseObject object: objects){

                            final String name= object.get("Name").toString();
                            final String price = object.get("Price").toString();
                            final String category = object.get("Category").toString();
                            ParseFile file = (ParseFile) object.get("image");

                            file.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                                    ListItem listItem = new ListItem(name, price, activeCategory, bitmap);
                                    listItems.add(listItem);
                                }
                            });

                        }
                    }
                }
            }
        });

        adapter = new RecyclerAdapter(listItems,getApplicationContext());
        if (listItems == null){
            Toast.makeText(getApplicationContext(), "listItem is null", Toast.LENGTH_LONG).show();
        }

        if (adapter == null){
            Toast.makeText(getApplicationContext(), "adapter is null", Toast.LENGTH_LONG).show();
        }
        else {
            recyclerView.setAdapter(adapter);
        }
    }
}
