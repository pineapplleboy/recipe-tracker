package com.example.recipe_tracker.app.adapter

import Recipe
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.recipe_tracker.R
import com.example.recipe_tracker.app.viewholder.RecipesViewHolder

class RecipeListAdapter : ListAdapter<Recipe, RecipesViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<Recipe>() {
            override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        return RecipesViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recipe_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val element = getItem(position)
        holder.bind(element)
    }
}