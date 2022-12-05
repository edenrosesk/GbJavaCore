package lesson1;

import obstacles.Obstacle;

public class Course {
    private final Obstacle[] obstacles;
    
    public Course (Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }
    
    public void printDescription () {
        for (Obstacle obstacle : obstacles) {
            System.out.println(obstacle.getDescription());
            
        }
    }
    public void overcome(Team team) {
        System.out.println("Команда " + team.getName() + " пытается пройти полосу препятствий");
        for (Member member: team.getMembers()) {
            int power = member.getPower();
            System.out.println();
            System.out.println("Участник " + member.getName() + ", сила: " + power);
            for (Obstacle obstacle: this.obstacles) {
                obstacle.overcome(power);
            }
        }
    }
}
