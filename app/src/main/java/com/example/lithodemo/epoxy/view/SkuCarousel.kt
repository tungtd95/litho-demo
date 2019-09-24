package com.example.lithodemo.epoxy.view

import android.content.*
import android.util.*
import com.airbnb.epoxy.*

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
class SkuCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Carousel(context, attrs, defStyleAttr) {

    companion object {
        const val ID = "SkuCarousel"
    }
}
