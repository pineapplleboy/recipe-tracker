package com.example.recipe_tracker.data.repository

import Recipe
import com.example.recipe_tracker.data.api.SpoonacularAPI
import com.example.recipe_tracker.data.model.RecipeDTO
import com.example.recipe_tracker.data.safeApiCall
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
}

fun RecipeDTO.toDomainModel(): Recipe {
    return Recipe(
        id = this.id,
        title = this.title,
        image = this.image,
        imageType = this.imageType,
        servings = this.servings,
        readyInMinutes = this.readyInMinutes,
        license = this.license,
        sourceName = this.sourceName,
        sourceUrl = this.sourceUrl,
        spoonacularSourceUrl = this.spoonacularSourceUrl,
        aggregateLikes = this.aggregateLikes,
        healthScore = this.healthScore,
        spoonacularScore = this.spoonacularScore,
        pricePerServing = this.pricePerServing,
//        analyzedInstructions = this.analyzedInstructions,
        cheap = this.cheap,
        creditsText = this.creditsText,
        cuisines = this.cuisines,
        dairyFree = this.dairyFree,
        diets = this.diets,
        gaps = this.gaps,
        glutenFree = this.glutenFree,
        instructions = this.instructions,
        ketogenic = this.ketogenic,
        lowFodmap = this.lowFodmap,
        occasions = this.occasions,
        sustainable = this.sustainable,
        vegan = this.vegan,
        vegetarian = this.vegetarian,
        veryHealthy = this.veryHealthy,
        veryPopular = this.veryPopular,
        whole30 = this.whole30,
        weightWatcherSmartPoints = this.weightWatcherSmartPoints,
        dishTypes = this.dishTypes,
//        extendedIngredients = this.extendedIngredients,
        summary = this.summary,
        winePairing = this.winePairing
    )
}