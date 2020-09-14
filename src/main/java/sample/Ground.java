package sample;

import backend.people.Player;

public class Ground {

    private final Integer length;
    private final Integer width;
    private final CenterSpot radius;
    private final Ball ball;
    public boolean isGallHit = false;
    private GallCourt gcLeft;
    private GallCourt gcRight;
    private GallCourt gallCourt;

    public Ground(Integer length, Integer width, GallCourt gcleft, GallCourt gcright, CenterSpot radius, Ball ball) {
        this.length = length;
        this.width = width;
        this.gcLeft = gcleft;
        this.gcRight = gcright;
        this.radius = radius;
        this.ball = ball;
    }
    public boolean evaluate() {
        // if ball is in any goal court nake isHitVar to be true
        //otherwise false
        //left right distance
        double LeftTargetGoalBallDistance = calcDistance(this.gcLeft.getgcPosition(), this.ball.getBallPosition());
        double RightTargetGoalBallDistance = calcDistance(this.gcRight.getgcPosition(), this.ball.getBallPosition());
        //print distance
        if (LeftTargetGoalBallDistance < 1){
            System.out.println("Red Team hit the gall");
            isGallHit = true;
            return true;
        }

        if (RightTargetGoalBallDistance < 1){
            System.out.println("Blue Team hit the gall");
            isGallHit = true;
            return true;
        }

        else {
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
