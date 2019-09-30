package com.example.lithodemo.litho.view

import android.graphics.Typeface.BOLD
import com.example.lithodemo.R
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*

@LayoutSpec
object ShoppingMethodViewSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component {
        val card = Card.create(c)
        card.content(
            Row.create(c)
                .child(
                    Column.create(c)
                        .child(
                            Text.create(c)
                                .text("Phương thức nhận hàng")
                                .textSizeRes(R.dimen.text_content)
                                .textStyle(BOLD)
                        )
                        .child(
                            Text.create(c)
                                .text("Vui lòng chọn phương thức nhận hàng")
                                .textSizeRes(R.dimen.text_normal)
                        )
                )
                .child(
                    Image.create(c)
                        .drawableRes(R.drawable.ic_arrow_right)
                )
                .paddingRes(YogaEdge.ALL, R.dimen.delivery_method_padding)
                .justifyContent(YogaJustify.SPACE_BETWEEN)
        )
            .cornerRadiusRes(R.dimen.sku_corner_radius)
            .elevationRes(R.dimen.sku_elevation)
            .marginRes(YogaEdge.ALL, R.dimen.delivery_method_padding)
        return card.build()
    }
}
