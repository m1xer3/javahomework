package ru.danilsibgatullin.homeworkleason7.animalsandplates;

public class Cats extends Animals {

    private final static String ANIMAL_TYPE = "Predator"; // хищник
    private final static String ANIMAL_KIND= "Cat"; // вид животного
    private final static String DEFAULT_NAME = "Default Cat";
    private final static int DEFAULT_APPETITE = 50;

    public Cats(String name, int appetite){
        super(ANIMAL_TYPE,ANIMAL_KIND,name,appetite);
    }

    public Cats(){
        this(DEFAULT_NAME,DEFAULT_APPETITE);
    }

}
