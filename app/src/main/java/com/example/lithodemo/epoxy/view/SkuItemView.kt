package com.example.lithodemo.epoxy.view

import android.content.*
import android.util.*
import android.view.*
import androidx.cardview.widget.*
import com.airbnb.epoxy.*
import com.bumptech.glide.*
import com.example.lithodemo.R
import com.example.lithodemo.model.*
import kotlinx.android.synthetic.main.holder_sku_item_view.view.*

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
class SkuItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.holder_sku_item_view, this)
    }

    lateinit var sku: Sku
        @ModelProp set

    @AfterPropsSet
    fun build() {
        tvSkuName.text = sku.name
        tvSkuPrice.text = sku.price.toString()
        Glide.with(this).load(sku.imageUrl).into(ivSku)
    }
}
