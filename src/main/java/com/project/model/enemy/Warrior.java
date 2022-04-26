package com.project.model.enemy;

public class Warrior extends Enemy{

    private static final int ATTACK = 5;
    private static final int START_HEALTH = 50;
    private Warrior soldierBehind;
    private int health;

    public Warrior() {
        this(START_HEALTH);
    }

    protected Warrior(int i) {
        this.health = i;
    }

    public int attack() {
        return getAttack();
    }

    public int getAttack() {
        return ATTACK;
    }

    public int takeDamage(int damage) {
        this.health -= damage;
        return damage;
    }

    public int doDamage(Warrior warrior) {
        if (this.soldierBehind instanceof Healer) {
            ((Healer) getSoldierBehind()).heal(this);
        }
        return warrior.takeDamage(this.attack());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    protected void setHelth(int health) {
        this.health = health;
    }

    protected Warrior getSoldierBehind() {
        return soldierBehind;
    }

    public int getStartHealth() {
        return START_HEALTH;
    }

    public void setSoldierBehind(Warrior soldierBehind) {
        this.soldierBehind = soldierBehind;
    }

    public static Warrior getUnit(Type type) {
        return switch (type){
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
            case HEALER -> new Healer();
        };
    }
}