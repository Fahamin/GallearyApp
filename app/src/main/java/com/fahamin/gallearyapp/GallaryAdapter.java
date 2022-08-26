package com.fahamin.gallearyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahamin.gallearyapp.Utility.ItemClickListener;
import com.fahamin.gallearyapp.databinding.ItemlayoutBinding;
import com.fahamin.gallearyapp.model.UnsplashModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GallaryAdapter extends RecyclerView.Adapter<GallaryAdapter.GallearyHolder> {

    List<UnsplashModel> list;
    ItemClickListener itemClickListener;

    public GallaryAdapter(List<UnsplashModel> list, ItemClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public GallearyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemlayoutBinding itemlayoutBinding = ItemlayoutBinding.inflate(inflater,parent,false);
        return new GallearyHolder(itemlayoutBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull GallearyHolder holder, int position) {

        UnsplashModel model =list.get(position);
        holder.bind(model);
        Picasso.get()
                .load(model.getUrls().getSmall())
                .placeholder(R.drawable.loding)
                .into(holder.binding.IvImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.clickListener(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GallearyHolder extends RecyclerView.ViewHolder {
        // If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
        // Since our layout file is item_movie.xml, our auto generated binding class is ItemMovieBinding

        private ItemlayoutBinding binding;

        public GallearyHolder(ItemlayoutBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UnsplashModel model)
        {
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }
}
