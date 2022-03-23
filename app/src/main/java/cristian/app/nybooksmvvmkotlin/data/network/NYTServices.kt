package cristian.app.nybooksmvvmkotlin.data.network

import cristian.app.nybooksmvvmkotlin.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "n7zCOrXQIZDFJQzDuAmbGZc3wnDo8L6e",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}