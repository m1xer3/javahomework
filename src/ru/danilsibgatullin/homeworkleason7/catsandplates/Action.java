package ru.danilsibgatullin.homeworkleason7.catsandplates;

public class Action {
    public static void main(String[] args) {

        Food meat = new Food("Meat",100);
        Plate woodPlate =new Plate(200);
        Animals cat1 = new Cats("Graf",150);

        //Информация до активности
        meat.info();
        woodPlate.info();
        cat1.info();
        System.out.println();


        //Положили еду в тарелку
        woodPlate.placeFoodOnPlate(meat);
        woodPlate.info();
        woodPlate.placeFoodOnPlate(meat);
        woodPlate.info();


        System.out.println(cat1.isHungry()); // проверка голоден ли кот

        //Кот поел
        cat1.animalEat(woodPlate);
        woodPlate.info();
        cat1.info();
        meat.info();

        woodPlate.placeFoodOnPlate(meat);
        woodPlate.info();

    }
}
