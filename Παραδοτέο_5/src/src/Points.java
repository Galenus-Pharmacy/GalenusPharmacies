public class Points {
    private int level, points = 0;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Points(int points) {
        this.points = points;
        if (points <= 1000)
            this.level = 1;
        else if (points <= 2000)
            this.level = 2;
        else if (points <= 3000)
            this.level = 3;
        else if (points <= 4000)
            this.level = 4;
        else
            this.level = 5;
    }

}