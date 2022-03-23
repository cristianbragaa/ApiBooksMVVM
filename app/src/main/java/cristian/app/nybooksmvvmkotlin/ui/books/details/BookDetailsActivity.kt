package cristian.app.nybooksmvvmkotlin.ui.books.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cristian.app.nybooksmvvmkotlin.R.string
import cristian.app.nybooksmvvmkotlin.databinding.ActivityBookDetailsBinding
import cristian.app.nybooksmvvmkotlin.ui.books.base.BaseActivity
import kotlinx.android.synthetic.main.include_toolbar.*

class BookDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupToolbar(toolbarMain, string.book_detail_title, true)

        binding.bookDetailsTitle.text = intent.getStringExtra(EXTRA_TITLE)
        binding.bookDetailsDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)

    }

    companion object{
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent{
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}