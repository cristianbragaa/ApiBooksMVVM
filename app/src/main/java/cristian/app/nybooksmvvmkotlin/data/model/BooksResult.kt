package cristian.app.nybooksmvvmkotlin.data.model

sealed class BooksResult {
    class Sucess(val books: List<Book>) : BooksResult()
    class ApiError(val statusCode: Int) : BooksResult()
    object ServerError : BooksResult()
}