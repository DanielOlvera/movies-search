package com.example.movies_search.view

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movies_search.BuildConfig
import com.example.movies_search.R
import com.example.movies_search.viewmodel.SearchMoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    lateinit var searchMoviesViewModel: SearchMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        searchMoviesViewModel = ViewModelProvider(this).get(SearchMoviesViewModel::class.java)

        val movie =inputSearch.text.toString()

        searchButton.setOnClickListener {
            Toast.makeText(this, "Searching movies", Toast.LENGTH_SHORT).show()
            searchingMovies(movie)
        }

    }

    private fun searchingMovies(movie: String) {
        searchMoviesViewModel.getSearch(BuildConfig.API_KEY, movie)!!
            .observe(this, { search ->

                Toast.makeText(this, "$search", Toast.LENGTH_SHORT).show()

            })
    }
}