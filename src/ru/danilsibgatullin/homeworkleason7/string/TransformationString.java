package ru.danilsibgatullin.homeworkleason7.string;

public class TransformationString {

    private static String find = "Java";

    public static void main(String[] args) {
        someString("I like learn Java !!!");
    }

    private static void someString (String str){
        System.out.println("Входная строка : " + str);
        System.out.println("Последний символ : " + str.charAt(str.length()-1));
        System.out.println("Строка заканчивается на !!! : " + str.endsWith("!!!"));
        System.out.println("Строка начинается на I like : " + str.startsWith("I like"));
        System.out.println("Строка содержит Java : " + str.contains(find));
        System.out.println("Позиция подстроки Java : " + str.indexOf(find));
        System.out.println("Замена буквы а на о : " + str.replace('a','o'));
        System.out.println("Преобразование строки в верхний регистр : " + str.toUpperCase());
        System.out.println("Преобразование строки в нижний регистр : " + str.toLowerCase());
        System.out.println("Вырезание строки Java : " + str.substring(0,str.indexOf(find))+str.substring(str.indexOf(find) + find.length(),str.length()));
    }

}
