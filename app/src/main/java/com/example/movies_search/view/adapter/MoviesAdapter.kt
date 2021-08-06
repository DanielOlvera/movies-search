package com.example.movies_search.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movies_search.R
import com.example.movies_search.model.Search
import com.example.movies_search.utils.MoviesConstants
import com.example.movies_search.view.DetailsActivity


class MoviesAdapter(
    private val movies: List<Search>,
    private val rowLayout: Int,
    private val context: Context
) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    class MovieViewHolder(v: View, context: Context, movies: List<Search>) :
        RecyclerView.ViewHolder(v), View.OnClickListener {
        var moviesLayout: LinearLayout
        var movieTitle: TextView
        var imdbID: TextView
        var year: TextView
        var type: TextView
        var moviePoster: ImageView
        var movies: List<Search> = ArrayList()
        var context: Context
        override fun onClick(view: View) {
            val position = adapterPosition
            val movie = movies[position]
            //Here we launch the DetailsActivity
            val intent = prepareIntent(movie)
            context.startActivity(intent)
        }

        private fun prepareIntent(movie: Search): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(MoviesConstants.MOVIE_TITLE_EXTRA, movie.title)
            intent.putExtra(MoviesConstants.MOVIE_YEAR_EXTRA, movie.year)
            intent.putExtra(MoviesConstants.MOVIE_IMDB_ID_EXTRA, movie.imdbID)
            intent.putExtra(MoviesConstants.MOVIE_TYPE_EXTRA, movie.type)
            intent.putExtra(
                MoviesConstants.MOVIE_POSTER_EXTRA,
                movie.poster
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            return intent
        }

        init {
            v.setOnClickListener(this)
            this.context = context
            this.movies = movies
            moviesLayout = v.findViewById<View>(R.id.movies_layout) as LinearLayout
            movieTitle = v.findViewById<View>(R.id.title) as TextView
            imdbID = v.findViewById<View>(R.id.imdbID) as TextView
            year = v.findViewById<View>(R.id.year) as TextView
            type = v.findViewById<View>(R.id.type) as TextView
            moviePoster = v.findViewById<View>(R.id.movieCDPosther) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view, context, movies)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.setText(movies[position].title)
        holder.imdbID.setText(movies[position].imdbID)
        holder.year.setText(movies[position].year)
        holder.type.setText(movies[position].type)
        Glide.with(context.applicationContext)
            .load<Any>(movies[position].poster)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(holder.moviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    companion object {
        private const val BASE_URL_IMG = "https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg"
    }
}
