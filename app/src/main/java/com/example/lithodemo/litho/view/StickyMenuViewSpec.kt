package com.example.lithodemo.litho.view

import com.example.lithodemo.R
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*

@LayoutSpec
object StickyMenuViewSpec {

    @OnCreateLayout
    fun onLayoutCreate(
        c: ComponentContext,
        @Prop alphaDynamic: DynamicValue<Float>,
        @Prop transY: DynamicValue<Float>
    ) : Component {
        return Card.create(c)
            .heightRes(R.dimen.dp_72)
            .widthPercent(100f)
            .content(
                Text.create(c)
                    .text("Sticky so you don't drop it")
                    .textSizeRes(R.dimen.text_content)
                    .heightPercent(100f)
            )
            .positionType(YogaPositionType.ABSOLUTE)
            .alpha(alphaDynamic)
            .translationY(transY)
            .build()
    }
}
