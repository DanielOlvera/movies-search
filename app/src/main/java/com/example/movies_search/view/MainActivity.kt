package com.example.movies_search.view

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_search.BuildConfig
import com.example.movies_search.BuildConfig.API_KEY
import com.example.movies_search.R
import com.example.movies_search.view.adapter.MoviesAdapter
import com.example.movies_search.viewmodel.SearchMoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    lateinit var searchMoviesViewModel: SearchMoviesViewModel

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        searchMoviesViewModel = ViewModelProvider(this).get(SearchMoviesViewModel::class.java)

        if (API_KEY.isEmpty()) {
            Toast.makeText(applicationContext, R.string.err_key_missing, Toast.LENGTH_LONG).show();
            return
        }

        linearLayoutManager = LinearLayoutManager(this)
        searchRecyclerView.layoutManager = linearLayoutManager

        searchButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.searching_movies), Toast.LENGTH_SHORT).show()
            val movie =inputSearch.text.toString()

            searchingMovies(movie)
        }

    }

    private fun searchingMovies(movie: String) {
        searchMoviesViewModel.getSearch(API_KEY, movie)!!
            .observe(this, { search ->

                if (search != null) {
                    adapter = MoviesAdapter(search, R.layout.list_item_movie, this@MainActivity)
                    searchRecyclerView.adapter = adapter

                    Toast.makeText(this, getString(R.string.completed), Toast.LENGTH_SHORT).show()

                    emptySearch.visibility = GONE
                } else {
                    emptySearch.text = getString(R.string.movie_not_found)
                }
            })
    }
}