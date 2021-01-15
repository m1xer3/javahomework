package ru.danilsibgatullin.homeworkleason7.catsandplates;

public class Plate {
    private final static int DEFAULT_CAPACITY=100;
    private int capacity; //общий объем тарелки
    private int emptyCapacity; // показатель сколько еще объема можно использовать для наполнения тарелки
    private int filledCapacity; // показатель на сколько заполнена тарелка

    public int getEmptyCapacity() {
        return emptyCapacity;
    }

    public int getFilledCapacity() {
        return filledCapacity;
    }

    public int getCapacity() {
        return capacity;
    }


    public Plate(int capacity){
        if(capacity>=0) this.capacity=capacity;
        else {
            System.out.println("Торелка не может иметь отрицательный объем, присвоено значение "+DEFAULT_CAPACITY);
            this.capacity=DEFAULT_CAPACITY;
        }
        this.emptyCapacity = this.capacity; // создаем тарелку всегда пустой на полный объем тарелки
        this.filledCapacity=0; //
    }

    public Plate(){
        this(DEFAULT_CAPACITY);
    }

    // метод размещения еды в тарелке
    public void placeFoodOnPlate(Food food){
        if(this.isEmpty()) {
            if (this.emptyCapacity >= food.getVolume()) {
                this.emptyCapacity -= food.getVolume(); // уменьшаем объем пустого места в тарелке
                this.filledCapacity = this.capacity-this.emptyCapacity; // обновляем параметр доступной для поедания пищи
                food.decreaseAvailableFood(food.getVolume());
            } else {
                food.setVolume(food.getVolume() - this.emptyCapacity); // оставляем блюду не использованный объем , что бы пользователь мог решить что с ним делать, положить ли в новую тарелку
                System.out.printf("Dish %s did not fit on the plate, the volume of food did not fit on the plate %d", food.getDishName(), food.getVolume());
                this.emptyCapacity = 0;
                this.filledCapacity = this.capacity; // тарелка полная
                food.decreaseAvailableFood(this.getCapacity());
            }
        }
        else System.out.printf("The plate is not empty. Place the dish on a new plate.");
    }

    // Метод изменения объема еды в тарелке
    public void availableCapacityChange(int eatenVolume){
        this.filledCapacity -=eatenVolume;
        this.emptyCapacity +=eatenVolume;
    }

    //перегруженный метод для очистки тарелки
    public void availableCapacityChange(){
        this.filledCapacity = 0;
        this.emptyCapacity = this.capacity;
    }


    public void info(){
        System.out.println(this);
    }

    public boolean isEmpty(){
        return this.capacity==this.emptyCapacity;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "capacity=" + capacity +
                ", emptyCapacity=" + emptyCapacity +
                ", filledCapacity=" + filledCapacity +
                '}';
    }
}
