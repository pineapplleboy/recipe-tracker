package com.example.recipe_tracker.app.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.recipe_tracker.R
import com.example.recipe_tracker.app.viewmodel.RecipeViewModel
import com.example.recipe_tracker.databinding.ActivityRecipeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeBinding
    private val vm by viewModel<RecipeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRecipeBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id = intent.getIntExtra("RECIPE_ID", 0)

        vm.getRecipeById(id)

        vm.recipe.observe(this) {
            binding.name.text = it.title

            Glide.with(this)
                .load(it.image)
                .into(binding.recipeImage)

            binding.cookingTime.text = "Ready in ${it.readyInMinutes} minutes"
            binding.servings.text = "Servings: ${it.servings}"
            binding.healthScoreText.text = "HealthScore: ${it.healthScore}%"
            binding.spoonacularScoreText.text = "spoonacularScore: ${it.spoonacularScore}"
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}