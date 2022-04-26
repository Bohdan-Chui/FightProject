package com.project.model.enemy;

import com.project.model.Fight;

import static org.junit.Assert.*;

import com.project.model.FightImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FightImplTest {
    Warrior enemy1;
    Warrior enemy2;
    Fight fight;

    @BeforeAll
    void setFight() {
        fight = new FightImpl();
    }

    @ParameterizedTest
    @MethodSource
    void fight(boolean expected, Warrior enemy1, Warrior enemy2) {
        assertEquals(expected, fight.fight(enemy1, enemy2));
    }

    static Stream<Arguments> fight() {
        return Stream.of(
                Arguments.of(false, new Warrior(), new Knight()),
                Arguments.of(true, new Knight(), new Warrior())

        );
    }

    //    prepare_test(middle_code='''bob = Warrior()mars = Warrior()
//    fight(bob, mars)''', test="bob.is_alive",answer=True)
    @Test
    void fightTest3() {
        enemy1 = new Warrior();
        enemy2 = new Warrior();
        fight.fight(enemy1, enemy2);
        assertTrue(enemy1.isAlive());
    }

    //    prepare_test(middle_code='''zeus = Knight()godkiller = Warrior()
//    fight(zeus, godkiller)''',test="zeus.is_alive",answer=True)
    @Test
    void fightTest4() {
        enemy1 = new Knight();
        enemy2 = new Warrior();
        fight.fight(enemy1, enemy2);
        assertTrue(enemy1.isAlive());
    }

    //    prepare_test(middle_code='''husband = Warrior()wife = Warrior()
//    fight(husband, wife)''',test="wife.is_alive",answer=False)
    @Test
    void fightTest5() {
        enemy1 = new Warrior();
        enemy2 = new Warrior();
        fight.fight(enemy1, enemy2);
        assertFalse(enemy2.isAlive());
    }
//    prepare_test(middle_code='''dragon = Warrior() knight = Knight()
//    fight(dragon, knight)''', test="knight.is_alive", answer=True)

    @Test
    void fightTest6() {
        enemy1 = new Warrior();
        enemy2 = new Knight();
        fight.fight(enemy1, enemy2);
        assertTrue(enemy2.isAlive());
    }

    //    prepare_test(middle_code='''unit_1 = Warrior() unit_2 = Knight() unit_3 = Warrior()
//            fight(unit_1, unit_2)''',
//    test="fight(unit_2, unit_3)",answer=False)
    @Test
    void fightTest7() {
        enemy1 = new Warrior();
        enemy2 = new Knight();
        fight.fight(new Warrior(), enemy2);
        assertFalse(fight.fight(enemy2, enemy1));
    }

    //unit_1 = Defender() unit_2 = Rookie()
//    fight(unit_1, unit_2)''',
//    test="unit_1.health", answer=60)
    @Test
    void fightTest8() {
        enemy1 = new Defender();
        enemy2 = new Rookie();
        fight.fight(enemy1, enemy2);
        assertEquals(60, enemy1.getHealth());
    }
//     unit_1 = Defender()unit_2 = Rookie() unit_3 = Warrior()
//    fight(unit_1, unit_2)''',
//    test="fight(unit_1, unit_3)",
//    answer=True

    @Test
    void fightTest9() {
        enemy1 = new Defender();
        enemy2 = new Rookie();

        fight.fight(enemy1, enemy2);
        assertTrue(fight.fight(enemy1, new Warrior()));
    }
}