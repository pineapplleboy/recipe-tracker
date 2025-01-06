package com.example.recipe_tracker.app.viewholder

import Recipe
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe_tracker.databinding.RecipeCardBinding

class RecipesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = RecipeCardBinding.bind(view)
    private var id: Int? = null

    init {
//        binding.moviePoster.setOnClickListener {
//            val intent = Intent(view.context, MovieDetailsActivity::class.java).apply {
//                putExtra("MOVIE_ID", id)
//            }
//
//            view.context.startActivity(intent)
//        }
    }

    fun bind(recipe: Recipe) = with(binding) {

        id = recipe.id

        Glide.with(view)
            .load(recipe.image)
            .into(moviePoster)

        name.text = recipe.title
    }
}