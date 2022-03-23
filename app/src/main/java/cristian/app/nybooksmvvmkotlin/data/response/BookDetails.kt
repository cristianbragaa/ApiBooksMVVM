package cristian.app.nybooksmvvmkotlin.data.response

import com.squareup.moshi.JsonClass
import cristian.app.nybooksmvvmkotlin.data.model.Book

@JsonClass(generateAdapter = true)
data class BookDetails(
    val title: String,
    val author: String,
    val description: String,
) {
    fun getBookModel() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}