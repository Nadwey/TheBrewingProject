package dev.jsinco.brewery.api.object;

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
    private final List<Ingredient> ingredients;
    private final LocalDateTime brewStarted;
    private final ICauldron cauldron;

    public CauldronData(ICauldron cauldron) {
        this.uid = UUID.randomUUID();
        this.ingredients = new ArrayList<>();
        this.brewStarted = LocalDateTime.now();
        this.cauldron = cauldron;
    }

    public void addIngredient(Ingredient ingredient) {
        // add ingredient

    }
}
