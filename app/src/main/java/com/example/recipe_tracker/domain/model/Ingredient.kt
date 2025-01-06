package com.example.recipe_tracker.domain.model

class Ingredient(
    val id: Int,
    val name: String,
    val amount: Double,
    val unit: String?,
    val aisle: String?,
    val consistency: String?,
    val original: String,
    val meta: List<String>,
    val image: String?,
    val measures: Measures
) {
    class Measures(
        val metric: Measure,
        val us: Measure
    ) {
        class Measure(
            val amount: Double,
            val unitShort: String?,
            val unitLong: String?
        )
    }
}
