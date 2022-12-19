package lesson4.second;

import java.util.*;

public class PhoneTableClass {

    private final HashMap<String, List<String>> phonebook;

    public PhoneTableClass(){
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String number) {
        if (phonebook.containsKey(surname)){
            List<String> numbers = phonebook.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.println("Номер " + number + " добавлен для фамилии " + surname + "");
            }
            else {
                System.out.println("Номер " + number + " уже существует для фамилии " + surname + "");
            }
        }
        else {
            phonebook.put(surname, new ArrayList<>(Collections.singletonList(number)));
            System.out.println("Номер " + number + " добавлен для фамилии " + surname + "");
        }

    }

    public List<String> get(String surname){
        return phonebook.get(surname);
    }
}
