package dev.jsinco.bukkit;

import dev.jsinco.bukkit.config.ConfigManager;
import dev.jsinco.bukkit.factories.RecipeFactory;
import dev.jsinco.bukkit.listeners.BreweryEvents;
import dev.jsinco.bukkit.object.cauldron.CauldronManager;
import dev.jsinco.bukkit.recipe.ingredient.custom.CustomIngredientManager;
import dev.jsinco.bukkit.recipe.ingredient.external.OraxenPluginIngredient;
import dev.jsinco.bukkit.recipe.ingredient.PluginIngredient;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

public class TheBrewingProject extends JavaPlugin {

    @Getter
    private static TheBrewingProject instance;
    @Getter
    private ConfigManager configManager;
    @Getter
    private CauldronManager cauldronManager;
    @Getter @Setter
    private static RecipeFactory recipeFactory;

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        instance = this;
        configManager = new ConfigManager();
        cauldronManager = new CauldronManager();
        recipeFactory = new RecipeFactory();
        CustomIngredientManager.reloadCustomIngredients();

        this.registerPluginIngredients();
        this.getServer().getPluginManager().registerEvents(new BreweryEvents(), this);



        // Start ticking objects

    }

    @Override
    public void onDisable() {
        cauldronManager.disable();
    }

    public void registerPluginIngredients() {
        PluginIngredient.registerPluginIngredient("Custom", CustomIngredientManager::new, false);
        PluginIngredient.registerPluginIngredient("Oraxen", OraxenPluginIngredient::new, true);
    }
}