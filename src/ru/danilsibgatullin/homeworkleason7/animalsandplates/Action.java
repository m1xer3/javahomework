package ru.danilsibgatullin.homeworkleason7.animalsandplates;

public class Action {
    public static void main(String[] args) {

        Animals[] animals = {
                new Cats("Barsik", 100),
                new Cats("Markiz",150),
                new Cats(),
                new Cats("Tom",120),
                new Dogs("Bobik",200),
                new Dogs("Tuzik",250),
                new Dogs()
        };

        //Продуктовый набор
        Food meat = new Food("meat",500);
        Food fish = new Food("fish",200);
        Food sausage = new Food("sausage",400);

        // Набор посуды
        Plate woodPlate = new Plate(200);
        Plate ironPlate = new Plate(350);

        System.out.println("Iteration 1");
        woodPlate.placeFoodOnPlate(meat); // Кладем мясо в тарелку
        meat.info(); // проверяем сколько мяса осталось
        for (Animals animal : animals) {
            animal.animalEat(woodPlate); // говорим животным есть из деревянной тарелки
            animal.printAnimalIsHungry(); // распечатываем наелось ли животное
        }
        woodPlate.info();
        System.out.println();

        System.out.println("Iteration 2");
        ironPlate.placeFoodOnPlate(meat); //Кладем остатки мяса в тарелку побольше
        ironPlate.placeFoodOnPlate(sausage); //Добиваем в тарелку сосисками
        for (Animals animal : animals) {
            animal.animalEat(ironPlate); // говорим животному есть из железной тарелки
            animal.printAnimalIsHungry(); // распечатываем наелось ли животное
        }
        System.out.println();

        ironPlate.placeFoodOnPlate(sausage); //Кладем остатки сосисок
        ironPlate.placeFoodOnPlate(fish); //Добавляем в тарелку рыбу
        System.out.println("Iteration 3");
        for (Animals animal : animals) {
            animal.animalEat(ironPlate); // говорим животным есть из железной тарелки
            animal.printAnimalIsHungry(); // распечатываем наелось ли животное
        }
    }
}
