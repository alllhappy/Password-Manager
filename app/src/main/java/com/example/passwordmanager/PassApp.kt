package com.example.passwordmanager

import android.app.Application

class PassApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}