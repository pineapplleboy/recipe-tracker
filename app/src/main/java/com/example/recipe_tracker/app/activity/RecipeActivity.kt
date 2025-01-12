package com.example.recipe_tracker.app.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.recipe_tracker.R
import com.example.recipe_tracker.app.adapter.IngredientAdapter
import com.example.recipe_tracker.app.adapter.StepListAdapter
import com.example.recipe_tracker.app.viewmodel.RecipeViewModel
import com.example.recipe_tracker.databinding.ActivityRecipeBinding
import com.example.recipe_tracker.domain.model.Step
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

        val ingredientAdapter = IngredientAdapter()
        binding.ingredientsRecyclerView.apply {

            layoutManager = GridLayoutManager(this.context, 1)
            adapter = ingredientAdapter
        }

        val stepAdapter = StepListAdapter()
        binding.stepsRecyclerView.apply {

            layoutManager = GridLayoutManager(this.context, 1)
            adapter = stepAdapter
        }

        vm.recipe.observe(this) {
            binding.name.text = it.title

            Glide.with(this)
                .load(it.image)
                .into(binding.recipeImage)

            binding.cookingTime.text = "Ready in ${it.readyInMinutes} minutes"
            binding.servings.text = "Servings: ${it.servings}"
            binding.healthScoreText.text = "HealthScore: ${it.healthScore}%"
            binding.spoonacularScoreText.text = "SpoonacularScore: ${it.spoonacularScore}"

            (binding.ingredientsRecyclerView.adapter as IngredientAdapter).submitList(it.extendedIngredients)
//            (binding.stepsRecyclerView.adapter as StepListAdapter).submitList(it.analyzedInstructions.mapIndexed { index, text -> Step(id = index, text = text) })

            changeBar(it.spoonacularScore, binding.spoonacularScoreBar)
            changeBar(it.healthScore.toDouble(), binding.healthScoreBar)
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}

private fun blendColors(color1: Int, color2: Int, ratio: Double): Int {
    val inverseRatio = 1f - ratio
    val r = (Color.red(color1) * inverseRatio + Color.red(color2) * ratio).toInt()
    val g = (Color.green(color1) * inverseRatio + Color.green(color2) * ratio).toInt()
    val b = (Color.blue(color1) * inverseRatio + Color.blue(color2) * ratio).toInt()
    return Color.rgb(r, g, b)
}

private fun changeBar(score: Double, bar: ImageView){
    val maxWidth = bar.width
    val newWidth = (maxWidth * score) / 100

    val layoutParams = bar.layoutParams
    layoutParams.width = newWidth.toInt()
    bar.layoutParams = layoutParams

    val darkRed = Color.rgb(139, 0, 0)
    val darkYellow = Color.rgb(204, 153, 0)
    val darkGreen = Color.rgb(0, 100, 0)

    val newColor = when {
        score <= 50 -> blendColors(darkRed, darkYellow, score / 50f)
        else -> blendColors(darkYellow, darkGreen, (score - 50) / 50f)
    }

    bar.setColorFilter(newColor)
}