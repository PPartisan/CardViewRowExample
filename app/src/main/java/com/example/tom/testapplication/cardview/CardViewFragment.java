package com.example.tom.testapplication.cardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tom.testapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cardview_fragment, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.cardview_fragment_rv);
        CardViewAdapter adapter = new CardViewAdapter(buildData());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

        return v;
    }

    //Builds some example data
    private static List<CardViewModel> buildData() {

        List<CardViewModel> data = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CardViewModel.Builder builder = new CardViewModel.Builder();
            builder.setTitle("Quora")
                    .setContent("Some Quora-like content")
                    .setTime((long)(System.currentTimeMillis() - (Math.random() * 1000000)))
                    .setFaviconUri("http://www.quora.com")
                    .setSiteName("http://www.quora.com");
            data.add(builder.build());
        }

        return data;

    }

}
