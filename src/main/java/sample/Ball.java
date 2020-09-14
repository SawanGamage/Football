package sample;

public class Ball {

    private final double radius;
    private Position ballPosition;

    public Position getBallPosition() {
        return ballPosition;
    }

    public void setBallPosition(Position ballPosition) {
        this.ballPosition = ballPosition;
    }

    public Ball(double radius, Position ballPosition) {
        this.radius = radius;
        this.ballPosition = ballPosition;
    }
}
