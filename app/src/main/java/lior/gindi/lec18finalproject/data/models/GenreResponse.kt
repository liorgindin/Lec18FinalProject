package lior.gindi.lec18finalproject.data.models


import com.google.gson.annotations.SerializedName

data class GenreResponse(
    val genres: List<Genre>,

    //Exception Handling:
    @SerializedName("status_code")
    val statusCode: Int?, //if error: 401/404
    @SerializedName("status_message")
    val statusMessage: String?// 200 - oke, 404 - not found, 401 - unauthorized
)