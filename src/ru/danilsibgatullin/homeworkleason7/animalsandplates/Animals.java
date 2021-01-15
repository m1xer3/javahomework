package ru.danilsibgatullin.homeworkleason7.animalsandplates;

public abstract class Animals {

    private String animalType; // ищник или травоядный
    private String animalKind; // вид животного
    private int appetite; //прожорливость
    private String name; //имя животного

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalKind() {
        return animalKind;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }


    public Animals (String animalType,String animalKind,String name,int appetite){
        this.animalType=animalType;
        this.animalKind=animalKind;
        this.name=name;
        this.appetite=appetite;
    }

    public boolean isHungry(){
        return this.appetite != 0;
    }

    public void printAnimalIsHungry() {
        if (this.isHungry()) {
            System.out.printf("%s %s is hungry , hungry value is %d \n",this.getAnimalKind(),this.getName(),this.getAppetite());
        } else {
            System.out.printf("%s %s is not hungry \n",this.getAnimalKind(),this.getName());
        }
    }

    public  void animalEat (Plate plate){
        if(this.isHungry()){
            if(this.getAppetite()<=plate.getFilledCapacity()){
                plate.availableCapacityChange(this.getAppetite());
                this.setAppetite(0);
            }
            else{
                this.setAppetite(this.getAppetite()-plate.getFilledCapacity());
                plate.availableCapacityChange(); //опусташаем тарелку
            }
        }
    }


    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "animalType='" + animalType + '\'' +
                ", animalKind='" + animalKind + '\'' +
                ", appetite=" + appetite +
//                ", satiety=" + satiety +
               ", name='" + name + '\'' +
                '}';
    }
}
