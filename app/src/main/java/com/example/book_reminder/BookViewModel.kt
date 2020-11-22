package com.example.book_reminder

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class BookViewModel : AndroidViewModel(BookApplication.instance) {
    //tworzymy egzemplarz bazy danych
    private val db = BookDatabase.getInstance(getApplication())
    private val dao = db!!.bookDao()
    private val service = Executors.newFixedThreadPool(1)

    //pobieramy Livedata z bazy danych
    fun getAll() : LiveData<List<Book>>
    {
        return dao.getAll()
    }

    fun addBook(book: Book)
    {
        service.submit {
            dao.insert(book)
        }
    }

    override fun onCleared() {
        super.onCleared()
        service.shutdown()
    }
}