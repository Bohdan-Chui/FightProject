package com.project.model.impl;

import com.project.Army;
import com.project.ArmyBattle;
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
                Arguments.of(new Army().addUnits(Warrior.class, 1), new Army().addUnits(Warrior.class, 2), false),
                Arguments.of(new Army().addUnits(Warrior.class, 2), new Army().addUnits(Warrior.class, 3), false),
                Arguments.of(new Army().addUnits(Warrior.class, 5), new Army().addUnits(Warrior.class, 7), false),
                Arguments.of(new Army().addUnits(Warrior.class, 20), new Army().addUnits(Warrior.class, 21), true),
                Arguments.of(new Army().addUnits(Warrior.class, 10), new Army().addUnits(Warrior.class, 11), true),
                Arguments.of(new Army().addUnits(Warrior.class, 11), new Army().addUnits(Warrior.class, 7), true),

                Arguments.of(new Army().addUnits(Warrior.class, 5)
                                .addUnits(Defender.class, 4)
                                .addUnits(Defender.class, 5),
                        new Army().addUnits(Warrior.class, 4), true),

                Arguments.of(new Army().addUnits(Defender.class, 5)
                                .addUnits(Warrior.class, 20)
                                .addUnits(Defender.class, 4),
                        new Army().addUnits(Warrior.class, 21), true),

                Arguments.of(new Army().addUnits(Warrior.class, 10)
                                .addUnits(Defender.class, 5)
                                .addUnits(Defender.class, 10),
                        new Army().addUnits(Warrior.class, 5), true),

                Arguments.of(new Army().addUnits(Defender.class, 2)
                                .addUnits(Warrior.class, 1)
                                .addUnits(Defender.class, 1),
                        new Army().addUnits(Warrior.class, 5), false),
// Vampire class tests
                Arguments.of(new Army().addUnits(Defender.class, 5)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Warrior.class, 7),
                        new Army().addUnits(Warrior.class, 6)
                                .addUnits(Defender.class, 6)
                                .addUnits(Vampire.class, 6), false),
                Arguments.of(new Army().addUnits(Defender.class, 2)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 3), false),
                Arguments.of(new Army().addUnits(Defender.class, 11)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 13), true),
                Arguments.of(new Army().addUnits(Defender.class, 9)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 8),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 13), true),
// Lancen class added
                Arguments.of(new Army().addUnits(Lancen.class, 5)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 2),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancen.class, 5), false),
                Arguments.of(new Army().addUnits(Lancen.class, 7)
                                .addUnits(Vampire.class, 3)
                                .addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 2),
                        new Army().addUnits(Warrior.class, 4)
                                .addUnits(Defender.class, 4)
                                .addUnits(Vampire.class, 6)
                                .addUnits(Lancen.class, 4), true)
        );
    }
}