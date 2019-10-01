package com.example.lithodemo.litho.view

import androidx.recyclerview.widget.*
import com.example.lithodemo.R
import com.example.lithodemo.common.*
import com.example.lithodemo.model.*
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.sections.*
import com.facebook.litho.sections.annotations.*
import com.facebook.litho.sections.common.*
import com.facebook.litho.sections.widget.*
import com.facebook.litho.widget.*
import com.facebook.yoga.*

@GroupSectionSpec
object CategoryListViewSpec {

    @OnCreateChildren
    fun onCreateLayout(
        c: SectionContext,
        @Prop categories: DynamicValue<List<Category>?>
    ): Children {
        val builder = Children.create()
        builder.child(
            SingleComponentSection.create(c).component(ShoppingMethodView.create(c).build())
        )
        builder.child(
            SingleComponentSection.create(c)
                .component(
                    Row.create(c)
                        .child(HighLightFeatureView.create(c).build())
                        .justifyContent(YogaJustify.SPACE_AROUND)
                        .marginRes(YogaEdge.ALL, R.dimen.sku_margin)
                )
        )
        builder.child(
            SingleComponentSection.create(c).component(MenuView.create(c).build())
        )
        categories.get()?.forEach {
            val list = RecyclerCollectionComponent.create(c)
                .heightRes(R.dimen.sku_list_height)
                .recyclerConfiguration(
                    ListRecyclerConfiguration.create()
                        .orientation(OrientationHelper.HORIZONTAL)
                        .build()
                )
                .itemDecoration(
                    SpacesItemDecoration(c.resources.getDimension(R.dimen.sku_margin).toInt())
                )
                .section(
                    CategoryView.create(SectionContext(c))
                        .category(it)
                        .build()
                )
                .build()
            val component = SingleComponentSection.create(c)
                .key(it.title)
                .component(list)

            builder.child(component)
        }
        return builder.build()
    }
}
