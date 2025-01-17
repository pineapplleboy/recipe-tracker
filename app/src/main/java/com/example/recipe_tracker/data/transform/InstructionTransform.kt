package com.example.recipe_tracker.data.transform

import com.example.recipe_tracker.data.model.InstructionDTO
import com.example.recipe_tracker.domain.model.Instruction

fun InstructionDTO.toDomainModel(): Instruction{

    return Instruction(
        name = this.name,
        steps = this.steps.map { it.toDomainModel() }
    )
}