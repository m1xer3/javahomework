package ru.danilsibgatullin.homeworkleason6;

public class TestAnimal {

    public static void main(String[] args) {
        Animal cat1 = new Cat("Barsik",200,3);
        Animal cat2 = new Cat("Graf",250,2);
        Animal dog1 = new Dog("Bobik",300,5,150);
        Animal dog2 = new Dog("Tuzik",400,4,100);

        // проверка на создание дефолтных животных
        Animal cat3 = new Cat();
        Animal dog3 = new Dog();
        Animal dog4 = new Dog();
        Animal dog5 = new Dog();

        // проверка бега
        toRun(cat1,250);
        toRun(cat2,250);

        // проверка прыжков
        toJump(cat2,2);
        toJump(dog2,5);

        //проверка плавания
        toSwim(dog1,10);
        toSwim(cat2,10);


        //Проверка счетчика количества объектов
        System.out.println("Количество кошек : " + Cat.catsCount);
        System.out.println("Количество собак : " + Dog.dogsCount);
        System.out.println("Количество животных : " + Animal.animalsCount);

    }

    static void toRun(Animal animal, int distance){
        if (animal.isRun(distance)) {
            System.out.println(animal.getName() + " способен пробежать " + distance + " метров");
        }
        else System.out.println(animal.getName() + " не способен пробежать " + distance + " метров");
    }

    static void toJump(Animal animal, int distance){
        if (animal.isJump(distance)) {
            System.out.println(animal.getName() + " способен перепрыгнуть препятствие высотой " + distance + " метров");
        }
        else System.out.println(animal.getName() + " не способен перепрыгнуть препятствие высотой " + distance + " метров");
    }

    static void toSwim(Animal animal, int distance){
        if (animal.isSwiming(distance)) {
            System.out.println(animal.getName() + " способен проплыть " + distance + " метров");
        }
        else System.out.println(animal.getName() + " не способен проплыть " + distance + " метров");
    }
}
