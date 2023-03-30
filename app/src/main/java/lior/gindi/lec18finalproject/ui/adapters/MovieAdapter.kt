package lior.gindi.lec18finalproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import lior.gindi.lec18finalproject.data.models.Movie
import lior.gindi.lec18finalproject.databinding.MovieItemBinding

//1) movie_item.xml -> cardview

class MovieAdapter(private val movies: List<Movie>) : Adapter<MovieAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val movie = movies[position]
        with(holder.binding) {
            textTitle.text = movie.title
            Picasso.get().load(movie.posterUrl).into(imagePoster)
        }
    }

    class VH(val binding: MovieItemBinding) : ViewHolder(binding.root)
}