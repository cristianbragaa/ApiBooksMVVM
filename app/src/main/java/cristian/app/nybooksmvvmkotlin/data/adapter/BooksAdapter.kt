package cristian.app.nybooksmvvmkotlin.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cristian.app.nybooksmvvmkotlin.data.model.Book
import cristian.app.nybooksmvvmkotlin.databinding.ItemBookBinding

class BooksAdapter(
    private val books: List<Book>,
    private val onItemClickListener: ((book: Book) -> Unit)
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BooksViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(view: ItemBookBinding, private val onItemClickListener: ((book: Book) -> Unit))
        : RecyclerView.ViewHolder(view.root) {
        private val title = view.txtTitle
        private val author = view.txtAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)

            }
        }
    }
}