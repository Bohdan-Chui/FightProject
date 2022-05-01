package com.project.model.enemy;

import com.project.model.Fight;
import com.project.model.Fightable;
import com.project.model.army.impl.Army;
import com.project.model.weapon.Weapon;
import com.project.model.weapon.impl.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeaponTest {


    @Test
    @DisplayName("1")
    void fight1() {
        Fightable war1 = new EnemyFactory().of("Warrior");
        Fightable war2 = new EnemyFactory().of("Vampire");
        war1.equipWeapon(new Weapon(-10, 5, 0, 40, 0));
        war2.equipWeapon(new Sword());

        assertTrue(Fight.duel(war1, war2));

    }
    @Test
    @DisplayName("2")
    void fight2() {
        Fightable war1 = new EnemyFactory().of("Defender");
        Fightable war2 = new EnemyFactory().of("Lancer");
        war1.equipWeapon(new Shield());
        war2.equipWeapon(new GreatAxe());

        assertFalse(Fight.duel(war1, war2));

    }
    @Test
    @DisplayName("3")
    void fight3() {
        Fightable war1 = new EnemyFactory().of("Healer");
        Fightable war2 = new EnemyFactory().of("Knight");
        war1.equipWeapon(new MagicWand());
        war2.equipWeapon(new Katana());

        assertFalse(Fight.duel(war1, war2));

    }
    @Test
    @DisplayName("4")
    void fight4() {
        Fightable war1 = new EnemyFactory().of("Defender");
        Fightable war2 = new EnemyFactory().of("Vampire");
        war1.equipWeapon(new Shield());
        war1.equipWeapon(new MagicWand());
        war2.equipWeapon(new Shield());
        war2.equipWeapon(new Katana());

        assertFalse(Fight.duel(war1, war2));

    }
    @Test
    @DisplayName("5")
    void fight5() {
        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new GreatAxe();
        Army army1 = new Army();
        army1.addUnits("Knight", 1);
        army1.addUnits("Lancer", 1);
        Army army2 = new Army();
        army2.addUnits("Vampire", 1);
        army2.addUnits("Healer", 1);
        army1.getByIndex(0).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon2);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon2);

        assertTrue(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("6")
    void fight6() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();
        Army army1 = new Army();
        army1.addUnits("Defender", 1);
        army1.addUnits("Warrior", 1);
        Army army2 = new Army();
        army2.addUnits("Knight", 1);
        army2.addUnits("Healer", 1);
        army1.getByIndex(0).equipWeapon(weapon2);
        army1.getByIndex(1).equipWeapon(weapon2);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon1);

        assertTrue(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("7")
    void fight7() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();
        Army army1 = new Army();
        army1.addUnits("Defender", 2);
        Army army2 = new Army();
        army2.addUnits("Knight", 1);
        army2.addUnits("Vampire", 1);
        army1.getByIndex(0).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon1);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon1);

        assertFalse(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("8")
    void fight8() {
        Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);
        Army army1 = new Army();
        army1.addUnits("Knight", 3);
        Army army2 = new Army();
        army2.addUnits("Warrior", 1);
        army2.addUnits("Defender", 2);
        army1.getByIndex(0).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon1);
        army1.getByIndex(2).equipWeapon(weapon2);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon2);
        army2.getByIndex(2).equipWeapon(weapon2);

        assertTrue(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("9")
    void fight9() {
        Weapon weapon1 = new Weapon(-20, 1, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, 2, 2, -55, 3);
        Army army1 = new Army();
        army1.addUnits("Vampire", 3);
        Army army2 = new Army();
        army2.addUnits("Warrior", 1);
        army2.addUnits("Defender", 2);
        army1.getByIndex(0).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon1);
        army1.getByIndex(2).equipWeapon(weapon2);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon2);
        army2.getByIndex(2).equipWeapon(weapon2);

        assertFalse(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("10")
    void fight10() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();
        Army army1 = new Army();
        army1.addUnits("Vampire", 2);
        army1.addUnits("Rookie", 2);
        Army army2 = new Army();
        army2.addUnits("Warrior", 1);
        army2.addUnits("Defender", 2);
        army1.getByIndex(0).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon1);
        army1.getByIndex(2).equipWeapon(weapon2);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon2);
        army2.getByIndex(2).equipWeapon(weapon2);

        assertTrue(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("11")
    void fight11() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();
        Army army1 = new Army();
        army1.addUnits("Vampire", 3);
        Army army2 = new Army();
        army2.addUnits("Warrior", 1);
        army2.addUnits("Defender", 1);
        army1.getByIndex(0).equipWeapon(weapon2);
        army1.getByIndex(1).equipWeapon(weapon2);
        army1.getByIndex(2).equipWeapon(weapon2);
        army2.getByIndex(0).equipWeapon(weapon1);
        army2.getByIndex(1).equipWeapon(weapon1);

        assertTrue(Fight.battle(army1, army2));

    }
    @Test
    @DisplayName("12")
    void fight12() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new MagicWand();
        Army army1 = new Army();
        army1.addUnits("Rookie", 3);
        Army army2 = new Army();
        army2.addUnits("Defender", 1);
        army2.addUnits("Healer", 1);
        army1.getByIndex(0).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon1);
        army1.getByIndex(1).equipWeapon(weapon1);
        army2.getByIndex(0).equipWeapon(weapon2);
        army2.getByIndex(1).equipWeapon(weapon2);

        assertFalse(Fight.battle(army1, army2));

    }
}