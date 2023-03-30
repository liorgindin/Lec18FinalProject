package lior.gindi.lec18finalproject

import android.app.Application
import lior.gindi.lec18finalproject.data.AppDatabase
import lior.gindi.lec18finalproject.data.repository.MovieRepository

class TMDBApp : Application(){
    override fun onCreate() {
        super.onCreate()
        app = this
        db = AppDatabase.create(this)
        movieRepository = MovieRepository(db.movieDao())
    }

    companion object{
       lateinit var app: TMDBApp
       lateinit var db: AppDatabase
       lateinit var movieRepository: MovieRepository
    }

}