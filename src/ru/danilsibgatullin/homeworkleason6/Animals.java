package ru.danilsibgatullin.homeworkleason6;

import java.util.Objects;

public abstract class Animals {

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

    protected String name;
    protected int maxRunDistance;
    protected int maxJumpDistance;
    protected int maxSwimingDistance;

    public String getName() {
        return name;
    }

    public Animals(String name, int maxRunDistance, int maxJumpDistance, int maxSwimingDistance){
        this.name=name;
        this.maxRunDistance=maxRunDistance;
        this.maxJumpDistance=maxJumpDistance;
        this.maxSwimingDistance=maxSwimingDistance;
        animalsCount++;
    }

    public  boolean run(int distance){
        if(distance>0&&distance<=this.maxRunDistance){
            return true;
        }
        return false;
    }

    public  boolean jump(int distance){
        if(distance>0&&distance<=this.maxJumpDistance){
            return true;
        }
        return false;
    }

    public  boolean swiming(int distance){
        if(distance>0&&distance<=this.maxSwimingDistance){
            return true;
        }
        return false;
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
        Animals animals = (Animals) o;
        return maxRunDistance == animals.maxRunDistance && maxJumpDistance == animals.maxJumpDistance && maxSwimingDistance == animals.maxSwimingDistance && Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxRunDistance, maxJumpDistance, maxSwimingDistance);
    }
}
