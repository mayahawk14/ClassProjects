package edu.utsa.cs3443.jammatesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.jammatesapp.R;
import edu.utsa.cs3443.jammatesapp.model.Artist;
import edu.utsa.cs3443.jammatesapp.model.Song;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private List<String> displayList = new ArrayList<>();

    public ExploreAdapter(List<Artist> artists) {
        setArtistResults(artists);
    }
    public void setArtistResults(List<Artist> artists) {
        displayList.clear();
        for (Artist a : artists) {
            displayList.add("🎤 " + a.getName() + " - " + a.getGenre());
        }
        notifyDataSetChanged();
    }

    public void setSongResults(List<Song> songs) {
        displayList.clear();
        for (Song s : songs) {
            displayList.add("🎵 " + s.getTitle());
        }
        notifyDataSetChanged();
    }

    @Override
    public ExploreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExploreAdapter.ViewHolder holder, int position) {
        holder.resultText.setText(displayList.get(position));
    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView resultText;

        ViewHolder(View itemView) {
            super(itemView);
            resultText = itemView.findViewById(R.id.resultText);
        }
    }
}
