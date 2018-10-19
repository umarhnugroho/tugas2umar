package com.example.asus.tugasmovielist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final ArrayList<Movie> mWordList;
    private LayoutInflater mInflater;
    public WordListAdapter(Context context, ArrayList<Movie> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }
    public int getItemCount() {
        return mWordList.size();
    }
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        Movie mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent.nama);
        holder.wordItemViewRating.setText(String.valueOf(mCurrent.rating));
        holder.wordItemViewStatus.setText(mCurrent.status);
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public final TextView wordItemViewRating;
        public final TextView wordItemViewStatus;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            wordItemViewRating = itemView.findViewById(R.id.rating);
            wordItemViewStatus = itemView.findViewById(R.id.status);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            Movie element = mWordList.get(mPosition);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}

