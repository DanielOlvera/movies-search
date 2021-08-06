package com.example.movies_search.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.example.movies_search.R
import com.example.movies_search.model.Search
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        loadDetails(intent)
    }

    private fun loadDetails(intent: Intent) {
        if (intent.extras != null) {
//            val movieDetails: Search = MovieDetails().fromExtras(intent)
//            titleText.setText(movieDetails.getTitle())
//            yearText.setText(movieDetails.getDate())
//            detailTxt.setText(movieDetails.getDetails())
//            rankTxt.setText(movieDetails.getRank())
//            Glide.with(this)
//                .load(movieDetails.getPosterPath())
//                .listener(object : RequestListener<String?, GlideDrawable?>() {
//                    fun onException(
//                        e: Exception?,
//                        model: String?,
//                        target: Target<GlideDrawable?>?,
//                        isFirstResource: Boolean
//                    ): Boolean {
//                        return false
//                    }
//
//                    fun onResourceReady(
//                        resource: GlideDrawable?,
//                        model: String?,
//                        target: Target<GlideDrawable?>?,
//                        isFromMemoryCache: Boolean,
//                        isFirstResource: Boolean
//                    ): Boolean {
//                        return false
//                    }
//                })
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(moviePosther)
        }
    }
}