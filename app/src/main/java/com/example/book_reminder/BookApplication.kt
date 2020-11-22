package com.example.book_reminder

import android.app.Application


//reprezentuje Context
//rejestruje się w manifeście
class BookApplication : Application() {
    companion object {
        //można odwoływać się jako BookApplication.instance
        lateinit var instance: BookApplication
    }

    //uruchamia się po uruchomieniu aplikacji
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}