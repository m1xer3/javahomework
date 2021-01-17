package ru.danilsibgatullin.homeworkleason7.animalsandplates;

public class Action {
    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Barsik", 100),
                new Cat("Markiz",150),
                new Cat(),
                new Cat("Tom",120),
                new Dog("Bobik",200),
                new Dog("Tuzik",250),
                new Dog()
        };

        //Продуктовый набор
        Food meat = new Food("meat",500);
        Food fish = new Food("fish",200);
        Food sausage = new Food("sausage",400);

        // Набор посуды
        Plate woodPlate = new Plate(-200);
        Plate ironPlate = new Plate(350);

        System.out.println("Iteration 1");
        woodPlate.placeFoodOnPlate(meat); // Кладем мясо в тарелку
        meat.info(); // проверяем сколько мяса осталось
        for (Animal animal : animals) {
            animal.animalEat(woodPlate); // говорим животным есть из деревянной тарелки
            animal.printAnimalIsHungry(); // распечатываем наелось ли животное
        }
        woodPlate.info();
        System.out.println();

        System.out.println("Iteration 2");
        ironPlate.placeFoodOnPlate(meat); //Кладем остатки мяса в тарелку побольше
        ironPlate.placeFoodOnPlate(sausage); //Добиваем в тарелку сосисками
        for (Animal animal : animals) {
            animal.animalEat(ironPlate); // говорим животному есть из железной тарелки
            animal.printAnimalIsHungry(); // распечатываем наелось ли животное
        }
        System.out.println();

        ironPlate.placeFoodOnPlate(sausage); //Кладем остатки сосисок
        ironPlate.placeFoodOnPlate(fish); //Добавляем в тарелку рыбу
        System.out.println("Iteration 3");
        for (Animal animal : animals) {
            animal.animalEat(ironPlate); // говорим животным есть из железной тарелки
            animal.printAnimalIsHungry(); // распечатываем наелось ли животное
        }
    }
}
