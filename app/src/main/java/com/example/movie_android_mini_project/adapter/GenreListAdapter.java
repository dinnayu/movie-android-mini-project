package com.example.movie_android_mini_project.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_android_mini_project.R;
import com.example.movie_android_mini_project.model.Genre;

import java.util.List;

public class GenreListAdapter extends RecyclerView.Adapter<GenreListAdapter.CustomViewHolder> {

    GenreOnClickListener listener;
    private List<Genre> genreList;
    private Context context;

    public void setGenreListener(GenreOnClickListener listener){
        this.listener = listener;
    }

    public GenreListAdapter(Context context, List<Genre> genreList){
        this.context = context;
        this.genreList = genreList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView txtTitle;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtTitle = mView.findViewById(R.id.genre_name);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.genre_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.txtTitle.setText(genreList.get(position).getName());
        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onClick(genreList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return genreList .size();
    }

    public interface GenreOnClickListener{
        void onClick(Genre genre);
    }
}
