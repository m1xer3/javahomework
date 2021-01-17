package ru.danilsibgatullin.homeworkleason6;

import java.util.Objects;

public abstract class Animal {

    protected String name;
    protected int maxRunDistance;
    protected int maxJumpDistance;
    protected int maxSwimingDistance;

    protected static int animalsCount=0; //счетчик для созданных объектов

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxJumpDistance() {
        return maxJumpDistance;
    }

    public void setMaxJumpDistance(int maxJumpDistance) {
        this.maxJumpDistance = maxJumpDistance;
    }

    public int getMaxSwimingDistance() {
        return maxSwimingDistance;
    }

    public void setMaxSwimingDistance(int maxSwimingDistance) {
        this.maxSwimingDistance = maxSwimingDistance;
    }

    public String getName() {
        return name;
    }

    public Animal(String name, int maxRunDistance, int maxJumpDistance, int maxSwimingDistance){
        this.name=name;
        this.maxRunDistance=maxRunDistance;
        this.maxJumpDistance=maxJumpDistance;
        this.maxSwimingDistance=maxSwimingDistance;
        animalsCount++;
    }

    public  boolean isRun(int distance){
        return distance>0&&distance<=this.maxRunDistance;
    }

    public  boolean isJump(int distance){
        return distance>0&&distance<=this.maxJumpDistance;
    }

    public  boolean isSwiming(int distance){
       return distance>0&&distance<=this.maxSwimingDistance;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", maxRunDistance=" + maxRunDistance +
                ", maxJumpDistance=" + maxJumpDistance +
                ", maxSwimingDistance=" + maxSwimingDistance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return maxRunDistance == animal.maxRunDistance && maxJumpDistance == animal.maxJumpDistance && maxSwimingDistance == animal.maxSwimingDistance && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxRunDistance, maxJumpDistance, maxSwimingDistance);
    }
}
