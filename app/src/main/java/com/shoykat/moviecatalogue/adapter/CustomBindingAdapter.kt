package com.shoykat.moviecatalogue.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("app:setMovieImage")
fun setImage(imageView: ImageView, icon: String?) {
    icon?.let {
        val url = "image_url"
        Glide
            .with(imageView.context)
            .load(url)
            .into(imageView)
    }

}
