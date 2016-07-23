package com.example.tom.testapplication.youtube;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.testapplication.R;
import com.squareup.picasso.Picasso;

public class YouTubeAdapter extends RecyclerView.Adapter<YouTubeAdapter.ViewHolder> {

    private String[] videoIds;

    public YouTubeAdapter(String[] videoIds) {
        this.videoIds = videoIds;
    }

    @Override
    public YouTubeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_rv_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(YouTubeAdapter.ViewHolder holder, int position) {
        Picasso.with(holder.itemView.getContext())
                .load(getYouTubeThumbnailUrl(videoIds[position]))
                .placeholder(R.drawable.placeholder)
                .centerInside()
                .fit()
                .into(holder.image);
        holder.text.setText(getYouTubeVideoLink(videoIds[position]));
    }

    @Override
    public int getItemCount() {
        return videoIds.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.rv_row_image);
            text = (TextView) itemView.findViewById(R.id.rv_row_text);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(text.getText().toString()));
            view.getContext().startActivity(i);
        }
    }

    private static String getYouTubeThumbnailUrl(String videoId) {
        return "http://img.youtube.com/vi/" + videoId + "/0.jpg";
    }

    private static String getYouTubeVideoLink(String videoId) {
        return "http://www.youtube.com/watch?v=" + videoId;
    }

}
