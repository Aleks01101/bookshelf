package com.example.book_reminder

import android.view.TextureView
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
/**
*Holder przechowuje w sobie view który jest tworzony dla każdej z książek
 */
class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(Book: Book) {
        title.text = Book.title
        author.text = Book.author
        rating.rating = Book.rating
        date.text = Book.date


    }

    var title: TextView = itemView.findViewById(R.id.title)
    var author: TextView = itemView.findViewById(R.id.author)
    var rating: RatingBar = itemView.findViewById(R.id.ratingBar)
    var date: TextView = itemView.findViewById(R.id.date)
}