package com.example.recipe_tracker.domain.usecase

import Recipe
import com.example.recipe_tracker.domain.repository.RecipeRepository

class GetRecipeByIdUseCase(
    private val repository: RecipeRepository
) {
    suspend fun execute(id: Int): Result<Recipe> {
        return repository.getRecipeById(id)
    }
}