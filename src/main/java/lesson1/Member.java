package lesson1;

public class Member {
    private final String name;
    private final int power;

    public Member(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
