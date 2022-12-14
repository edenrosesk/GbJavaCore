package lesson4.first;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Коза", "Свинья", "Курица", "Лошадь", "Корова",
                "Курица", "Козел", "Осел", "Петух", "Кошка",
                "Собака", "Коза", "Гусь", "Утка", "Индюк",
                "Гусыня", "Селезень", "Курица", "Собака", "Цыпленок"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Изначальный массив");
        System.out.println(words.toString());
        System.out.println("Уникальные слова");
        System.out.println(unique.toString());
        System.out.println("Частота встречаемости слов");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}