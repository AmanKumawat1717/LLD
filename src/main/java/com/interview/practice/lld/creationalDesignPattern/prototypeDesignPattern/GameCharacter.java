package com.interview.practice.lld.creationalDesignPattern.prototypeDesignPattern;

public class GameCharacter implements Prototype{

    private String name;
    private int health;
    private Weapon weapon;

    public GameCharacter(String name, int health, Weapon weapon){
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public GameCharacter clone() throws CloneNotSupportedException {
        return new GameCharacter(name,health,weapon.clone());
    }
}
