package products;

import java.util.HashSet;
import java.util.Set;

public class RecipeBook {
    private Set<Recipe> recipes = new HashSet<>();

    public void addRecipe(Recipe recipe) {
        if (recipes.contains(recipe)) {
            throw new RuntimeException("Вы пытаетесть добавить рецепт, который уже есть");
        } else {
            recipes.add(recipe);
        }
    }

    public void remove(Recipe recipe) {
        recipes.remove(recipe);
    }
}

