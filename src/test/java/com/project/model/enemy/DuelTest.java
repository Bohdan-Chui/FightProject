package com.project.model.enemy;

import com.project.model.Fight;

import com.project.model.enemy.impl.Defender;
import com.project.model.enemy.impl.Knight;
import com.project.model.enemy.impl.Rookie;
import com.project.model.enemy.impl.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DuelTest {

    @ParameterizedTest
    @MethodSource
    void fight(boolean expected, Enemy enemy1, Enemy enemy2) {
        Assertions.assertEquals(expected, Fight.duel(enemy1, enemy2));
    }

    static Stream<Arguments> fight() {
        return Stream.of(
                Arguments.of(false, new Warrior(), new Knight()),
                Arguments.of(true, new Knight(), new Warrior())

        );
    }

    @Test
    void fightTest3() {
        Enemy enemy1 = new Warrior();
        Enemy enemy2 = new Warrior();
        Fight.duel(enemy1, enemy2);
        Assertions.assertTrue(enemy1.isAlive());
    }

    @Test
    void fightTest4() {
        Enemy enemy1 = new Knight();
        Enemy enemy2 = new Warrior();
        Fight.duel(enemy1, enemy2);
        Assertions.assertTrue(enemy1.isAlive());
    }

    @Test
    void fightTest5() {
        Enemy enemy1 = new Warrior();
        Enemy enemy2 = new Warrior();
        Fight.duel(enemy1, enemy2);
        Assertions.assertFalse(enemy2.isAlive());
    }

    @Test
    void fightTest6() {
        Enemy enemy1 = new Warrior();
        Enemy enemy2 = new Knight();
        Fight.duel(enemy1, enemy2);
        Assertions.assertTrue(enemy2.isAlive());
    }

    @Test
    void fightTest7() {
        Enemy enemy1 = new Warrior();
        Enemy enemy2 = new Knight();
        Fight.duel(new Warrior(), enemy2);
        Assertions.assertFalse(Fight.duel(enemy2, enemy1));
    }

    @Test
    void fightTest8() {
        Enemy enemy1 = new Defender();
        Enemy enemy2 = new Rookie();
        Fight.duel(enemy1, enemy2);
        Assertions.assertEquals(60, enemy1.getHealth());
    }

    @Test
    void fightTest9() {
        Enemy enemy1 = new Defender();
        Enemy enemy2 = new Rookie();

        Fight.duel(enemy1, enemy2);
        Assertions.assertTrue(Fight.duel(enemy1, new Warrior()));
    }
}