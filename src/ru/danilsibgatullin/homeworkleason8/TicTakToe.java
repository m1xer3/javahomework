package ru.danilsibgatullin.homeworkleason8;

import java.util.Random;

public class TicTakToe {

    private final char DOT_EMPTY ='•';
    private final char DOT_X = 'X';
    private final char DOT_O = 'O';
    private char[][] map;
    private int sequenceLenght;
    private int size;
    private boolean isComputerTurn =true;
    private boolean isGameOver =false;
    private boolean isHaveWinner =false;
    private char winner = DOT_EMPTY;
    private int lastComputerTurnRow=-1;
    private int lastComputerTurnCol=-1;

    public TicTakToe (int size,int sequenceLenght){
        this.size = size;
        this.map = new char[size][size];
        this.sequenceLenght = sequenceLenght;
    }

    public boolean isHaveWinner() {
        return isHaveWinner;
    }

    public int getLastComputerTurnRow() {
        return lastComputerTurnRow;
    }

    public int getLastComputerTurnCol() {
        return lastComputerTurnCol;
    }

    public char getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }


    public  void turn(int rowIndex, int colIndex){
        printMap();
        humanTurn(rowIndex,colIndex);
        printMap();
            if(isGameEnd(DOT_X)){
                winner = DOT_X;
                isGameOver = true;
                return;
            }

            computerTurn();
            printMap();
            if(isGameEnd(DOT_O)){
                winner = DOT_O;
                isGameOver = true;
                return;
            }
            isComputerTurn =true;

        System.out.println(" "+lastComputerTurnRow+" "+lastComputerTurnCol);
        }


    public  boolean isGameEnd(char symbol){
        if(isSomebodyWin(symbol)){
            System.out.println(symbol==DOT_X ? "Человек победил!" : "Машина победила!");
            isHaveWinner = true;
            return true;
        }
        if (isMapFull()){
            System.out.println("Ничья");
            isHaveWinner = false;
            return true;
        }
        return false;
    }


    // метод проверки выйгрыша
    private  boolean isSomebodyWin(char symbol){
        if (isWinByRows(symbol)) return true;
        if (isWinByColumns(symbol)) return true;
        if (isWinByDiagonal(symbol)) return true;
        return false;
    }

    private  boolean isWinByDiagonal(char symbol) {
        if (isMainDiagonal(symbol)) return true;
        if (isCollateralDiagonal(symbol)) return true;

        if(sequenceLenght<size) {
            if (isSubMainDiagonal(symbol)) return true;
            if (isSubCollateralDiagonal(symbol)) return true;
        }


        return false;
    }

    private boolean isSubCollateralDiagonal(char symbol) {
        int count = 0;
        for(int index = 0 ; index<size-1;index++ ){
            if(this.map[index][(size-2)-index] == symbol){
                count++;
                if(count==sequenceLenght-1){
                    blockHumanTurn(index,"isSubCollateralDiagonalUpper");
                }
                if(count>=sequenceLenght){
                    return true;
                }
            }
        }
        count = 0;
        for(int index = 1; index<size;index++ ){
            if(this.map[index][size-index] == symbol){
                count++;
                if(count==sequenceLenght-1){
                    blockHumanTurn(index,"isSubCollateralDiagonalLower");
                }
                if(count>=sequenceLenght){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSubMainDiagonal(char symbol) {
        int count = 0;
        for(int index = 1 ; index<size;index++ ){
            if(this.map[index-1][index] == symbol){
                count++;
                if(count==sequenceLenght-1){
                    blockHumanTurn(index,"isSubMainDiagonalUpper");
                }
                if(count>=sequenceLenght){
                    return true;
                }
            }
        }
        count =0;
        for(int index = 1; index< size; index++){
            if(this.map[index][index-1]==symbol){
                count++;
                if(count==sequenceLenght-1){
                    blockHumanTurn(index,"isSubMainDiagonalLower");
                }
                if(count>=sequenceLenght){
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean isCollateralDiagonal(char symbol) {
        int count =0;
        int dangerCount = 0;
        for(int index = 0; index<size;index++){
            if(this.map[index][(size-1)-index]== symbol){
                count++;
                dangerCount++;
                if(dangerCount==sequenceLenght-1){
                    blockHumanTurn(index,"isCollateralDiagonal");
                }
                if(count>=sequenceLenght){
                    return true;
                }
            }
            else {
                count=0;
            }
        }
        return false;
    }

    private  boolean isMainDiagonal(char symbol) {
        int count =0;
        int dangerCount = 0;
        for(int index = 0; index<size;index++){
            if(this.map[index][index] == symbol){
                count++;
                dangerCount++;
                if(dangerCount==sequenceLenght-1){
                    blockHumanTurn(index,"isMainDiagonal");
                }
                if(count>=sequenceLenght){
                    return true;
                }
            }
            else {
                count=0;
            }
        }
        return false;
    }

    private  boolean isWinByColumns(char symbol) {
        for(int colIndex = 0; colIndex<size;colIndex++){
            int count =0;
            int dangerCount=0;
            for(int rowIndex = 0; rowIndex<size;rowIndex++){
                if(this.map[rowIndex][colIndex] == symbol){
                    count++;
                    dangerCount++;
                    if(dangerCount==sequenceLenght-1){
                        blockHumanTurn(colIndex,"isWinByColumns");
                    }
                    if(count>=sequenceLenght){
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

    private  boolean isWinByRows(char symbol) {
        for(int rowIndex = 0; rowIndex<size;rowIndex++){
            int count =0;
            int dangerCount=0;
            for (int colIndex=0;colIndex<size;colIndex++){
                if(this.map[rowIndex][colIndex] == symbol){
                    count++;
                    dangerCount++;
                    if(dangerCount==sequenceLenght-1){
                        blockHumanTurn(rowIndex,"isWinByRows");
                    }
                    if(count>=sequenceLenght){
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
    private  boolean isMapFull(){
        for (char[] chars : this.map) {
            for (char cellValue : chars){
                if (cellValue==DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    //Реализация хода человека
    private  void humanTurn(int rowIndex,int colIndex) {
        this.map[rowIndex][colIndex] = DOT_X;
    }


    //Реализация хода компьютера при условии что не была выполнена блокировка предвыйграшной ситуации человека
    public  void computerTurn() {
        if(isComputerTurn) {
            int rowIndex = -1;
            int colIndex = -1;
            Random rand = new Random();
            do {
                rowIndex = rand.nextInt(size);
                colIndex = rand.nextInt(size);
            } while (!isCellValid(rowIndex, colIndex, DOT_O));
            map[rowIndex][colIndex] = DOT_O;
            lastComputerTurnRow =rowIndex;
            lastComputerTurnCol =colIndex;

        }
    }

    private  boolean isCellValid(int rowIndex, int colIndex,char symbol){
        if((rowIndex < 0||rowIndex>=size) || (colIndex < 0||colIndex >=size)){
            //System.out.println("Индексы строки и колонки должны быть в диапозоне от 0 до "+size);
            return false;
        }
        if(this.map[rowIndex][colIndex]!= DOT_EMPTY){
            //if(symbol==DOT_X) System.out.println("Ячейка занята");
            return false;
        }
        return true;
    }

    //методы блокировки хода человека при достижении предвыйграшной ситуации
    private  void blockHumanTurn(int index,String whereDanger){
        if(isComputerTurn){
            switch (whereDanger){
                case "isWinByColumns" : blockIsWinByColumns(index); break;
                case "isWinByRows" : blockIsWinByRows(index); break;
                case "isMainDiagonal" : blockIsMainDiagonal(); break;
                case "isCollateralDiagonal" : blockIsCollateralDiagonal(); break;
                case "isSubMainDiagonalUpper" : blockIsSubMainDiagonalUpper(); break;
                case "isSubMainDiagonalLower" : blockIsSubMainDiagonalLower(); break;
                case "isSubCollateralDiagonalUpper" : blockIsSubCollateralDiagonalUpper(); break;
                case "isSubCollateralDiagonalLower" : blockIsSubCollateralDiagonalLower(); break;
                default: break;
            }
        }
    }
    private  void blockIsSubCollateralDiagonalLower(){
        for(int index = 1 ; index<size;index++ ){
            if(this.map[index][size-index] == DOT_EMPTY&&(index!=0|| size-index!=size-1)){
                this.map[index][size-index] = DOT_O;
                lastComputerTurnRow=index;
                lastComputerTurnCol=size-index;
                isComputerTurn =false;
                return;
            }
            else{
                isComputerTurn=true;
            }
        }
    }
    private  void blockIsSubCollateralDiagonalUpper(){
        for(int index = 0 ; index<size-1;index++ ){
            if(this.map[index][(size-2)-index] == DOT_EMPTY&&(index!=0|| ((size-2)-index)!=size-1)){
                this.map[index][(size-2)-index] = DOT_O;
                lastComputerTurnRow=index;
                lastComputerTurnCol=(size-2)-index;
                isComputerTurn =false;
                return;
            }
            else{
                isComputerTurn=true;
            }
        }
    }

    private  void blockIsSubMainDiagonalLower(){
        for(int index = 1 ; index<size;index++ ){
            if(this.map[index][index-1] == DOT_EMPTY&&(index!=0|| index-1!=size-1)){
                this.map[index][index-1] = DOT_O;
                lastComputerTurnRow=index;
                lastComputerTurnCol=index-1;
                isComputerTurn =false;
                return;
            }
            else{
                isComputerTurn=true;
            }
        }
    }
    private  void blockIsSubMainDiagonalUpper(){
        for(int index = 1 ; index<size;index++ ){
            if(this.map[index-1][index] == DOT_EMPTY&&(index-1!=0|| index!=size-1)){
                this.map[index-1][index] = DOT_O;
                lastComputerTurnRow=index-1;
                lastComputerTurnCol=index;
                isComputerTurn =false;
                return;
            }
            else{
                isComputerTurn=true;
            }
        }
    }

    private  void blockIsWinByColumns(int colIndex){
        int count=0;
        for (int rowIndex = 0; rowIndex<size-1;rowIndex++){
            if(this.map[rowIndex][colIndex] == DOT_X){
                count++;
            }
            if(count>=sequenceLenght-2){
                if (rowIndex-1>=0&&this.map[rowIndex-1][colIndex] == DOT_EMPTY) {
                    this.map[rowIndex-1][colIndex] = DOT_O;
                    lastComputerTurnRow=rowIndex-1;
                    lastComputerTurnCol=colIndex;
                    isComputerTurn =false;
                    return;
                } else if (rowIndex+1<size&&this.map[rowIndex+1][colIndex] == DOT_EMPTY) {
                    this.map[rowIndex+1][colIndex] = DOT_O;
                    lastComputerTurnRow=rowIndex+1;
                    lastComputerTurnCol=colIndex;
                    isComputerTurn =false;
                    return;
                }else if (rowIndex-2>=0&&rowIndex+1==size-1&&this.map[rowIndex-2][colIndex]==DOT_EMPTY){
                    this.map[rowIndex-2][colIndex] = DOT_O;
                    lastComputerTurnRow=rowIndex-2;
                    lastComputerTurnCol=colIndex;
                }
            }
            else{
                isComputerTurn=true;
            }
        }
    }

    private  void blockIsWinByRows(int rowIndex){
        int count=0;
        for (int colIndex = 0; colIndex<size-1;colIndex++){
            if(this.map[rowIndex][colIndex] == DOT_X){
                count++;
            }
            if(count>=sequenceLenght-2){
                if (colIndex-1>=0&&this.map[rowIndex][colIndex-1] == DOT_EMPTY) {
                    this.map[rowIndex][colIndex-1] = DOT_O;
                    lastComputerTurnRow=rowIndex;
                    lastComputerTurnCol=colIndex-1;
                    isComputerTurn =false;
                    return;
                } else if (colIndex+1<size&&this.map[rowIndex][colIndex+1] == DOT_EMPTY) {
                    this.map[rowIndex][colIndex+1] = DOT_O;
                    lastComputerTurnRow=rowIndex;
                    lastComputerTurnCol=colIndex+1;
                    isComputerTurn =false;
                    return;
                }else if (colIndex-2>=0&&colIndex+1==size-1&&this.map[rowIndex][colIndex-2] == DOT_EMPTY){
                    this.map[rowIndex][colIndex-2] = DOT_O;
                    lastComputerTurnRow=rowIndex;
                    lastComputerTurnCol=colIndex-2;
                }
            }
            else{
                isComputerTurn=true;
            }
        }
    }

    private  void blockIsMainDiagonal(){
        int count=0;
        for(int index = 0; index<size-1;index++){
            if(this.map[index][index] == DOT_X){
                count++;
            }
            if(count>=sequenceLenght-2){
                if (index-1>=0&&this.map[index-1][index-1] == DOT_EMPTY) {
                    this.map[index-1][index-1] = DOT_O;
                    lastComputerTurnRow=index-1;
                    lastComputerTurnCol=index-1;
                    isComputerTurn =false;
                    return;
                } else if (index+1<size&&this.map[index+1][index+1] == DOT_EMPTY) {
                    this.map[index+1][index+1] = DOT_O;
                    lastComputerTurnRow=index+1;
                    lastComputerTurnCol=index+1;
                    isComputerTurn =false;
                    return;
                }else if (index-2>=0&&index+1==size-1&&map[index-2][index-2] == DOT_EMPTY){
                    map[index-2][index-2] = DOT_O;
                    lastComputerTurnRow=index-2;
                    lastComputerTurnCol=index-2;
                }
            }
            else{
                isComputerTurn=true;
            }
        }
    }

    private  void blockIsCollateralDiagonal(){
        int count=0;
        for(int index = 0; index<size-1;index++){
            if(this.map[index][(size-1)-index] == DOT_X){
                count++;
            }
            if(count>=sequenceLenght-2){
                if (index-1>=0&&this.map[index-1][(size-1)-(index-1)] == DOT_EMPTY) {
                    this.map[index-1][(size-1)-(index-1)] = DOT_O;
                    lastComputerTurnRow=index-1;
                    lastComputerTurnCol=(size-1)-(index-1);
                    isComputerTurn =false;
                    return;
                } else if (this.map[index+1][(size-1)-(index+1)] == DOT_EMPTY) {
                    this.map[index+1][(size-1)-(index+1)] = DOT_O;
                    lastComputerTurnRow=index+1;
                    lastComputerTurnCol=(size-1)-(index+1);
                    isComputerTurn =false;
                    return;
                }else if (index-2>=0&&index+1==size-1&&this.map[index-2][((size-1)-(index-2))]== DOT_EMPTY){
                    this.map[index-2][((size-1)-(index-2))] = DOT_O;
                    lastComputerTurnRow=index-2;
                    lastComputerTurnCol=(size-1)-(index-2);
                }
            }
            else{
                isComputerTurn=true;
            }
        }
    }




//    private  boolean isCellValid(int rowIndex, int colIndex,char symbol){
//        if((rowIndex < 0||rowIndex>=size) || (colIndex < 0||colIndex >=size)){
//            System.out.println("Индексы строки и колонки должны быть в диапозоне от 0 до "+size);
//            return false;
//        }
//        if(map[rowIndex][colIndex]!= DOT_EMPTY){
//            if(symbol==DOT_X) System.out.println("Ячейка занята");
//            return false;
//        }
//        return true;
//    }

    private  void printMap() {
        //Header
        printHeader();
        //Строки
        printMapState();
        System.out.println();
    }

    private  void printMapState() {
        for (int rowIndex = 0; rowIndex < size;rowIndex++){
            System.out.print((rowIndex+1)+" ");
            for(int colIndex = 0;colIndex<size;colIndex++){
                System.out.print(map[rowIndex][colIndex]+ " ");
            }
            System.out.println();
        }
    }

    private  void printHeader() {
        for(int i=0; i<=size;i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public  void initializeGame() {
        for(int rowIndex=0;rowIndex< size;rowIndex++){
            for (int colIndex = 0;colIndex< size;colIndex++){
                this.map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }

}
