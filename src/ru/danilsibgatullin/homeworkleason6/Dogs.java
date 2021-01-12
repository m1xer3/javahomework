package ru.danilsibgatullin.homeworkleason6;

public class Dogs extends Animals {

    protected static int dogsCount=0; //счетчик для созданных объектов
    private static int defaultDogCount = 1; //счетчик для присвоения уникальных имен при вызове конструктора по умолчанию

    public Dogs(String name, int maxRunDistance, int maxJumpDistance, int maxSwimingDistance){
        super(name, maxRunDistance,maxJumpDistance, maxSwimingDistance);
        dogsCount++;
    }

    public Dogs(){
        super("DefaultDog"+defaultDogCount,0,0,0);
        defaultDogCount++;
        dogsCount++;
    }
}
