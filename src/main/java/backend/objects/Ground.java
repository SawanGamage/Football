package backend.objects;

import backend.shared.Position;

public class Ground {
    private final Ball ball;
    private boolean isGallHit;
    private GallCourt gcLeft;
    private GallCourt gcRight;

    public Ground(GallCourt gcleft, GallCourt gcright, Ball ball) {
        this.gcLeft = gcleft;
        this.gcRight = gcright;
        this.ball = ball;
    }

    public boolean isGallHit() {
        return isGallHit;
    }

    public Ball getBall() {
        return ball;
    }

    public boolean evaluate() {
        double LeftTargetGoalBallDistance = calcDistance(this.gcLeft.getgcPosition(), this.ball.getBallPosition());
        double RightTargetGoalBallDistance = calcDistance(this.gcRight.getgcPosition(), this.ball.getBallPosition());
        if (LeftTargetGoalBallDistance < 1) {
            System.out.println("Red Team hit the gall");
            isGallHit = true;
            return true;
        } else if (RightTargetGoalBallDistance < 1) {
            System.out.println("Blue Team hit the gall");
            isGallHit = true;
            return true;
        } else {
            return false;
        }
    }

    public double calcDistance(Position initialPosition, Position endPosition) {
        double x1 = initialPosition.getX();
        double y1 = initialPosition.getY();
        double x2 = endPosition.getX();
        double y2 = endPosition.getY();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
}
