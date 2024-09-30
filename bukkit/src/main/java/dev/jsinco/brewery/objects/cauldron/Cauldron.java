package dev.jsinco.brewery.objects.cauldron;

import dev.jsinco.brewery.api.object.CauldronData;
import dev.jsinco.brewery.api.object.ICauldron;
import lombok.Getter;
import java.util.Random;

@Getter
public class Cauldron implements ICauldron {
    private static final Random RANDOM = new Random();

    private final CauldronData cauldronData;

    public Cauldron() {
        cauldronData = new CauldronData(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cauldron cauldron = (Cauldron) obj;
        return cauldronData.getUid().equals(cauldron.cauldronData.getUid());
    }
}
