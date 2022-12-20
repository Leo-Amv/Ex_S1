package ru.gb.exs1;

import java.util.ArrayList;
import java.util.List;

//Реализуйте метод checkArray(Integer[] arr),
// принимающий в качестве аргумента целочисленный одномерный массив.
// Метод должен пройтись по каждому элементу и проверить что он не равен null.
// А теперь реализуйте следующую логику:
//        Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
//        Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Integer[] arr = {1, 2, 3, null, 4,null, 56, null, 7};
        try{
            main.checkArray(arr);
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }

    public void checkArray(Integer[] arr) throws MyException {
        if (arr == null) {
            throw new IllegalStateException("null parameter");
        }
        if (arr.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        List<Integer> indexes = new ArrayList<>();
        boolean nullable = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                indexes.add(i);
                nullable = true;
            }
        }
        if (nullable){
            throw new MyException("Value is nullable"+ "\nIndexes of null values:\t" + indexes);
        }
    }
}