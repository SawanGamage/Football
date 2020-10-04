package frontend;

public class Dot {
    private int x;
    private int y;
    private int radious;

    public Dot(int x, int y, int radious) {
        this.x = x;
        this.y = y;
        this.radious = radious;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadious() {
        return radious;
    }

    public void setRadious(int radious) {
        this.radious = radious;
    }
}
