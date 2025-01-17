package com.example.recipe_tracker.app.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipe_tracker.R
import com.example.recipe_tracker.app.adapter.RecipeListAdapter
import com.example.recipe_tracker.app.viewmodel.RecipesViewModel
import com.example.recipe_tracker.databinding.ActivityRecipesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesActivity : AppCompatActivity() {

    private val vm by viewModel<RecipesViewModel>()
    private lateinit var binding: ActivityRecipesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRecipesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recipeAdapter = RecipeListAdapter()
        binding.recipesRecyclerView.apply {

            layoutManager = GridLayoutManager(this.context, 1)
            adapter = recipeAdapter
        }

        vm.recipes.observe(this) {
            (binding.recipesRecyclerView.adapter as RecipeListAdapter).submitList(it)
        }

        binding.refreshBar.setOnClickListener {
            vm.getRandomRecipes()
        }
    }
}