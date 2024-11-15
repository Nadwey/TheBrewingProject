package dev.jsinco.brewery.api.object.cauldron;

import dev.jsinco.brewery.api.recipe.ingredient.Ingredient;

import java.util.List;

/**
 *
 */
public interface ICauldron {
    List<Ingredient> getIngredients();
}
