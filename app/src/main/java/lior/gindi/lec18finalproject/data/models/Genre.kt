package lior.gindi.lec18finalproject.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//All types are DB Compatible
@Entity
data class Genre(
    @PrimaryKey
    @SerializedName("id")
    val genreId: Int,
    val name: String
)