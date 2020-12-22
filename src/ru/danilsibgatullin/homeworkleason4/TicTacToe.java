package ru.danilsibgatullin.homeworkleason4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 5; //константа
    private static final char[][] map = new char[SIZE][SIZE];

    private static final char DOT_EMPTY ='•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int SEQUENCE_LENGHT =4;

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args){
        initializeGame();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if(isGameEnd(DOT_X)){
                break;
            }

            computerTurn();
            printMap();
            if(isGameEnd(DOT_O)){
                break;
            }
        }


    }

    private static boolean isGameEnd(char symbol){
        if(isSomebodyWin(symbol)){
            System.out.println(symbol==DOT_X ? "Человек победил!" : "Машина победила!");
            return true;
        }
        if (isMapFull()){
            System.out.println("Ничья");
            return true;
        }
        return false;
    }


    // метод проверки выйгрыша
    private static boolean isSomebodyWin(char symbol){
        if (isWinByRows(symbol)) return true;
        if (isWinByColumns(symbol)) return true;
        if (isWinByDiagonal(symbol)) return true;
        return false;
    }

    private static boolean isWinByDiagonal(char symbol) {
        if (isMainDiagonal(symbol)) return true;
        if (isCollateralDiagonal(symbol)) return true;

        if (isSubMainDiagonal(symbol)) return true;


        return false;
    }

    private static boolean isSubMainDiagonal(char symbol) {
        int count = 0;
        for(int index = 0 ; index<SIZE;index++ ){

            if(map[index][index+1] == symbol){
                count++;
                if(count>=SEQUENCE_LENGHT){
                    return true;
                }
            }
        }


        return false;
    }

    private static boolean isCollateralDiagonal(char symbol) {
        int count =0;
        for(int index = 0; index<SIZE;index++){
            if(map[index][(SIZE-1)-index]== symbol){
                count++;
                if(count>=SEQUENCE_LENGHT){
                    return true;
                }
            }
            else {
                count=0;
            }
        }
        return false;
    }

    private static boolean isMainDiagonal(char symbol) {
        int count =0;
        for(int index = 0; index<SIZE;index++){
            if(map[index][index] == symbol){
                count++;
                if(count>=SEQUENCE_LENGHT){
                    return true;
                }
            }
            else {
                count=0;
            }
        }
        return false;
    }

    private static boolean isWinByColumns(char symbol) {
        for(int colIndex = 0; colIndex<SIZE;colIndex++){
            int count =0;
            for(int rowIndex = 0; rowIndex<SIZE;rowIndex++){
                if(map[rowIndex][colIndex] == symbol){
                    count++;
                    if(count>=SEQUENCE_LENGHT){
                        return true;
                    }
                }
                else {
                    count=0;
                }
            }
        }
        return false;
    }

    private static boolean isWinByRows(char symbol) {
        for(int rowIndex = 0; rowIndex<SIZE;rowIndex++){
            int count =0;
            for (int colIndex=0;colIndex<SIZE;colIndex++){
                if(map[rowIndex][colIndex] == symbol){
                    count++;
                    if(count>=SEQUENCE_LENGHT){
                        return true;
                    }
                }
                else {
                    count=0;
                }
            }
        }
        return false;
    }


    //метод проверки ничьей
    private static boolean isMapFull(){
        for (char[] chars : map) {
            for (char cellValue : chars){
                if (cellValue==DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private static void humanTurn() {
        int rowIndex =-1;
        int colIndex =-1;
        do {
            System.out.print("Введите номер строки :");
            if(!SCANNER.hasNextInt()){
                SCANNER.nextLine();
                System.out.println("Введите число");
                continue;
            }
            rowIndex = SCANNER.nextInt()-1;
            System.out.println();

            System.out.print("Введите номер столбца :");
            if(!SCANNER.hasNextInt()){
                SCANNER.nextLine();
                System.out.println("Введите число");
                continue;
            }
            colIndex = SCANNER.nextInt()-1;
            System.out.println();

        } while (!isCellValid(rowIndex,colIndex,DOT_X));

        map[rowIndex][colIndex] = DOT_X;
    }

    private static void computerTurn() {
        int rowIndex =-1;
        int colIndex =-1;
        Random rand =new Random();
        do {
            rowIndex = rand.nextInt(SIZE);
            colIndex = rand.nextInt(SIZE);
        } while (!isCellValid(rowIndex,colIndex,DOT_O));

        map[rowIndex][colIndex] = DOT_O;
    }


    private static boolean isCellValid(int rowIndex, int colIndex,char symbol){
        if((rowIndex < 0||rowIndex>=SIZE) && (colIndex < 0||colIndex >=SIZE)){
            System.out.println("Индексы строки и колонки должны быть в диапозоне от 0 до "+SIZE);
            return false;
        }
        if(map[rowIndex][colIndex]!= DOT_EMPTY){
            if(symbol==DOT_X) System.out.println("Ячейка занята");
            return false;
        }
        return true;
    }

    private static void printMap() {
        //Header
        printHeader();
        //Строки
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int rowIndex = 0; rowIndex < SIZE;rowIndex++){
            System.out.print((rowIndex+1)+" ");
            for(int colIndex = 0;colIndex<SIZE;colIndex++){
                System.out.print(map[rowIndex][colIndex]+ " ");
            }
            System.out.println();
        }
    }

    private static void printHeader() {
        for(int i=0; i<=SIZE;i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initializeGame() {
        for(int rowIndex=0;rowIndex< SIZE;rowIndex++){
            for (int colIndex = 0;colIndex< SIZE;colIndex++){
                map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }
}
