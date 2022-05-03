package com.project.model.enemy;

import com.project.model.Fight;
import com.project.model.army.impl.Army;
import com.project.model.weapon.impl.Shield;
import com.project.model.weapon.impl.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarlordTest {

    @Test
    void test1() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits("WARLORD", 1);
        army1.addUnits("WARRIOR", 2);
        army1.addUnits("LANCER", 2);
        army1.addUnits("HEALER", 2);
        army2.addUnits("WARLORD", 1);
        army2.addUnits("VAMPIRE", 1);
        army2.addUnits("HEALER", 2);
        army2.addUnits("Knight", 2);
        assertTrue(Fight.battle(army1, army2));
    }

    @Test
    void test2() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits("WARRIOR", 2);
        army1.addUnits("LANCER", 2);
        army1.addUnits("DEFENDER", 1);
        army1.addUnits("WARLORD", 3);
        army2.addUnits("WARLORD", 2);
        army2.addUnits("VAMPIRE", 1);
        army2.addUnits("HEALER", 5);
        army2.addUnits("KNIGHT", 2);

        assertTrue(Fight.battle(army1, army2));
    }

    @Test
    void test3() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits("WARRIOR", 2);
        army1.addUnits("LANCER", 3);
        army1.addUnits("DEFENDER", 1);
        army1.addUnits("WARLORD", 4);
        army2.addUnits("WARLORD", 1);
        army2.addUnits("VAMPIRE", 1);
        army2.addUnits("ROOKIE", 1);
        army2.addUnits("KNIGHT", 1);
        army1.getByIndex(0).equipWeapon(new Sword());
        army2.getByIndex(0).equipWeapon(new Shield());

        assertTrue(Fight.battle(army1, army2));
    }

    @Test
    void test4() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits("WARRIOR", 2);
        army1.addUnits("LANCER", 3);
        army1.addUnits("DEFENDER", 1);
        army1.addUnits("WARLORD", 1);
        army2.addUnits("WARLORD", 5);
        army2.addUnits("VAMPIRE", 1);
        army2.addUnits("ROOKIE", 1);
        army2.addUnits("KNIGHT", 1);
        army1.getByIndex(0).equipWeapon(new Sword());
        army2.getByIndex(0).equipWeapon(new Shield());

        assertFalse(Fight.straightFight(army1, army2));
    }

}

