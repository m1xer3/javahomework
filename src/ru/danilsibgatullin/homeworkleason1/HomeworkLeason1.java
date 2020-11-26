package ru.danilsibgatullin.homeworkleason1;

import java.util.Scanner;

public class HomeworkLeason1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        float fa,fb,fc,fd;
        int a,b;


        // Упражнение 2
        initVar();
        pr("---------------------------------------------------------");

        //Упражнение 3
        pr("Рассчет выражения a * (b + (c / d))");
        pr("Число a");
        fa = scanner.nextFloat();
        pr("Число b");
        fb = scanner.nextFloat();
        pr("Число c");
        fc = scanner.nextFloat();
        pr("Число d");
        fd = scanner.nextFloat();
        pr( "Выражение равно " + calcEquation(fa,fb,fc,fd));
        pr("---------------------------------------------------------");

        //Упражнение 4
        pr("Проверка чисел на вхождение их суммы в диапозон от 10 до 20(включительно) ");
        pr("Первое число");
        a= scanner.nextInt();
        pr("Второе число");
        b= scanner.nextInt();
        if (checkSum(a,b)) {
            pr("Сумма чисел " + a + " и " + b + " находится в указанном диапозоне");
        }
        else{
            pr("Сумма чисел " + a + " и " + b + " не находится в указанном диапозоне");
        }
        pr("---------------------------------------------------------");

        //Упражнение 5
        pr("Проверка Положительное или отрицательное число");
        pr("Введите число");
        a= scanner.nextInt();
        positivOrNegativ(a);
        pr("---------------------------------------------------------");

        //Упражнение 6
        pr("Проверка Положительное или отрицательное число через метод с return");
        a= scanner.nextInt();
        pr("Число отрицатльное?" + positivOrNegativReturn(a));
        pr("---------------------------------------------------------");

        //Упражнение 7
        pr("Введите Ваше имя, пожалуйста");
        String name = scanner.next();
        helloName(name);
        pr("---------------------------------------------------------");

        //Упражнение 8
        pr("Проверка на високосность года");
        pr("Введите год");
        a=scanner.nextInt();
        if (checkYear(a)){
            pr("Год високосный. В нем 366 дней.");
        }
        else {
            pr("Год не високосный. В нем 365 дней.");
        }
        pr("---------------------------------------------------------");

        scanner.close();

    }

    // Заменяем System.out.println на более короткое написание
    static void pr(String s){
        System.out.println(s);
    }

    // Упражнение 2
    static void initVar(){

         byte b;
         b=1;
         short s = 2;
         int i = 3;
         long l = 4;
         System.out.println("Примитивы целочисленные : " + b + " ; " + s + " ; " + i +" ; " + l);
         float f = 1.23f ;
         double d= 12.5123;
         System.out.println("Примитивы с плавающей запятой : " + f + " ; " + d);
         char c = 'c';
         System.out.println("Примитив символьный : " + c);
         boolean bool;
         bool =true;
         System.out.println("Примитив логический : " + bool);
    }

    //Упражнение 3
    static float calcEquation(float a,float b,float c,float d){
        return a * (b + (c / d));
    }

    //Упражнение 4
    static boolean checkSum (int i , int j){
        int sum =i+j;
        if (sum>10&&sum<=20){
            return true;
        }
        else{
            return false;
        }
    }

    //Упражнение 5
    static void positivOrNegativ (int i){
        if(i<0){
            System.out.println("Число отрицательное");
        }
        else {
            System.out.println("Число положительное");
        }
    }

    //Упражнение 6
    static boolean positivOrNegativReturn (int i){
        if(i<0){
            return true;
        }
        else {
            return false;
        }
    }

    //Упражнение 7
    static  void helloName (String name){
        System.out.println("Привет , " + name + "!");
    }

    //Упражнение 8
    static boolean checkYear (int year){
       boolean b =false;
        if (year%4==0&&year%100!=0){
            b=true;
        }
        if (year%400==0){
            b=true;
        }
        return b;

    }


}
