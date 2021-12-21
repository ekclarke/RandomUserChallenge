package com.example.randomuserchallenge

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageHelper {

    fun loadImage(url: String, view: ImageView) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(view)
    }

}