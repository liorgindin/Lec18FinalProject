package lior.gindi.lec18finalproject.ui.home

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import lior.gindi.lec18finalproject.TMDBApp
import lior.gindi.lec18finalproject.data.AppDatabase
import lior.gindi.lec18finalproject.data.models.Movie
import lior.gindi.lec18finalproject.data.repository.MovieRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    val movies:LiveData<List<Movie>> = TMDBApp.db.movieDao().getMovies()

    init {
        viewModelScope.launch {
//            val db = AppDatabase.create(application)
//            val repo = MovieRepository(db.movieDao())

            TMDBApp.movieRepository.refreshMovies()
        }
    }
}