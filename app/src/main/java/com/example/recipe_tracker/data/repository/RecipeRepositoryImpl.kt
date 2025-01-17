package com.example.recipe_tracker.data.repository

import Recipe
import com.example.recipe_tracker.data.api.SpoonacularAPI
import com.example.recipe_tracker.data.safeApiCall
import com.example.recipe_tracker.data.transform.toDomainModel
import com.example.recipe_tracker.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    private val api: SpoonacularAPI
) : RecipeRepository {

    override suspend fun getRandomRecipes(
        limitLicense: Boolean,
        tags: String,
        number: Int
    ): Result<List<Recipe>> {

        return safeApiCall(
            apiCall = { api.getRandomRecipes(limitLicense, tags, number) },
            transform = {
                it.recipes.map{ recipeDTO -> recipeDTO.toDomainModel() }
            }
        )
    }

    override suspend fun getRecipeById(
        id: Int
    ): Result<Recipe> {
        return safeApiCall(
            apiCall = { api.getRecipeById(id) },
            transform = { it.toDomainModel() }
        )
    }
}