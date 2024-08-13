package dev.jsinco.brewery.recipes;

import dev.jsinco.brewery.enums.BarrelType;
import dev.jsinco.brewery.enums.CauldronType;
import dev.jsinco.brewery.enums.PotionQuality;
import dev.jsinco.brewery.recipes.ingredients.Ingredient;
import lombok.Getter;
import org.bukkit.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Full recipe object used for creating a potion based off of a recipe.
 */
@Getter
public class Recipe extends ReducedRecipe {

    private final int alcohol;

    // Potion attributes
    private final Map<PotionQuality, String> names;
    private final Map<PotionQuality, List<String>> lore;
    private final boolean glint;

    // Commands
    private final Map<PotionQuality, List<String>> commands;
    // Effects
    private final Map<PotionQuality, RecipeEffect> effects;
    // Messages <-- Consider removing because server owners can use commands
    private final String title;
    private final String message;
    private final String actionBar;


    public Recipe(String recipeName, int brewTime, int brewDifficulty, int alcohol, CauldronType cauldronType, List<Ingredient> ingredients, Map<PotionQuality, String> names, Map<PotionQuality, List<String>> lore, Color color, boolean glint, int distillRuns, int distillTime, BarrelType barrelType, int agingYears, Map<PotionQuality, List<String>> commands, Map<PotionQuality, RecipeEffect> effects, String title, String message, String actionBar) {
        super(recipeName, ingredients, brewTime, color, brewDifficulty, cauldronType, barrelType, agingYears, distillRuns, distillTime);
        this.alcohol = alcohol;
        this.names = names;
        this.lore = lore == null ? new HashMap<>() : lore;
        this.glint = glint;
        this.commands = commands == null ? new HashMap<>() : commands;
        this.effects = effects == null ? new HashMap<>() : effects;
        this.title = title;
        this.message = message;
        this.actionBar = actionBar;
    }
}