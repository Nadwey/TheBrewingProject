package dev.jsinco.brewery.configuration.sections;

import dev.jsinco.brewery.api.config.Percentage;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RecipesConfig extends OkaeriConfig {
    private Map<String, ConfigurationRecipe> recipes;

    @Getter
    public class ConfigurationRecipe extends OkaeriConfig {
        @CustomKey("brew-time")
        private Duration brewTime;

        @CustomKey("brew-difficulty")
        private Integer brewDifficulty = 1;

        private Percentage alcohol = new Percentage(0);

        @CustomKey("cauldron-type")
        private String cauldronType = "WATER";

        @CustomKey("heat-sources")
        private List<String> heatSources;

        private List<String> ingredients;

        @CustomKey("potion-attributes")
        private PotionAttributes potionAttributes = new PotionAttributes();

        @Getter
        public class PotionAttributes extends OkaeriConfig {
            private String name;

            private String color = "AQUA";

            private Boolean glint = false;

            @CustomKey("custom-model-data")
            private String customModelData = null;

            private List<String> lore = null;
        }

        private Distilling distilling = new Distilling();

        @Getter
        public class Distilling extends OkaeriConfig {
            private Integer runs = 0;

            private Duration time = Duration.ZERO;
        }

        private Aging aging = new Aging();

        @Getter
        public class Aging {
            @CustomKey("barrel-type")
            private String barrelType = null;

            private Integer years = 0;
        }

        private List<String> commands;

        private List<String> effects;

        private Map<String, String> messages;
    }

    private Map<String, ConfigurationDefaultRecipe> defaultRecipes;

    @Getter
    public class ConfigurationDefaultRecipe extends OkaeriConfig {
        private String name = "Caludron Brew";

        private List<String> lore;

        @CustomKey("custom-model-data")
        private String customModelData;

        private String color = "BLUE";

        private Boolean glint = false;
    }
}
