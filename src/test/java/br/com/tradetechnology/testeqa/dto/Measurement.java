package br.com.tradetechnology.testeqa.dto;

import com.github.javafaker.Faker;

public enum Measurement {

    MILILITERS("ml"),
    GRAMS("g");

    public final String description;

    private Measurement(String description) {
        this.description = description;
    }

    public static Measurement getRandom() {
        return values()[new Faker().number().numberBetween(0, 1)];
    }
    
}
