package com.example.recipe_tracker.app.viewmodel

import Recipe
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_tracker.domain.usecase.GetRecipeByIdUseCase
import kotlinx.coroutines.launch

class RecipeViewModel(
    val getRecipeByIdUseCase: GetRecipeByIdUseCase
): ViewModel() {

    private val recipeMutable = MutableLiveData<Recipe>()
    val recipe: LiveData<Recipe> get() = recipeMutable

    fun getRecipeById(id: Int){
        viewModelScope.launch {
            val result = getRecipeByIdUseCase.execute(id)

            result.onSuccess {
                recipeMutable.value = it
            }
        }
    }
}