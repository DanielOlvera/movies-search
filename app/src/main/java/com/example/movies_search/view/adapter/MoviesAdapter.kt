package com.example.movies_search.view.adapter
//
//import android.R
//import android.content.Context
//import android.content.Intent
//import android.graphics.Movie
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movies_search.model.Search
//import com.example.movies_search.utils.MoviesConstants
//import com.example.movies_search.utils.MoviesConstants.MoviesConstants.MOVIE_TITLE_EXTRA
//
//
//class MoviesAdapter(private val movies: List<Search>, private val rowLayout: Int, context: Context) :
//    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
//    private val context: Context
//
//    class MovieViewHolder(v: View, context: Context, movies: List<Movie>) :
//        RecyclerView.ViewHolder(v), View.OnClickListener {
//        var moviesLayout: LinearLayout
//        var movieTitle: TextView
//        var year: TextView
//        var imdbID: TextView
//        var type: TextView
//        var moviePosther: ImageView
//        var movies: List<Movie> = ArrayList()
//        var context: Context
//
//        override fun onClick(view: View?) {
//            val position = adapterPosition
//            val movie = movies[position]
//            //Here we launch the DetailsActivity
//            val intent = prepareIntent(movie)
//            context.startActivity(intent)
//        }
//
//        private fun prepareIntent(movie: Movie): Intent {
////            val intent = Intent(context, DetailsActivity::class.java)
////            intent.putExtra(MOVIE_TITLE_EXTRA, movie.getOriginalTitle())
////            intent.putExtra(MoviesConstants.MOVIE_DATA_EXTRA, movie.getReleaseDate())
////            intent.putExtra(MoviesConstants.MOVIE_DESCRIPTION_EXTRA, movie.getOverview())
////            intent.putExtra(MoviesConstants.MOVIE_RANK_EXTRA, movie.getVoteAverage().toString())
////            intent.putExtra(
////                MoviesConstants.MOVIE_POSTER_EXTRA,
////                BASE_URL_IMG + movie.getPosterPath()
////            )
////            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
////            return intent
////        }
////
////        init {
////            v.setOnClickListener(this)
////            this.context = context
////            this.movies = movies
////            moviesLayout = v.findViewById(R.id.movies_layout)
////            movieTitle = v.findViewById(R.id.title)
////            year = v.findViewById(R.id.subtitle)
////            imdbID = v.findViewById(R.id.description)
////            type = v.findViewById(R.id.rating)
////            moviePosther = v.findViewById(R.id.movieCDPosther) as ImageView
////        }
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): MovieViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
//        return MovieViewHolder(view, context, movies)
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.movieTitle.setText(movies[position].getTitle())
//        holder.year.setText(movies[position].getReleaseDate())
//        holder.imdbID.setText(movies[position].getOverview())
//        holder.type.setText(movies[position].getVoteAverage().toString())
//        Glide.with(context.getApplicationContext())
//            .load(BASE_URL_IMG + movies[position].getPosterPath())
//            .listener(object : RequestListener<String?, GlideDrawable?>() {
//                fun onException(
//                    e: Exception?,
//                    model: String?,
//                    target: Target<GlideDrawable?>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    return false
//                }
//
//                fun onResourceReady(
//                    resource: GlideDrawable?,
//                    model: String?,
//                    target: Target<GlideDrawable?>?,
//                    isFromMemoryCache: Boolean,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    return false
//                }
//            })
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .centerCrop()
//            .into(holder.moviePosther)
//    }
//
//    override fun getItemCount(): Int {
//        return movies.size
//    }
//
//    companion object {
//        private const val BASE_URL_IMG = "https://image.tmdb.org/t/p/w150"
//    }
//
//    init {
//        this.context = context
//    }
//}