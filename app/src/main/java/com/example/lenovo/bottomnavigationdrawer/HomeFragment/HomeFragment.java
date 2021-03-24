package com.example.lenovo.bottomnavigationdrawer.HomeFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.bottomnavigationdrawer.LoginActivity;
import com.example.lenovo.bottomnavigationdrawer.MainActivity;
import com.example.lenovo.bottomnavigationdrawer.R;
import com.example.lenovo.bottomnavigationdrawer.HomeFragment.RecyclerView.ListItem;
import com.example.lenovo.bottomnavigationdrawer.HomeFragment.RecyclerView.RecyclerAdapter;
import com.example.lenovo.bottomnavigationdrawer.HomeFragment.SlidePager.SlidePagerAdapter;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RelativeLayout relativeLayout;
    Button button;
    LinearLayout linearLayout;
    ViewPager viewPager;
    TextView[] dot;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    List<ListItem> listItems;
    Button popularButton;


    private SlidePagerAdapter sliderAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.home_fragment, container, false);

        viewPager = fragmentView.findViewById(R.id.viewPager);

        sliderAdapter = new SlidePagerAdapter(getContext());
        viewPager.setAdapter(sliderAdapter);

        popularButton = fragmentView.findViewById(R.id.popular_button);
        popularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });




        recyclerView = fragmentView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(false);
        /*recyclerView.setLayoutManager(new LinearLayoutManager.HORIZONTAL(getContext()));*/
        recyclerView.setLayoutManager(linearLayoutManager);

        listItems = new ArrayList<>();
        Parse.initialize(getActivity().getApplicationContext());
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

                                    ListItem listItem = new ListItem(name, price, bitmap);
                                    listItems.add(listItem);
                                }
                            });

                        }

                        adapter = new RecyclerAdapter(listItems, getActivity().getApplicationContext());
                        recyclerView.setAdapter(adapter);

                    }
                }
            }
        });



        return fragmentView;
    }



}
