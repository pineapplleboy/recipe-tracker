package com.example.recipe_tracker.data.transform

import com.example.recipe_tracker.data.model.AnalyzedInstructionsDTO
import com.example.recipe_tracker.domain.model.AnalyzedInstructions

fun AnalyzedInstructionsDTO.toDomainModel(): AnalyzedInstructions{
    return AnalyzedInstructions(
        parsedInstructions = this.parsedInstructions.map { it.toDomainModel() },
        ingredients = this.ingredients.map { it.toDomainModel() },
        equipment = this.equipment.map { it.toDomainModel() }
    )
}