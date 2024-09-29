package dev.jsinco.brewery.configuration;

import dev.jsinco.brewery.TheBrewingProject;
import dev.jsinco.brewery.configuration.sections.Config;
import dev.jsinco.brewery.configuration.sections.CustomIngredientsConfig;
import dev.jsinco.brewery.configuration.sections.RecipesConfig;
import dev.jsinco.brewery.configuration.serdes.PercentageTransformer;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.serdes.standard.StandardSerdes;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.Getter;

@Getter
public class ConfigManager {
    private final Config config;
    private final RecipesConfig recipes;
    private final CustomIngredientsConfig customIngredients;

    public ConfigManager() {
        config = createConfig(Config.class, "config.yml");
        recipes = createConfig(RecipesConfig.class, "recipes.yml");
        customIngredients = createConfig(CustomIngredientsConfig.class, "custom-ingredients.yml");
    }

    private <T extends OkaeriConfig> T createConfig(Class<T> configClass, String filename) {
        return eu.okaeri.configs.ConfigManager.create(configClass, (it) -> {
            it.withConfigurer(new YamlSnakeYamlConfigurer(), new StandardSerdes());
            it.withBindFile(TheBrewingProject.getInstance().getDataFolder().toPath().resolve(filename));
            it.withRemoveOrphans(true);
            it.withSerdesPack(registry -> {
                registry.register(new PercentageTransformer());
            });
            it.saveDefaults();
            it.load(true);
        });
    }
}
