package ru.danilsibgatullin.homeworkleason3;

import java.util.Random;
import java.util.Scanner;

public class FindFruit {

        /*
    2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
     */

    public static void main(String[] args){
        String[] words = {"яблоко", "апельсин", "лемон", "банан", "абрикос", "авокадо",
                "броколли", "морковь", "вишня", "чеснок", "виноград", "дыня",
                "киви", "манго", "грибы", "орех", "оливка", "горох", "груша",
                "перец", "ананас", "тыква", "картофель"};

        System.out.println("Игра <<Отгадай фрукт и овощи>>.");
        System.out.println("Будет загадан один из овощей или фруктов. Ваша задача отгадать это слово. В случае неверного ответа будет выведена подсказка.");
        System.out.println("Загаданное слово указано на кирилице");
        boolean isCorrectAnswer =false;
        String hidenWord = randomWord(words); //загадываем слово
        String answer;
        do {
            answer = enteredAnswer();
            if(answer.equals(hidenWord)){
                System.out.println("Вы угадали! Это действительно " + hidenWord);
                isCorrectAnswer = true;
            }else{
                System.out.println("Ответ не верный. Буквы из ответа которые находятся на корректных местах");
                System.out.println(promptForRiddle(hidenWord,answer));
                System.out.println("Попробуйте еще раз!");
            }
        }while(isCorrectAnswer==false);


    }

    //метод для ввода ответа
    static String enteredAnswer(){
        System.out.println("Введите ваш вариант ответа:");
        Scanner scan = new Scanner(System.in);
        String resultString = scan.nextLine();
        resultString = resultString.toLowerCase(); //дополнительно переводим в нижний регистр ответ для корректного сравнения
        return resultString;
    }

    //метод для выбора случайного слова
    static String randomWord (String[] arrayString){
        Random random = new Random();
        int randIndex = random.nextInt(arrayString.length);
        return arrayString[randIndex];
    }

    //метод который возвращает подсказку к неверному ответу
    static String promptForRiddle (String hidenWord , String answer){
        String resultString="";
        Random random = new Random();
        int range; // длинна самого короткого слова
        if (hidenWord.length()>=answer.length()){
            range=answer.length();
        }
        else {
            range=hidenWord.length();
        }
        //
        for(int i=0;i<range;i++){
            if(hidenWord.charAt(i)==answer.charAt(i)){
                resultString+=answer.charAt(i);
            }else {
                resultString+="#";
            }
        }
        //добиваем резульатат случайным количеством символов # что бы не возможно было отгадать по количеству символов
        for (int i=0;i<(1+random.nextInt(16));i++){
            resultString+="#";
        }
        return resultString;
    }
}

