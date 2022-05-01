package com.project.model.enemy;

import com.project.model.Fight;
import com.project.model.army.impl.Army;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StraightFightTest {
    @ParameterizedTest
    @MethodSource
    void straightFight(Army army1, Army army2, boolean expected) {
        boolean boo = Fight.straightFight(army1, army2);
        assertEquals(expected, boo);
    }

    private static Stream<Arguments> straightFight() {

        return Stream.of(

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
                                .addUnits("LANCER", 4), false),
                Arguments.of(new Army()
                                .addUnits("LANCER", 4)
                                .addUnits("WARRIOR", 3)
                                .addUnits("HEALER", 1)
                                .addUnits("WARRIOR", 4)
                                .addUnits("HEALER", 1)
                                .addUnits("KNIGHT", 2),
                        new Army()
                                .addUnits("WARRIOR", 4)
                                .addUnits("DEFENDER", 4)
                                .addUnits("HEALER", 1)
                                .addUnits("VAMPIRE", 2)
                                .addUnits("LANCER", 4), true));
    }
}
