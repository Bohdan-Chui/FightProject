package com.project.model.enemy;

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
                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 1), new Army().addUnits(Warrior.Type.WARRIOR, 2), false),
                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 2), new Army().addUnits(Warrior.Type.WARRIOR, 3), false),
                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 5), new Army().addUnits(Warrior.Type.WARRIOR, 7), false),
                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 20), new Army().addUnits(Warrior.Type.WARRIOR, 21), true),
                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 10), new Army().addUnits(Warrior.Type.WARRIOR, 11), true),
                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 11), new Army().addUnits(Warrior.Type.WARRIOR, 7), true),

                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 5)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.DEFENDER, 5),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4), true),

                Arguments.of(new Army().addUnits(Warrior.Type.DEFENDER, 5)
                                .addUnits(Warrior.Type.WARRIOR, 20)
                                .addUnits(Warrior.Type.DEFENDER, 4),
                        new Army().addUnits(Warrior.Type.WARRIOR, 21), true),

                Arguments.of(new Army().addUnits(Warrior.Type.WARRIOR, 10)
                                .addUnits(Warrior.Type.DEFENDER, 5)
                                .addUnits(Warrior.Type.DEFENDER, 10),
                        new Army().addUnits(Warrior.Type.WARRIOR, 5), true),

                Arguments.of(new Army().addUnits(Warrior.Type.DEFENDER, 2)
                                .addUnits(Warrior.Type.WARRIOR, 1)
                                .addUnits(Warrior.Type.DEFENDER, 1),
                        new Army().addUnits(Warrior.Type.WARRIOR, 5), false),
// Vampire class tests
                Arguments.of(new Army().addUnits(Warrior.Type.DEFENDER, 5)
                                .addUnits(Warrior.Type.VAMPIRE, 6)
                                .addUnits(Warrior.Type.WARRIOR, 7),
                        new Army().addUnits(Warrior.Type.WARRIOR, 6)
                                .addUnits(Warrior.Type.DEFENDER, 6)
                                .addUnits(Warrior.Type.VAMPIRE, 6), false),
                Arguments.of(new Army().addUnits(Warrior.Type.DEFENDER, 2)
                                .addUnits(Warrior.Type.VAMPIRE, 3)
                                .addUnits(Warrior.Type.WARRIOR, 4),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.VAMPIRE, 3), false),
                Arguments.of(new Army().addUnits(Warrior.Type.DEFENDER, 11)
                                .addUnits(Warrior.Type.VAMPIRE, 3)
                                .addUnits(Warrior.Type.WARRIOR, 4),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.VAMPIRE, 13), true),
                Arguments.of(new Army().addUnits(Warrior.Type.DEFENDER, 9)
                                .addUnits(Warrior.Type.VAMPIRE, 3)
                                .addUnits(Warrior.Type.WARRIOR, 8),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.VAMPIRE, 13), true),
// Lancen class added 15-16
                Arguments.of(new Army().addUnits(Warrior.Type.LANCER, 5)
                                .addUnits(Warrior.Type.VAMPIRE, 3)
                                .addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 2),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.VAMPIRE, 6)
                                .addUnits(Warrior.Type.LANCER, 5), false),
                Arguments.of(new Army().addUnits(Warrior.Type.LANCER, 7)
                                .addUnits(Warrior.Type.VAMPIRE, 3)
                                .addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 2),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.VAMPIRE, 6)
                                .addUnits(Warrior.Type.LANCER, 4), true),
                //healer tests, 17-18
                Arguments.of(new Army().addUnits(Warrior.Type.LANCER, 7)
                                .addUnits(Warrior.Type.VAMPIRE, 3)
                                .addUnits(Warrior.Type.HEALER, 1)
                                .addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.HEALER, 1)
                                .addUnits(Warrior.Type.DEFENDER, 2),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.HEALER, 1)
                                .addUnits(Warrior.Type.VAMPIRE, 6)
                                .addUnits(Warrior.Type.LANCER, 4), true),
                Arguments.of(new Army().addUnits(Warrior.Type.LANCER, 1)
                                .addUnits(Warrior.Type.WARRIOR, 3)
                                .addUnits(Warrior.Type.HEALER, 1)
                                .addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.HEALER, 1)
                                .addUnits(Warrior.Type.KNIGHT, 2),
                        new Army().addUnits(Warrior.Type.WARRIOR, 4)
                                .addUnits(Warrior.Type.DEFENDER, 4)
                                .addUnits(Warrior.Type.HEALER, 1)
                                .addUnits(Warrior.Type.VAMPIRE, 6)
                                .addUnits(Warrior.Type.LANCER, 4), false)
        );
    }
}