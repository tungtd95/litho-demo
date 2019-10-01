package com.example.lithodemo.litho

import android.os.*
import android.util.*
import androidx.appcompat.app.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.*
import com.example.lithodemo.*
import com.example.lithodemo.R
import com.example.lithodemo.litho.view.*
import com.example.lithodemo.model.*
import com.facebook.litho.*
import com.facebook.litho.sections.*
import com.facebook.litho.sections.widget.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*
import kotlin.math.*

class LithoActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel
    private var stickyAlpha = DynamicValue<Float>(0f)
    private var stickyTransitionY = DynamicValue<Float>(0f)

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
            .onScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    val targetPosition = 2
                    val currentFirstPosition =
                        recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0))
                    var stickyProgress = 1f
                    if (currentFirstPosition <= targetPosition) {
                        // This is when target item has not scrolled off screen yet
                        val realTargetPosition = targetPosition - currentFirstPosition
                        recyclerView.getChildAt(realTargetPosition)?.let {
                            stickyProgress = if (it.y > 0) 0f else abs(it.y) / it.height
                        }
                    }
                    stickyAlpha.set(stickyProgress)
                    stickyTransitionY.set(-(1 - stickyProgress) * resources.getDimension(R.dimen.dp_72))
                }
            })
            .heightPercent(100f)
            .build()

        val stickyMenu = StickyMenuView.create(componentContext)
            .alphaDynamic(stickyAlpha)
            .transY(stickyTransitionY)

        setContentView(
            LithoView.create(
                componentContext,
                Column.create(componentContext)
                    .heightPercent(100f)
                    .child(component)
                    .child(stickyMenu)
                    .build()
            )
        )
        title = "Litho"
    }
}
