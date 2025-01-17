package com.example.recipe_tracker.domain.model

class AnalyzedInstructions(
    val parsedInstructions: List<Instruction>,
    val ingredients: List<Ingredient>,
    val equipment: List<Equipment>
)