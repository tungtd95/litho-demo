package com.example.lithodemo.epoxy.view

import com.airbnb.epoxy.*
import com.example.lithodemo.model.*

class SkuEpoxyController : EpoxyController() {

    var categories: List<Category>? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        categories?.forEach {
            val models = mutableListOf<EpoxyModel<*>>()
            it.skus.forEach {
                models.add(
                    SkuItemViewModel_()
                        .id("${it.barcode}${System.currentTimeMillis()}")
                        .sku(it)
                )
            }
            SkuCarouselModel_()
                .id("${SkuCarousel.ID}${System.currentTimeMillis()}")
                .models(models)
                .addTo(this)
        }
    }
}
