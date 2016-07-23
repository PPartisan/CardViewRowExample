package com.example.tom.testapplication.cardview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.testapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder>{

    private List<CardViewModel> data;

    public CardViewAdapter(List<CardViewModel> data){
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        long time = System.currentTimeMillis() - data.get(position).time;
        Log.e("TAG", String.valueOf(time));

        holder.title.setText(data.get(position).title);
        holder.content.setText(data.get(position).content);
        holder.siteName.setText(data.get(position).siteName);
        holder.time.setText(getReadableTime(time));
        Picasso.with(holder.itemView.getContext())
                .load(getFaviconUrl(data.get(position).faviconUri))
                .into(holder.favicon);
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, content, siteName, time;
        ImageView favicon;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.cardview_row_title);
            content = (TextView) itemView.findViewById(R.id.cardview_row_content);
            siteName = (TextView) itemView.findViewById(R.id.cardview_row_site_name);
            time = (TextView) itemView.findViewById(R.id.cardview_row_time);
            favicon = (ImageView) itemView.findViewById(R.id.cardview_row_image);
        }
    }

    private static String getReadableTime(long time) {
        return String.format(Locale.getDefault(), "%d min", TimeUnit.MILLISECONDS.toMinutes(time));
    }

    private static String getFaviconUrl(String target){
        return "http://www.google.com/s2/favicons?domain=" + target;
    }

}
