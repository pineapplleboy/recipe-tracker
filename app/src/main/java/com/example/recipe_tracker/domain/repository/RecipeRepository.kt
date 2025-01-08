package com.example.recipe_tracker.domain.repository

import Recipe

interface RecipeRepository {
    suspend fun getRandomRecipes(
        limitLicense: Boolean,
        tags: String,
        number: Int
    ): Result<List<Recipe>>

    suspend fun getRecipeById(
        id: Int
    ): Result<Recipe>
}