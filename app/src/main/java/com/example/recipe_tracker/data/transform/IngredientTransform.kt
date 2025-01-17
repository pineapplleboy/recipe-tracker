package com.example.recipe_tracker.data.transform

import com.example.recipe_tracker.data.model.IngredientDTO
import com.example.recipe_tracker.domain.model.Ingredient

fun IngredientDTO.toDomainModel(): Ingredient {
    return Ingredient(
        id = this.id,
        name = this.name,
        amount = this.amount,
        unit = this.unit,
        aisle = this.aisle,
        consistency = this.consistency,
        original = this.original,
        meta = this.meta,
        image = this.image,
        measures = Ingredient.Measures(
            metric = Ingredient.Measures.Measure(
                amount = this.measures.metric.amount,
                unitShort = this.measures.metric.unitShort,
                unitLong = this.measures.metric.unitLong
            ),
            us = Ingredient.Measures.Measure(
                amount = this.measures.us.amount,
                unitShort = this.measures.us.unitShort,
                unitLong = this.measures.us.unitLong
            )
        )
    )
}