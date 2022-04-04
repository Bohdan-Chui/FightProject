package com.project.model.impl;

import com.project.model.Fight;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FightImplTest {
    Warrior enemy1;
    Warrior enemy2;
    Fight fight;

    @BeforeAll
    void setFight() {
        fight = new FightImpl();
    }

    //    prepare_test(middle_code='''carl = Warrior() jim = Knight()''',
//    test="fight(carl, jim)",answer=False)
    @Test
    void fightTest1() {
        enemy1 = new Warrior();
        enemy2 = new Knight();
        Fight fight = new FightImpl();
        assertFalse(fight.fight(enemy1, enemy2));
    }

    //    prepare_test(middle_code='''ramon = Knight() slevin = Warrior()''',
//    test="fight(ramon, slevin)", answer=True)
    @Test
    void fightTest2() {
        enemy1 = new Knight();
        enemy2 = new Warrior();
        assertTrue(fight.fight(enemy1, enemy2));
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


}