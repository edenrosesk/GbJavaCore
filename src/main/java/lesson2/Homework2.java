package lesson2;

public class Homework2 {

    public static void main(String[] args) {
        String[][] array = {{"5","5", "5", "5"}, {"3", "3", "3", "3"}, {"7", "7", "6", "7"}, {"1", "1", "1", "1"}};

        try {
            System.out.println("Сумма: " + sum(array));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
    }

    static int sum(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        checkArray(arr);

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int value = tryParseInt(arr[i][j], i + ":" + j);
                result += value;
            }
        }

        return result;
    }

    static void checkArray(String[][] arr) throws MyArraySizeException {

        if (arr.length!=4) throw new MyArraySizeException();
        for (String[] a: arr) {
            if (a.length!=4) throw new MyArraySizeException();
        }

    }

    static int tryParseInt(String value, String position) throws MyArrayDataException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new  MyArrayDataException("Некорректный символ на позиции " + position);
        }
    }
}
