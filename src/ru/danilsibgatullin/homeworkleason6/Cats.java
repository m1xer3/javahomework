package ru.danilsibgatullin.homeworkleason6;

public class Cats extends Animals{

    protected static int catsCount=0; //счетчик для созданных объектов
    private static int defaultCatCount = 1; //счетчик для присвоения уникальных имен при вызове конструктора по умолчанию
    /*не стал делать переопределение метода так как метод в Animal все равно вернет false
    * если при создании использовать 0 не зависимо от того что будет вызвано в конструкторе
    * */
    private final static int IS_CATS_SWIM = 0;

    public Cats(String name, int maxRunDistance, int maxJumpDistance,int maxSwimingDistance){
        super(name, maxRunDistance,maxJumpDistance, IS_CATS_SWIM);
        catsCount++;
    }

    public Cats(String name, int maxRunDistance, int maxJumpDistance){
        super(name, maxRunDistance,maxJumpDistance, IS_CATS_SWIM);
        catsCount++;
    }

    public Cats(){
        super("DefaultCat"+defaultCatCount,0,0,0);
        defaultCatCount++;
        catsCount++;
    }

}
