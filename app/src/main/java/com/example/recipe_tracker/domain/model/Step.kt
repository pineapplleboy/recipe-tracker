package com.example.recipe_tracker.domain.model

class Step(
    val number: Int,
    val step: String,
    val ingredients: List<Ingredient>,
    val equipment: List<Equipment>
)