package dev.jsinco.brewery;

import dev.jsinco.brewery.configuration.ConfigManager;
import dev.jsinco.brewery.factories.RecipeFactory;
import dev.jsinco.brewery.listeners.BreweryEvents;
import dev.jsinco.brewery.objects.cauldron.CauldronManager;
import dev.jsinco.brewery.recipes.ingredient.custom.CustomIngredientManager;
import dev.jsinco.brewery.recipes.ingredient.external.OraxenPluginIngredient;
import dev.jsinco.brewery.recipes.ingredient.PluginIngredient;
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

    public void registerPluginIngredients() {
        PluginIngredient.registerPluginIngredient("Custom", CustomIngredientManager::new, false);
        PluginIngredient.registerPluginIngredient("Oraxen", OraxenPluginIngredient::new, true);
    }
}