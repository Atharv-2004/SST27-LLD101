package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character wrappee) {
        super(wrappee);
    }

    @Override
    public void move() {
        System.out.println("[Golden Aura] shimmering...");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[Golden Aura] empowered strike!");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() { return wrappee.getSpeed() + 1; }

    @Override
    public int getDamage() { return wrappee.getDamage() + 2; }

    @Override
    public String getSprite() { return "golden.png"; }
}


