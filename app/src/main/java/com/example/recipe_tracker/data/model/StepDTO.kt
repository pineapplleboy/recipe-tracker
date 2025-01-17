package com.example.recipe_tracker.data.model

class StepDTO(
    val number: Int,
    val step: String,
    val ingredients: List<IngredientDTO>,
    val equipment: List<EquipmentDTO>
)