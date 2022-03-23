package cristian.app.nybooksmvvmkotlin.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Call

@JsonClass(generateAdapter = true)
data class BookBodyResponse(
    @Json(name = "results")
    val bookResults: List<BookResultsResponse>,
)