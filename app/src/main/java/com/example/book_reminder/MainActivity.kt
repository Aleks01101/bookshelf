package com.example.book_reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    /**
     * w polu Klasa utwórzemy prywatny recyclerview
     */
    private  lateinit var list: RecyclerView


    private lateinit var adapter: BooksAdapter
    private lateinit var model: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * znajdujemy list za pomocą Id
         */
        list = findViewById(R.id.list)
        // egzemplarz aktywnosci
        model = ViewModelProvider(this).get(BookViewModel::class.java)

        //wyświetla wszytkie dodane książki
        model.getAll().observe(this, Observer<List<Book>>{
            val a = BooksAdapter(it)
            list.adapter = a
        }
        )


        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,layout.orientation)
        list.layoutManager = layout
        list.addItemDecoration(decoration)


    }
/*
wyświetla i przetwarza menu
 */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    /*
    funkcja dodawania książki
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.main_add -> {
                showAddDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
/*
funkcja tworzenia okna dialogowego menu z dodaniem książki
 */
    private fun showAddDialog() {
    /*
    tworzymy okno dialogowe w formie view
     */
    var view = LayoutInflater.from(this)
        .inflate(R.layout.add_book_dialog, null)


    /*
    szukamy linki do widgetow
     */
    val title = view.findViewById<EditText>(R.id.title)
    val author = view.findViewById<EditText>(R.id.author)
    val date = view.findViewById<EditText>(R.id.date)
    val rating = view.findViewById<RatingBar>(R.id.rating)

    /*
    tworzenie dialogu
     */
    val builder = AlertDialog.Builder(this)
    builder.setView(view)
    builder.setTitle("Create a book")

    builder.setNegativeButton("Cancel") {
        dialog, _ ->
        dialog.cancel()
    }

    builder.setPositiveButton("Create") {
        dialog, _ ->
        val book = Book(title.text.toString(),
            author.text.toString(),
            date.text.toString(),
            rating.rating)
                /*
                nastąpiło wstawienie książki na 0 element
                 */
        model.addBook(book)
        dialog.dismiss()


    }

    builder.create().show()
}
}