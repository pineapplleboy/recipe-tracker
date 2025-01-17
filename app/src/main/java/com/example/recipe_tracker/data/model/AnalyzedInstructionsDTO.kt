package com.example.recipe_tracker.data.model

class AnalyzedInstructionsDTO(
    val parsedInstructions: List<InstructionDTO>,
    val ingredients: List<IngredientDTO>,
    val equipment: List<EquipmentDTO>
)