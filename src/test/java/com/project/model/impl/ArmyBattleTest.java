package com.project.model.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArmyBattleTest {
    ArmyBattle armyBattle;

    @BeforeAll
    void beforeAll() {
        this.armyBattle = new ArmyBattle();
    }

    @ParameterizedTest
    @MethodSource
    void fight(Army army1, Army army2, boolean expected) {
        boolean boo = armyBattle.fight(army1, army2);
        assertEquals(expected, boo);
    }

    private static Stream<Arguments> fight() {
        return Stream.of(
                Arguments.of(new Army().addUnit(Warrior.class, 1), new Army().addUnit(Warrior.class, 2), false),
                Arguments.of(new Army().addUnit(Warrior.class, 2), new Army().addUnit(Warrior.class, 3), false),
                Arguments.of(new Army().addUnit(Warrior.class, 5), new Army().addUnit(Warrior.class, 7), false),
                Arguments.of(new Army().addUnit(Warrior.class, 20), new Army().addUnit(Warrior.class, 21), true),
                Arguments.of(new Army().addUnit(Warrior.class, 10), new Army().addUnit(Warrior.class, 11), true),
                Arguments.of(new Army().addUnit(Warrior.class, 11), new Army().addUnit(Warrior.class, 7), true),

                Arguments.of(new Army().addUnit(Warrior.class, 5)
                                .addUnit(Defender.class, 4)
                                .addUnit(Defender.class, 5),
                        new Army().addUnit(Warrior.class, 4), true),

                Arguments.of(new Army().addUnit(Defender.class, 5)
                                .addUnit(Warrior.class, 20)
                                .addUnit(Defender.class, 4),
                        new Army().addUnit(Warrior.class, 21), true),

                Arguments.of(new Army().addUnit(Warrior.class, 10)
                                .addUnit(Defender.class, 5)
                                .addUnit(Defender.class, 10),
                        new Army().addUnit(Warrior.class, 5), true),

                Arguments.of(new Army().addUnit(Defender.class, 2)
                                .addUnit(Warrior.class, 1)
                                .addUnit(Defender.class, 1),
                        new Army().addUnit(Warrior.class, 5), false)
        );
    }
}