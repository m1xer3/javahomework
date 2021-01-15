package ru.danilsibgatullin.homeworkleason7.animalsandplates;

public class Dogs extends Animals {

    private final static String ANIMAL_TYPE = "Predator"; // хищник
    private final static String ANIMAL_KIND= "Dog"; // вид животного
    private final static String DEFAULT_NAME = "Default Dog";
    private final static int DEFAULT_APPETITE = 150;

    public Dogs(String name, int appetite){
        super(ANIMAL_TYPE,ANIMAL_KIND,name,appetite);
    }

    public Dogs(){
        this(DEFAULT_NAME,DEFAULT_APPETITE);
    }
}
