package dev.jsinco.brewery.api.config;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Percentage {
    private final static Pattern PERCENTAGE_PATTERN = Pattern.compile("(\\d+(\\.\\d+)?)%");

    @Getter
    private final float value;

    /**
     * Constructs a new Percentage object with a specified value.
     *
     * @param percentage a float representing the percentage value.
     *                   <ul>
     *                      <li>0.0 represents 0%</li>
     *                      <li>1.0 represents 100%</li>
     *                   </ul>
     */
    public Percentage(float percentage) {
        this.value = percentage;
    }

    /**
     * Constructs a new Percentage object with a specified value.
     *
     * @param percentage an int representing the percentage value.
     *                   <ul>
     *                      <li>0 represents 0%</li>
     *                      <li>100 represents 100%</li>
     *                   </ul>
     */
    public Percentage(int percentage) {
        this.value = (float) percentage / 100;
    }

    /**
     * Constructs a new Percentage object from a string representation of a percentage.
     *
     * @param percentage  a string representing the percentage value.<br />
     *                    The string needs to match the following format: (\d+(\.\d+)?)%
     */
    public Percentage(String percentage) {
        Matcher matcher = PERCENTAGE_PATTERN.matcher(percentage);

        if (matcher.matches()) {
            this.value = Float.parseFloat(matcher.group(1));
            return;
        }

        throw new IllegalArgumentException("Invalid percentage: " + percentage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Percentage percentage)) {
            return false;
        }

        return this.value == percentage.value;
    }

    @Override
    public String toString() {
        return value * 100 + "%";
    }
}
