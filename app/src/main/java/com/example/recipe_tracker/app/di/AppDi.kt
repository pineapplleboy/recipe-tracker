package com.example.recipe_tracker.app.di

import com.example.recipe_tracker.app.viewmodel.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<RecipesViewModel> {
        RecipesViewModel(getRandomRecipesUseCase = get())
    }
}