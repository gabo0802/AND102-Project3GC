package com.example.projext3flixterp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projext3flixterp1.R.id


/**
 * [RecyclerView.Adapter] that can display a [BestSellerBook] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */

class NowShowingMovieRecyclerViewAdapter(private val movies: List<NowShowingMovie>?,
                                         private val mListener: OnListFragmentInteractionListener)
    :  RecyclerView.Adapter<NowShowingMovieRecyclerViewAdapter.MovieViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_now_showing_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: NowShowingMovie? = null

        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
        val mMovieRanking: TextView = mView.findViewById<View>(id.ranking) as TextView
        val mMoviePoster: ImageView = mView.findViewById<View>(id.poster_image) as ImageView



        override fun toString(): String {
            return mMovieTitle.toString() + " '" + mMovieDescription.text + "'"
        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies?.get(position)



        if (movie != null) {
            holder.mMovieTitle.text = movie.title
        }
        if (movie != null) {
            holder.mMovieDescription.text = movie.description
        }
        if (movie != null) {
            holder.mMovieRanking.text = movie.rank.toString()
        }

        if (movie != null) {
            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500${movie.imageURL}")
                .centerInside()
                .into(holder.mMoviePoster)
        }



        holder.mView.setOnClickListener {
            holder.mItem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies?.size ?: 0
    }
}