package com.example.lithodemo.litho.view

import com.example.lithodemo.model.Category
import com.facebook.litho.annotations.*
import com.facebook.litho.sections.*
import com.facebook.litho.sections.annotations.*
import com.facebook.litho.sections.common.*

@GroupSectionSpec
object CategoryViewSpec {

    @OnCreateChildren
    fun onCreateChildren(
        c: SectionContext,
        @Prop category: Category
    ): Children {
        val builder = Children.create()
        category.skus.forEach {
            builder.child(
                SingleComponentSection.create(c)
                    .key(it.barcode)
                    .component(
                        SkuView.create(c)
                            .sku(it)
                            .build()
                    )
            )
        }
        return builder.build()
    }
}
