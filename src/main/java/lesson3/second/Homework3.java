package lesson3.second;

public class Homework3 {
    public static void main(String[] args) {
        Box<Apple> boxForApple = new Box<>();
        boxForApple.addFruit(new Apple());
        boxForApple.addFruit(new Apple());
        boxForApple.addFruit(new Apple());

        Box<Orange> boxForOranges = new Box<>();
        boxForOranges.addFruit(new Orange());
        boxForOranges.addFruit(new Orange());

        Box<Orange> secondBoxForOranges = new Box<>();

        System.out.println("Ящик с яблоками весит  " + boxForApple.getWeight());
        System.out.println("Ящик с апельсинами весит " + boxForOranges.getWeight());
        System.out.println(boxForApple.compare(boxForOranges));

        boxForOranges.moveFruitsToEmptyBox(secondBoxForOranges);
        System.out.println(boxForOranges.getBox());
        System.out.println(secondBoxForOranges.getBox());
    }
}
