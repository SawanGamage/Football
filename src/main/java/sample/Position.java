package sample;

import static javafx.scene.input.KeyCode.X;
import static javafx.scene.input.KeyCode.Y;

public class Position {
    private double x = 0;
    private double y = 0;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
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
        return "[" + x + "," + y + "]";
    }

}
