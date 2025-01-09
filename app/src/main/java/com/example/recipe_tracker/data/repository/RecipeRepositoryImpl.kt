package com.example.recipe_tracker.data.repository

import Recipe
import com.example.recipe_tracker.data.api.SpoonacularAPI
import com.example.recipe_tracker.data.model.IngredientDTO
import com.example.recipe_tracker.data.model.RecipeDTO
import com.example.recipe_tracker.data.safeApiCall
import com.example.recipe_tracker.domain.model.Ingredient
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
        extendedIngredients = this.extendedIngredients.map { it.toDomainModel() },
        summary = this.summary,
        winePairing = this.winePairing
    )
}

fun IngredientDTO.toDomainModel(): Ingredient {
    return Ingredient(
        id = this.id,
        name = this.name,
        amount = this.amount,
        unit = this.unit,
        aisle = this.aisle,
        consistency = this.consistency,
        original = this.original,
        meta = this.meta,
        image = this.image,
        measures = Ingredient.Measures(
            metric = Ingredient.Measures.Measure(
                amount = this.measures.metric.amount,
                unitShort = this.measures.metric.unitShort,
                unitLong = this.measures.metric.unitLong
            ),
            us = Ingredient.Measures.Measure(
                amount = this.measures.us.amount,
                unitShort = this.measures.us.unitShort,
                unitLong = this.measures.us.unitLong
            )
        )
    )
}