package lesson1;

import lesson1.obstacles.BossFight;
import lesson1.obstacles.Moat;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;

public class Homework1 {
    public static void main(String[] args) {
        Obstacle[] obstacles = new Obstacle[3];
        obstacles[0] = new Moat();
        obstacles[1] = new Wall();
        obstacles[2] = new BossFight();

        Course course = new Course(obstacles);

        Member[] members = new Member[4];
        members[0] = new Member("Измаил", 62);
        members[1] = new Member("Добромир", 200);
        members[2] = new Member("Василий", 110);
        members[3] = new Member("Кузя", 80);

        Team team = new Team("Шерстяной епитрахиль", members);

        course.overcome(team);

    }
}
