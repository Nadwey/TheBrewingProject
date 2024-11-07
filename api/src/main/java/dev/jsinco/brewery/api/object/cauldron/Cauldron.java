package dev.jsinco.brewery.api.object.cauldron;

import dev.jsinco.brewery.api.recipe.BrewResult;
import dev.jsinco.brewery.api.recipe.ingredient.Ingredient;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class that contains all the necessary data for a basic cauldron implementation
 */
@Getter
public abstract class Cauldron {
    private final UUID uid;
    private List<Ingredient> ingredients;

    /**
     * Cook time in minutes
     */
    private float cookTime;

    public Cauldron() {
        this.uid = UUID.randomUUID();

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

    /**
     * Fired every minute
     */
    public abstract void handleCookTick();

    /**
     * Fired every tick asynchronously
     */
    public abstract void handleAsyncTick();

    /**
     * Get the brew result, without actually doing anything
     *
     * @return The brew result
     */
    public abstract BrewResult getBrewResult();
}
