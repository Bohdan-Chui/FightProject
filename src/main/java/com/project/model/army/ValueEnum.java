package com.project.model.army;

public enum ValueEnum {

    WARLORD_VALUE(10), HEALER_VALUE(7), ENEMY_VALUE(5), LANCER_VALUE(8);

    private final double value;

    ValueEnum(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
