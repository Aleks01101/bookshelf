package com.example.book_reminder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * ładuje z kontenera następną książkę i na podstawie tego skoroszytu robi view
 */

class BooksAdapter(val Books : List<Book>) : RecyclerView.Adapter<BookHolder>() {
/*
metoda ktora tworzy view
 */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.book,parent,false)
        return BookHolder(view)


    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val book = Books[position]
        holder.bind(book)

    }
    /*
    metoda-ile elementów powinno przejść do Recyclerview
     */
    override fun getItemCount(): Int {
        return Books.size

    }
}