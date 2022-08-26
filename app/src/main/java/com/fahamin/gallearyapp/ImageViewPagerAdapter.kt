package com.fahamin.gallearyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahamin.gallearyapp.databinding.ImageItemBinding
import com.squareup.picasso.Picasso

class ImageViewPagerAdapter(private val imageUrl: ArrayList<String>?) :
    RecyclerView.Adapter<ImageViewPagerAdapter.ViewPageViewHolder>() {


    class ViewPageViewHolder(val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(imageUrl: String) {
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.loding)
                .into(binding.ivImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageViewHolder {
        val binding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPageViewHolder, position: Int) {
        holder.setData(imageUrl!![position])
    }

    override fun getItemCount(): Int {
        return imageUrl!!.size
    }

}