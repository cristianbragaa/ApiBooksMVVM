package cristian.app.nybooksmvvmkotlin.ui.books.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

//Config supportActionBar
open class BaseActivity : AppCompatActivity(){

    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false){
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
        if (showBackButton){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}