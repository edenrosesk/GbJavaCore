package lesson3.first;

import java.util.Arrays;

public class Homework3 {

        static String[] arrayString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        static Integer[] arrayInteger = {1, 2, 3};
        static Double[] arrayDouble = {1.0, 2.5, 3.0, 4.0, 5.0, 6.9, 7.0, 8.0, 9.0, 0.0};

        public static void main(String[] args) {
            SwapArray<Object> swapArrayClass = new SwapArray<>();
            try {
                System.out.println(Arrays.toString(swapArrayClass.swapElements(arrayString, 0, 1)));
            } catch (ArrayIndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
            try {
                System.out.println(Arrays.toString(swapArrayClass.swapElements(arrayInteger, 0, 1)));
            } catch (ArrayIndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
            try {
                System.out.println(Arrays.toString(swapArrayClass.swapElements(arrayDouble, 0, 1)));
            } catch (ArrayIndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
        }
    }