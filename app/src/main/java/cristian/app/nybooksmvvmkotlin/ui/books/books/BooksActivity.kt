package cristian.app.nybooksmvvmkotlin.ui.books.books

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cristian.app.nybooksmvvmkotlin.R.*
import cristian.app.nybooksmvvmkotlin.data.adapter.BooksAdapter
import cristian.app.nybooksmvvmkotlin.data.repository.BooksApiDataSource
import cristian.app.nybooksmvvmkotlin.databinding.ActivityBooksBinding
import cristian.app.nybooksmvvmkotlin.ui.books.base.BaseActivity
import cristian.app.nybooksmvvmkotlin.ui.books.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BooksActivity : BaseActivity() {

    private lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupToolbar(toolbarMain, string.books_title)

        val viewModel: BooksViewModel = BooksViewModel.ViewModelFactory(BooksApiDataSource())
            .create(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(binding.recyclerBooks) {
                    layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,
                            book.title,
                            book.description)
                        this@BooksActivity.startActivity(intent)

                    }
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                binding.viewFlipperBooks.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessage ->
                    binding.textViewError.text = getString(errorMessage)
                }
            }
        })

        viewModel.getBooks()
    }
}