package com.example.lithodemo.common

import android.graphics.*
import android.view.*
import androidx.recyclerview.widget.*

class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == state.itemCount - 1)
            outRect.right = space
        outRect.left = space
        outRect.bottom = space
        outRect.top = space
    }
}