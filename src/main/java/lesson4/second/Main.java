package lesson4.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        PhoneTableClass phoneTableClass = new PhoneTableClass();

        System.out.println("Заполняем телефонный справочник");
        phoneTableClass.add("Смирнов", "+79212551415");
        phoneTableClass.add("Новиков", "+79065874522");
        phoneTableClass.add("Кузнецов", "+79956256321");
        phoneTableClass.add("Бобров", "+79201485745");
        phoneTableClass.add("Вилкин", "+79214512655");
        phoneTableClass.add("Смирнов", "+79856958454");
        phoneTableClass.add("Минин", "+79236969656");
        phoneTableClass.add("Пожарский", "+79213336699");
        phoneTableClass.add("Василькин", "+79212225588");
        phoneTableClass.add("Кузнецов", "+79665447788");

        System.out.println("Телефонный справочник заполнен");

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите фамилию: ");

            try {
                String surname = br.readLine();
                var phones = phoneTableClass.get(surname);
                if (phones != null) {
                    System.out.println("Список телефонов для " + surname + ":");
                    System.out.println(phones);
                }
                else {
                    System.out.println("Список телефонов для " + surname + " пуст");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

