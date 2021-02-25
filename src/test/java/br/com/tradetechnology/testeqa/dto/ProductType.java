package br.com.tradetechnology.testeqa.dto;

import com.github.javafaker.Faker;

public enum ProductType {

    AGUAS("Águas"),
    BEBIDAS_LACTEAS("Bebidas lácteas"),
    ENERGETICOS("Energéticos"),
    REFRIGERANTES("Refrigerantes"),
    SUCOS("Sucos");

    public final String description;

    private ProductType(String description) {
        this.description = description;
    }

    public static ProductType getRandom() {
        return values()[new Faker().number().numberBetween(0, values().length - 1)];
    }

}
