package ru.danilsibgatullin.homeworkleason5;

import java.util.ArrayList;
import java.util.Random;

public class TestEmployee {


    public static void main(String[] args) {

        Random rand = new Random();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int randomSalary = Employee.MAX_SALARY-Employee.MROT; // определяем верхнюю границу рандомной зарплаты
        int randomAge = Employee.RETIREMENT_AGE-Employee.PERMISIBLE_AGE; // определяем верхнюю границу рандомного возраста
        employees.add(new Employee("Петров Петр Петрович","Менеджер","first@noemail.net","+7 777 333 43 43",Employee.MROT+rand.nextInt(randomSalary),Employee.PERMISIBLE_AGE+rand.nextInt(randomAge)));
        employees.add(new Employee("Федоров Федор Федорович","Старший менеджер","second@noemail.net","+3 333 333 33 33",Employee.MROT+rand.nextInt(randomSalary),Employee.PERMISIBLE_AGE+rand.nextInt(randomAge)));
        employees.add(new Employee("Сергеев Сергей Сергеевич"," Главный менеджер","therd@noemail.net","+4 444 444 43 43",Employee.MROT+rand.nextInt(randomSalary),Employee.PERMISIBLE_AGE+rand.nextInt(randomAge)));
        employees.add(new Employee("Олегов Олег Олегович","Начальник отдела","forth@noemail.net","+5 555 555 43 43",Employee.MROT+rand.nextInt(randomSalary),Employee.PERMISIBLE_AGE+rand.nextInt(randomAge)));
        employees.add(new Employee("Михайлов Михаил Михайлович","Директор","fifth@noemail.net","+6 666 666 43 43",Employee.MROT+rand.nextInt(randomSalary),Employee.PERMISIBLE_AGE+rand.nextInt(randomAge)));
        employees.add(new Employee());
        for (Employee employee : employees) {
            if(employee.getAge()>40){
                employee.employeeInfo();
            }
        }

    }
}
