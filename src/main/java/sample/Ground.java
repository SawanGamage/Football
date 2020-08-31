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



        double targetGoalBallDistance = 0;

        //print distance
        if (targetGoalBallDistance < 1) {
            isGallHit = true;
            return true;
            //print goal
        } else {
            return false;

        }
    }
}
