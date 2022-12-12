package lesson3.second;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> box = new ArrayList<>();

    public ArrayList<T> getBox() {
        return box;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T t : box) {
            totalWeight = totalWeight + t.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> boxWithSomething) {
        return Math.abs(getWeight() - boxWithSomething.getWeight()) < 0.0001f;
    }

    public void moveFruitsToEmptyBox(Box<T> anotherBox) {
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }
}