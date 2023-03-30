package lior.gindi.lec18finalproject.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import lior.gindi.lec18finalproject.data.models.Genre
import lior.gindi.lec18finalproject.data.models.Movie

@Dao
interface MovieDao {

    //Movies
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(movie:Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<Movie>)

    //Genres
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(genre: Genre)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGenres(genres: List<Genre>)

    //Query
    @Query("SELECT * FROM Movie")
//    suspend fun getMovies():List<Movie>
    fun getMovies(): LiveData<List<Movie>> //the ui listening to it and always updates it

    //Genre
    @Query("SELECT * FROM Genre")
    fun getGenres(): LiveData<List<Genre>>

}