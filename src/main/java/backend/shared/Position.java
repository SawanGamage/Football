package backend.shared;

public class Position implements Cloneable {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Position clone() {
        try {
            return (Position) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String printPosition() {
        return "[" + (Math.round(x * 100.0) / 100.0) + "," + (Math.round(y * 100.0) / 100.0) + "]";
    }

}
