package com.example.recipe_tracker.app.di

import com.example.recipe_tracker.domain.usecase.GetRandomRecipesUseCase
import org.koin.dsl.module

val domainModule =  module {
    factory<GetRandomRecipesUseCase>{
        GetRandomRecipesUseCase(get())
    }
}