package obstacles;

public abstract class Obstacle {
    private final String description;
    private final int power;

    protected Obstacle (String description, int power) {
        this.description = "Препятствие " + description + "(" + power + ")";
        this.power = power;
    }

    public String getDescription() {
        return description;
    }
    public void overcome(int power) {
        try {
            Thread.sleep(1000);
            if (power > this.power) {
                System.out.println(this.getDescription() + " преодолено");
            }
            else {
                System.out.println(this.getDescription() + " провалено");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
