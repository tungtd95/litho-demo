package com.example.lithodemo

import android.app.*
import com.facebook.drawee.backends.pipeline.*

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
