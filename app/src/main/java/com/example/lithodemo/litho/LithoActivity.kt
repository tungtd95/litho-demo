package com.example.lithodemo.litho

import android.os.*
import androidx.appcompat.app.*
import androidx.lifecycle.*
import com.example.lithodemo.MyViewModel
import com.example.lithodemo.model.*
import com.example.lithodemo.litho.view.*
import com.facebook.litho.*
import com.facebook.litho.sections.*
import com.facebook.litho.sections.widget.*

class LithoActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myViewModel = MyViewModel(this)
        myViewModel.categories.observe(this, Observer {
            setContentView(it)
        })
    }

    private fun setContentView(categories: List<Category>) {
        val componentContext = ComponentContext(this)

        val component = RecyclerCollectionComponent.create(componentContext)
            .disablePTR(true)
            .section(
                CategoryListView.create(SectionContext(componentContext))
                    .categories(DynamicValue(categories))
                    .build()
            )
            .build()

        setContentView(LithoView.create(componentContext, component))
        title = "Litho"
    }
}
