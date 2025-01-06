import com.example.recipe_tracker.data.model.RecipeDTO
import com.example.recipe_tracker.domain.model.Ingredient

class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String?,
    val servings: Int,
    val readyInMinutes: Int,
    val license: String?,
    val sourceName: String?,
    val sourceUrl: String?,
    val spoonacularSourceUrl: String?,
    val aggregateLikes: Int,
    val healthScore: Int,
    val spoonacularScore: Double,
    val pricePerServing: Double,
//    val analyzedInstructions: List<String>,
    val cheap: Boolean,
    val creditsText: String?,
    val cuisines: List<String>,
    val dairyFree: Boolean,
    val diets: List<String>,
    val gaps: String?,
    val glutenFree: Boolean,
    val instructions: String?,
    val ketogenic: Boolean,
    val lowFodmap: Boolean,
    val occasions: List<String>,
    val sustainable: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val whole30: Boolean,
    val weightWatcherSmartPoints: Int,
    val dishTypes: List<String>,
//    val extendedIngredients: List<Ingredient>,
    val summary: String?,
    val winePairing: RecipeDTO.WinePairing?
) {
    class WinePairing(
        val pairedWines: List<String>,
        val pairingText: String?,
        val productMatches: List<ProductMatch>
    ) {
        class ProductMatch(
            val id: Int,
            val title: String,
            val description: String?,
            val price: String?,
            val imageUrl: String?,
            val averageRating: Double,
            val ratingCount: Int,
            val score: Double,
            val link: String?
        )
    }
}
