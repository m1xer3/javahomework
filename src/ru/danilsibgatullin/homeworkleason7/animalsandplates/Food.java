package ru.danilsibgatullin.homeworkleason7.animalsandplates;

public class Food {

    private final static String DEFAULT_DISHNAME = "Testy Food";
    private final static int DEFAULT_VOLUME = 10;
    private String dishName;
    private int volume;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Food(String dishName,int volume){
        this.dishName=dishName;
        if(volume>=0)this.volume=volume;
        else {
            System.out.println("The volume of food cannot be negative, the value set " + DEFAULT_VOLUME);
            this.volume=DEFAULT_VOLUME;
        }
    }

    public  Food(){
        this(DEFAULT_DISHNAME,DEFAULT_VOLUME);
    }

    public void decreaseAvailableFood(int decreaseValue){
        this.setVolume(this.getVolume()-decreaseValue);
    }

    public boolean isEnded(){
        return this.getVolume() == 0;
    }

    public void info(){
        if(isEnded()){
            System.out.printf("Dish %s is ended.\n",this.getDishName());
        }
        else System.out.printf("Available value of %s is %d \n",this.getDishName(),this.getVolume());
    }

    @Override
    public String toString() {
        return "Food{" +
                "dishName='" + dishName + '\'' +
                ", volume=" + volume +
                '}';
    }

}
