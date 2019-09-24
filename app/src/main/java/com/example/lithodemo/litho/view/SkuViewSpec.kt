package com.example.lithodemo.litho.view

import android.graphics.*
import android.graphics.Typeface.BOLD
import com.example.lithodemo.R
import com.example.lithodemo.model.*
import com.facebook.drawee.backends.pipeline.*
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.fresco.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*

@LayoutSpec
object SkuViewSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop sku: Sku
    ): Component {
        val controller = Fresco.newDraweeControllerBuilder().setUri(sku.imageUrl).build()
        val image = FrescoImage.create(c)
            .marginRes(YogaEdge.ALL, R.dimen.sku_image_margin)
            .heightRes(R.dimen.sku_image_size)
            .widthRes(R.dimen.sku_image_size)
            .placeholderImageRes(R.drawable.ic_launcher_background)
            .controller(controller)

        return Card.create(c)
            .backgroundColor(Color.WHITE)
            .paddingRes(YogaEdge.ALL, R.dimen.sku_padding)
            .cornerRadiusRes(R.dimen.sku_corner_radius)
            .elevationRes(R.dimen.sku_elevation)
            .widthRes(R.dimen.sku_width)
            .heightRes(R.dimen.sku_height)
            .content(
                Column.create(c)
                    .alignContent(YogaAlign.CENTER)
                    .child(
                        image
                    )
                    .child(
                        Text.create(c)
                            .text(sku.name)
                            .textSizeRes(R.dimen.sku_title_size)
                    )
                    .child(
                        Text.create(c)
                            .text(sku.price.toString())
                            .textSizeRes(R.dimen.sku_price_size)
                            .textColorRes(R.color.red)
                            .textStyle(BOLD)
                    )
                    .build()
            ).build()
    }
}
