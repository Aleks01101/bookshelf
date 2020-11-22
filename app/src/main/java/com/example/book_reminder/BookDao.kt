package com.example.book_reminder

import androidx.lifecycle.LiveData
import androidx.room.*

/*
zapisuje lub ładuje książkę z baz danych
 */
@Dao
interface BookDao {
    /*
    jeśli spróbujemy wstawić duplikaty rekordów, to istniejący rekord zostanie zastąpiony bieżącym rekordem
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg books:Book)
    @Delete
    fun delete(vararg books:Book)
    /*
    zwróci listę książek
     */
    @Query("select * from book ")
    fun getAll(): LiveData<List<Book>>
}