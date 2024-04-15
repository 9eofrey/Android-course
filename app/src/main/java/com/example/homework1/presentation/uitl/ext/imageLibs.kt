package com.example.homework1.presentation.uitl.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.imageLibs(id:String) {
    // TODO Implement Glide or other lib
    Glide.with(this)
        .load(id)
        .circleCrop()
        .into(this)
}
