package com.example.lithodemo.litho.view

import com.example.lithodemo.R
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*

@LayoutSpec
object HighLightFeatureViewSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component {
        val card = Card.create(c)
        card.content(
            Column.create(c)
                .child(
                    Image.create(c).drawableRes(R.drawable.ic_search_black_24dp)
                        .widthPercent(100F)
                        .heightPercent(100F)
                )
                .child(
                    Text.create(c)
                        .text("Tìm kiếm")
                        .textSizeRes(R.dimen.text_content)
                )
                .justifyContent(YogaJustify.CENTER)
                .paddingRes(YogaEdge.ALL, R.dimen.sku_padding)
        )
            .widthRes(R.dimen.dp_96)
            .heightRes(R.dimen.dp_96)
            .cornerRadiusRes(R.dimen.card_large_corner)
            .elevationRes(R.dimen.sku_elevation)
        return card.build()
    }
}
