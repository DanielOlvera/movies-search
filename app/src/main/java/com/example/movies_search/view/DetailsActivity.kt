package com.example.movies_search.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.movies_search.R
import com.example.movies_search.utils.MovieDetails
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        loadDetails(intent)
    }

    private fun loadDetails(intent: Intent) {
        if (intent.extras != null) {
            val movieDetails = MovieDetails().fromExtras(intent)
            dTitle.text = movieDetails.title
            dYear.text = movieDetails.year
            dImdbID.text = movieDetails.imdbID
            dType.text = movieDetails.type
            Glide.with(this)
                .load(movieDetails.posterPath)
                .listener(object : RequestListener<String?, GlideDrawable?> {
                    override fun onException(
                        e: Exception?,
                        model: String?,
                        target: Target<GlideDrawable?>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: GlideDrawable?,
                        model: String?,
                        target: Target<GlideDrawable?>?,
                        isFromMemoryCache: Boolean,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(dMoviePoster)
        }
    }
}