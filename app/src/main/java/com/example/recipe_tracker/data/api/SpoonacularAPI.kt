package com.example.recipe_tracker.data.api

import com.example.recipe_tracker.data.model.RecipeDTO
import com.example.recipe_tracker.data.model.RecipesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpoonacularAPI {

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("limitLicense") limitLicense: Boolean,
        @Query("tags") tags: String,
        @Query("number") number: Int
    ): Response<RecipesDTO>

    @GET("recipes/{id}/information?includeNutrition=false")
    suspend fun getRecipeById(
        @Path("id") id: Int
    ): Response<RecipeDTO>
}