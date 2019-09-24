package com.example.lithodemo

import android.content.*
import androidx.lifecycle.*
import com.example.lithodemo.model.*
import com.google.gson.*
import java.io.*

class MyViewModel(
    private val context: Context
) : ViewModel() {

    val categories = MutableLiveData<List<Category>>()

    init {
        getCategories()
    }

    private fun getCategories() {
        try {
            val inputStream = context.resources.assets.open("data/data.json")
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)
            val category = Gson().fromJson(json, Category::class.java)
            val categories = arrayListOf<Category>()
            repeat(40) {
                categories.add(category)
            }
            this.categories.value = categories
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
