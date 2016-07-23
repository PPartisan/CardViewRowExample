package com.example.tom.testapplication.youtube;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tom.testapplication.R;

public class YouTubeFragment extends Fragment {

    private RecyclerView rv;
    private YouTubeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.youtube_fragment, container, false);

        rv = (RecyclerView) v.findViewById(R.id.fragment_rv);
        adapter = new YouTubeAdapter(new String[] { "fMOqfsBzqLU", "FFW54sq5H8s", "2F6lHGvKb2w" });
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

        return v;
    }
}
