package dev.jsinco.brewery.api.object.cauldron;

import dev.jsinco.brewery.api.recipe.ingredient.Ingredient;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class that contains all the necessary data for a basic cauldron implementation
 */
@Getter
public class CauldronData {
    private final UUID uid;
    private final ICauldron cauldron;
    private List<Ingredient> ingredients;

    /**
     * Cook time in minutes
     */
    private float cookTime;

    public CauldronData(ICauldron cauldron) {
        this.uid = UUID.randomUUID();
        this.cauldron = cauldron;

        restartCooking();
    }

    public void restartCooking() {
        this.ingredients = new ArrayList<>();
        this.cookTime = 0;
    }

    public void increaseCookTime() {
        this.cookTime++;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }



}
