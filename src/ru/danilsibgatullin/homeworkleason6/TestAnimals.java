package ru.danilsibgatullin.homeworkleason6;

public class TestAnimals {

    public static void main(String[] args) {
        Animals cat1 = new Cats("Barsik",200,3,150);
        Animals cat2 = new Cats("Graf",250,2,200);
        Animals dog1 = new Dogs("Bobik",300,5,150);
        Animals dog2 = new Dogs("Tuzik",400,4,100);

        // проверка на создание дефолтных животных
        Animals cat3 = new Cats();
        Animals dog3 = new Dogs();
        Animals dog4 = new Dogs();
        Animals dog5 = new Dogs();

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
        System.out.println("Количество кошек : " + Cats.catsCount);
        System.out.println("Количество собак : " + Dogs.dogsCount);
        System.out.println("Количество животных : " + Animals.animalsCount);

    }

    static void toRun(Animals animal,int distance){
        if (animal.run(distance)) {
            System.out.println(animal.getName() + " способен пробежать " + distance + " метров");
        }
        else System.out.println(animal.getName() + " не способен пробежать " + distance + " метров");
    }

    static void toJump(Animals animal,int distance){
        if (animal.jump(distance)) {
            System.out.println(animal.getName() + " способен перепрыгнуть препятствие высотой " + distance + " метров");
        }
        else System.out.println(animal.getName() + " не способен перепрыгнуть препятствие высотой " + distance + " метров");
    }

    static void toSwim(Animals animal,int distance){
        if (animal.swiming(distance)) {
            System.out.println(animal.getName() + " способен проплыть " + distance + " метров");
        }
        else System.out.println(animal.getName() + " не способен проплыть " + distance + " метров");
    }
}
