package com.example.movies_search.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.movies_search.R
import com.example.movies_search.viewmodel.SearchMoviesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var searchMoviesViewModel: SearchMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        searchMoviesViewModel = ViewModelProvider(this).get(SearchMoviesViewModel::class.java)


    }
}