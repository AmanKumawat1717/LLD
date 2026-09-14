package com.interview.practice.lld.creationalDesignPattern.prototypeDesignPattern;

public class Weapon implements Prototype<Weapon>{

    private String name;
    private String damage;

    public Weapon(String name, String damage){
        this.name = name;
        this.damage = damage;

    }

    public String getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Weapon clone() throws CloneNotSupportedException {
        return new Weapon(name,damage);
    }
}
