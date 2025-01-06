package com.example.recipe_tracker.domain.usecase

import Recipe
import com.example.recipe_tracker.domain.repository.RecipeRepository

class GetRandomRecipesUseCase(
    private val repository: RecipeRepository
) {

    suspend fun execute(
        limitLicense: Boolean,
        tags: String,
        number: Int
    ): Result<List<Recipe>>{
        return repository.getRandomRecipes(
            limitLicense = limitLicense,
            tags = tags,
            number = number
        )
    }
}