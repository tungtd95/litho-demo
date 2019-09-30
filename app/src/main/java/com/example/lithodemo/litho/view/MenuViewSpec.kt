package com.example.lithodemo.litho.view

import android.graphics.*
import com.example.lithodemo.R
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*

@LayoutSpec
object MenuViewSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component {
        val card = Card.create(c)
        card.content(
            Row.create(c)
                .justifyContent(YogaJustify.SPACE_EVENLY)
                .paddingRes(YogaEdge.ALL, R.dimen.delivery_method_padding)
                .child(
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
                .child(
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
                .child(
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
                .child(
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
        )
            .elevationRes(R.dimen.sku_elevation)
        return card.build()
    }
}
