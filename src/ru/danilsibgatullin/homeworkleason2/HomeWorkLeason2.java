package ru.danilsibgatullin.homeworkleason2;

public class HomeWorkLeason2 {

    public static void main(String[] args){

        //Упражнение 1
        int[] arr = {1,0,1,1,1,1,0,0,0,0};
        change0And1InArray(arr);
        System.out.println("------------------------------"); //визуальное разделение упражнение в консоле

        //Упражнение 2
        initiallArrayLength8();
        System.out.println("------------------------------"); //визуальное разделение упражнение в консоле

        //Упражнение 3
        multiplyOn2IntLess6();
        System.out.println("------------------------------"); //визуальное разделение упражнение в консоле

        //Упражнение 4
        diagonalInt1InArray();
        System.out.println("------------------------------"); //визуальное разделение упражнение в консоле

        //Упражнение 5
        int[] arr5 = {233,12,3,1,40,12,23,-5,31,199};
        minAndMaxElementInArray(arr5);
        System.out.println("------------------------------"); //визуальное разделение упражнение в консоле

        //Упражнение 6
        int[] arr6 = {2, 1, 2, 1};
       // isArrHaveBalance(arr6);
        System.out.println("Массив сбалансирован? "+isArrHaveBalance(arr6));
        System.out.println("------------------------------"); //визуальное разделение упражнение в консоле

        //Упражнение 7
        int[] arr7 = {1, 2, 3,4,5,6,7,8};
        int n = 4;
        pushArrayEllementsToN(arr7,n);



    }

    // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void change0And1InArray (int[] arr) {
        System.out.println("Оригинальный массив");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println(); // смещаем курсор на другую строчку
        System.out.println("Измененный массив ");
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0) {
                arr[i]=1;
            } else {
                arr[i]=0;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // смещаем курсор на другую строчку

    }

    //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static void initiallArrayLength8() {

        int[] arr = new int[8];
        for (int i=0;i< arr.length;i++){
            arr[i] = 3*i;
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // смещаем курсор на другую строчку

    }

    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static void multiplyOn2IntLess6() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0;i< arr.length;i++){
            if(arr[i]<6){
                arr[i]*=2;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // смещаем курсор на другую строчку
    }

    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    static void diagonalInt1InArray(){
        int[][] arr = new int[7][7];

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (i==j){
                    arr[i][j]=1;
                    arr[i][(arr[i].length-1)-i]=1;
                }
            }
        }
        //Выводим полученный массив
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); // смещаем курсор на другую строчку
        }

    }

    // ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    static void minAndMaxElementInArray(int[] arr){
        int max,min;
        max=arr[0];
        min=arr[1];
        for (int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
            else if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("Минимальный элемент массива " + min);
        System.out.println("Максимальный элемент массива " + max);
    }

    /** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     */
    static boolean isArrHaveBalance(int[] arr){
        int i,j;
        i=0;
        j=arr.length-1;
        int leftSum ,rightSum;
        leftSum = arr[i]; // первый элемент
        rightSum = arr[j]; // последний элемент
        while(i!=j-1){
            if (leftSum>=rightSum){
                j--;
                rightSum+=arr[j];
            }else {
                i++;
                leftSum+=arr[i];
            }

        }
        if (leftSum==rightSum){
            return true;
        }
        else return false;
    }

    /* **** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    static void pushArrayEllementsToN(int[] arr,int n){

        //Вывод оригинального массива
        System.out.println("Оригинальный массив");
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Смещение элементов будет осуществленно на " + n + " элементов");

       int buffUpdate ,buffSave ; // Объявляем буферные переменные

       //Если количество позиций для смещение больше длинны массива , отбрасываем полный проход по идексам массива оставляя только реально исполняемую часть
        if(n>=arr.length||(0-n)>=arr.length){
               n=n%(arr.length);
        }

        //если количество смещений после преобразования равно 0 фактического смещения не произойдет
        if (n==0){
               System.out.println("Введеное количество смещений кратно длинне массива или равно 0, фактического перемещения не произойдет");
               return;
        }

        int countMultipleN= 1;
        int adres;
        //Если смещение n положительное
        if (n>0) {
            buffUpdate = arr[0];
            //Если число смещений не кратно длинне массива
            if (arr.length%n!=0) {
                 adres=n*countMultipleN;
                 while (countMultipleN <= arr.length) {
                    buffSave = arr[adres];
                    arr[adres] = buffUpdate;
                    buffUpdate = buffSave;
                    countMultipleN++;
                    adres =(n * countMultipleN);

                    if (adres > arr.length - 1) {
                        adres %= arr.length;
                    }
                }
            }
            /* Если количество проходов кратно длинне используем более сложный вариант
            После одной итерации будем принудильно смещать на единицу вперед что бы не получилось зацикливание
             */
            else{
                int i=0; //интерации будем начинать с первого элемента и после прохождения полного круга увеличивать переменную для избежания зацикливания
                adres = n * countMultipleN;
                buffUpdate = arr[0];
                while(i<n) {
                    buffSave = arr[adres];
                    arr[adres]=buffUpdate;
                    buffUpdate=buffSave;
                    countMultipleN++;
                    adres =i+(n*countMultipleN);

                    if (adres > arr.length - 1) {
                       adres %=arr.length;
                       arr[adres] = buffUpdate;
                       i++;
                       adres = i;
                       buffUpdate=arr[adres];
                       adres = adres+n;
                       countMultipleN=1;
                    }
                }
            }
        }
        //Если смещение n отрицательно
        else{
            buffUpdate = arr[arr.length - 1];
            adres = (arr.length - 1) + (n * countMultipleN);
            //Если число смещений не кратно длинне массива
            if (arr.length%n!=0) {
                while (countMultipleN <= arr.length) {
                    buffSave = arr[adres];
                    arr[adres] = buffUpdate;
                    buffUpdate = buffSave;
                    countMultipleN++;
                    adres = (arr.length - 1) + (n * countMultipleN);
                    adres = adres % arr.length;

                    if (adres < 0) {
                        adres = arr.length + adres;
                    }
                }
            }
            else{
                int i=arr.length - 1; //интерации будем начинать с последнего элемента и после прохождения полного круга уменьшать на 1 переменную для избежания зацикливания
                while((arr.length - 1 - i)<(0-n)) {
                    buffSave = arr[adres];
                    arr[adres]=buffUpdate;
                    buffUpdate=buffSave;
                    countMultipleN++;
                    adres =i+(n*countMultipleN);

                    if (adres<0) {
                        adres =arr.length+(adres%arr.length);
                        arr[adres] = buffUpdate;
                        i--;
                        adres = i;
                        buffUpdate=arr[adres];
                        adres = adres+n;
                        countMultipleN=1;
                    }
                }
            }
        }
        //Вывод результата преобразования
        System.out.println("Измененный массив");
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}


