package com.example.recipe_tracker.app.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_tracker.databinding.IngredientCardBinding
import com.example.recipe_tracker.domain.model.Ingredient

class IngredientsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = IngredientCardBinding.bind(view)
    private var id: Int? = null

    init {
//        binding.recipeCard.setOnClickListener {
//            val intent = Intent(view.context, RecipeActivity::class.java).apply {
//                putExtra("RECIPE_ID", id)
//            }
//
//            view.context.startActivity(intent)
//        }
    }

    fun bind(ingredient: Ingredient) = with(binding) {

        id = ingredient.id

        name.text = ingredient.name
        amount.text = "${ingredient.amount} ${ingredient.measures?.metric?.unitShort}"
    }
}