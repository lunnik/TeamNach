package com.example.grueponach.presentation.common

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/** */
@SuppressLint("CheckResult")
@BindingAdapter("setBannerMovie")
fun setBannerMovie(
    imageView: ImageView,
    imageUrl: String?
) {
    val urlBase = "https://www.themoviedb.org/t/p/w220_and_h330_face"
    val context = imageView.context
    val options = RequestOptions()
    options.fitCenter()
    imageUrl?.let {
        val urlBanner = "${urlBase}${imageUrl}"
        Glide.with(context)
            .load(urlBanner)
            .apply(options)
            .placeholder(android.R.drawable.ic_menu_upload_you_tube)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView)
    }
}