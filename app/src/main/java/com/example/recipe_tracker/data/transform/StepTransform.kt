package com.example.recipe_tracker.data.transform

import com.example.recipe_tracker.data.model.StepDTO
import com.example.recipe_tracker.domain.model.Step

fun StepDTO.toDomainModel(): Step{

    return Step(
        number = this.number,
        step = this.step,
        ingredients = this.ingredients.map { it.toDomainModel() },
        equipment = this.equipment.map { it.toDomainModel() }
    )
}