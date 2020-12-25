package ru.danilsibgatullin.homeworkleason5;

public class Employee {

    static final int MROT = 12130; // МРОТ в РФ 12130 руб
    static final int PERMISIBLE_AGE = 16; //работать официально в РФ можно с 16 лет
    static final int RETIREMENT_AGE = 65; //возраст выхода на пенсию
    static final int MAX_SALARY = 100000; // Максимально допустимая зарплата в организации static так как в данном примере мы рассматриваем только одну организацию


    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary >= MROT) this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= PERMISIBLE_AGE) this.age = age;
    }

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employee(){
        this("Иванов Иван Иванович","Дворник","noemail@noemail.net","+1 999 888 77 66",20000,45);
    }

    public void employeeInfo(){
        System.out.printf("ФИО: %s ; Должность: %s ; Email: %s ; Номер телефона: %s ; Зарплата: %d ; Возраст: %d %n",this.fullName,this.position,this.email,this.phoneNumber,this.salary,this.age);
    }



}
