package com.example.recipe_tracker.app.viewmodel

import Recipe
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_tracker.domain.usecase.GetRandomRecipesUseCase
import kotlinx.coroutines.launch

class RecipesViewModel(
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase
): ViewModel() {

    private val recipesMutable = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> get() = recipesMutable

    init{
        getRandomRecipes()
    }

    fun getRandomRecipes(){

        viewModelScope.launch {
            val result = getRandomRecipesUseCase.execute(
                limitLicense = true,
                tags = "",
                number = 10
            )

            result.onSuccess {
                recipesMutable.value = it
            }
            result.onFailure {
                Log.d("PISKA", it.message.toString())
            }
        }
    }
}