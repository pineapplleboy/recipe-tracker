package com.example.recipe_tracker.app.di

import AuthorizationInterceptor
import com.example.recipe_tracker.data.api.SpoonacularAPI
import com.example.recipe_tracker.data.repository.RecipeRepositoryImpl
import com.example.recipe_tracker.domain.repository.RecipeRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        val apiKey = "85efce459d6d4800ab6d3c084e74b014"
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor(apiKey))
            .build()

        Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    single { get<Retrofit>().create(SpoonacularAPI::class.java) }

    single<RecipeRepository>{
        RecipeRepositoryImpl(get())
    }
}