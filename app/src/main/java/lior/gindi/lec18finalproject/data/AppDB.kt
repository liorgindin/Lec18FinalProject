package lior.gindi.lec18finalproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lior.gindi.lec18finalproject.data.dao.MovieDao
import lior.gindi.lec18finalproject.data.models.Genre
import lior.gindi.lec18finalproject.data.models.Movie

private const val DB_NAME = "AppDB"
private const val DB_VERSION = 2 //ctrl+alt+c

@Database(version = DB_VERSION, entities = [Movie::class, Genre::class])
abstract class AppDatabase: RoomDatabase(){
    //expose the dao
    abstract fun movieDao(): MovieDao
    //create
    companion object{
        fun create(context: Context):AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}