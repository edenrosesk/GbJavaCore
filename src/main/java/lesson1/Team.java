package lesson1;

public class Team {
    private final String name;
    private final Member[] members;

    public Team(String name, Member[] members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public Member[] getMembers() {
        return members;
    }
}
