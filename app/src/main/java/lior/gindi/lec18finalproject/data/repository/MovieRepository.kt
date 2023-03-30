package lior.gindi.lec18finalproject.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lior.gindi.lec18finalproject.data.dao.MovieDao
import lior.gindi.lec18finalproject.service.TMDBService

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun refreshMovies(){
        withContext(Dispatchers.IO){
            val service = TMDBService.create()
            //fetch movies from API
            val movieRes = TMDBService.create().popularMovies()
            val genreResponse = TMDBService.create().genres()
            //save to local database
            movieDao.addMovies(movieRes.movies)
            movieDao.addGenres(genreResponse.genres)

        }
    }
}