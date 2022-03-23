package cristian.app.nybooksmvvmkotlin.data.repository

import cristian.app.nybooksmvvmkotlin.data.model.BooksResult

interface BooksRepository {
    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit){
    }
}