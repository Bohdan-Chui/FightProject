package com.project.model.enemy;

import com.project.model.army.impl.Army;
import com.project.model.Fight;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleTest {

    @ParameterizedTest
    @MethodSource
    void fight(Army army1, Army army2, boolean expected) {
        boolean boo = Fight.battle(army1, army2);
        assertEquals(expected, boo);
    }

    private static Stream<Arguments> fight() {
        return Stream.of(

                Arguments.of(new Army().addUnits("WARRIOR", 1),
                        new Army().addUnits("WARRIOR", 2), false),
                Arguments.of(new Army().addUnits("WARRIOR", 2),
                        new Army().addUnits("WARRIOR", 3), false),
                Arguments.of(new Army().addUnits("WARRIOR", 5),
                        new Army().addUnits("WARRIOR", 7), false),
                Arguments.of(new Army().addUnits("WARRIOR", 20),
                        new Army().addUnits("WARRIOR", 21), true),
                Arguments.of(new Army().addUnits("WARRIOR", 10),
                        new Army().addUnits("WARRIOR", 11), true),
                Arguments.of(new Army().addUnits("WARRIOR", 11),
                        new Army().addUnits("WARRIOR", 7), true),
        //7 - 9
                Arguments.of(new Army().addUnits("WARRIOR", 5)
                                .addUnits("DEFENDER", 4)
                                .addUnits("DEFENDER", 5),
                        new Army().addUnits("WARRIOR", 4), true),

                Arguments.of(new Army().addUnits("DEFENDER", 5)
                                .addUnits("WARRIOR", 20)
                                .addUnits("DEFENDER", 4),
                        new Army().addUnits("WARRIOR", 21), true),

                Arguments.of(new Army().addUnits("WARRIOR", 10)
                                .addUnits("DEFENDER", 5)
                                .addUnits("DEFENDER", 10),
                        new Army().addUnits("WARRIOR", 5), true),

                Arguments.of(new Army().addUnits("DEFENDER", 2)
                                .addUnits("WARRIOR", 1)
                                .addUnits("DEFENDER", 1),
                        new Army().addUnits("WARRIOR", 5), false),
        // Vampire class tests 11-14
                Arguments.of(new Army().addUnits("DEFENDER", 5)
                                .addUnits("VAMPIRE", 6)
                                .addUnits("WARRIOR", 7),
                        new Army()
                                .addUnits("WARRIOR", 6)
                                .addUnits("DEFENDER", 6)
                                .addUnits("VAMPIRE", 6), false),
                Arguments.of(new Army()
                                .addUnits("DEFENDER", 2)
                                .addUnits("VAMPIRE", 3)
                                .addUnits("WARRIOR", 4),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("VAMPIRE", 3), false),
                Arguments.of(new Army()
                                .addUnits("DEFENDER", 11)
                                .addUnits("VAMPIRE", 3)
                                .addUnits("WARRIOR", 4),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("VAMPIRE", 13), true),
                Arguments.of(new Army()
                                .addUnits("DEFENDER", 9)
                                .addUnits("VAMPIRE", 3)
                                .addUnits("WARRIOR", 8),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("VAMPIRE", 13), true),

        // Lancer class added 15-16
                Arguments.of(new Army()
                                .addUnits("LANCER", 5)
                                .addUnits("VAMPIRE", 3)
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 2),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("VAMPIRE", 6)
                                .addUnits("LANCER", 5), false),
                Arguments.of(new Army()
                                .addUnits("LANCER", 7)
                                .addUnits("VAMPIRE", 3)
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 2),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("VAMPIRE", 6)
                                .addUnits("LANCER", 4), true),
                //healer tests, 17-18
                Arguments.of(new Army()
                                .addUnits("LANCER", 7)
                                .addUnits("VAMPIRE", 3)
                                .addUnits("HEALER", 1)
                                .addUnits("WARRIOR", 4)
                                .addUnits("HEALER", 1)
                                .addUnits("DEFENDER", 2),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("HEALER", 1)
                                .addUnits("VAMPIRE", 6)
                                .addUnits("LANCER", 4), true),
                Arguments.of(new Army()
                                .addUnits("LANCER", 1)
                                .addUnits("WARRIOR", 3)
                                .addUnits("HEALER", 1)
                                .addUnits("WARRIOR", 4)
                                .addUnits("HEALER", 1)
                                .addUnits("KNIGHT", 2),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("HEALER", 1)
                                .addUnits("VAMPIRE", 6)
                                .addUnits("LANCER", 4), false)
        );
    }
}