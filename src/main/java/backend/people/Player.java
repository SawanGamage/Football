package backend.people;

import sample.*;

public class Player {
    private Position playerPosition;
    private GallCourt gallCourt;
    private String name;
    private Team teamBlue;
    private Team teamRed;
    private Ground ground;
    private Ball ball;

    public Player(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void run() {
        System.out.println("Player is running");
    }

    public void kick() {
    }

    public void action() {
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setTeamBlue(Team teamBlue) {
        this.teamBlue = teamBlue;
    }

    public void setTeamRed(Team teamRed) {
        this.teamRed = teamRed;
    }

    public GallCourt getGallCourt() {
        return gallCourt;
    }

    public void setGallCourt(GallCourt gallCourt) {
        this.gallCourt = gallCourt;
    }


    public void runOrKick() {
        //measure distance between ball and players
        System.out.println(("player position : ") + this.playerPosition.getX() + this.playerPosition.getY());
        System.out.println(("ball position : ") + this.ball.getBallPosition().getX() + this.ball.getBallPosition().getY());


        double playerBallDistance = calcDistance(this.ball.getBallPosition(), this.playerPosition);

        double targetGoalBallDistance = calcDistance(this.gallCourt.getgcPosition(), this.ball.getBallPosition());

        System.out.println("distance : " + playerBallDistance);
        // if ball is to far run to the ball,
        //step1: if ball is far away than 5m, run 5m
        //step2: if distance is less than 5m, go 4m near
        if (playerBallDistance > 1) {

            while (playerBallDistance <= 1) {

                Position newPlayerPosition = calcPosition(this.playerPosition, this.ball.getBallPosition(), 2);

                setPlayerPosition(newPlayerPosition);

                System.out.println("distance : " + playerBallDistance);
                System.out.println(("player position : ") + this.playerPosition.getX() + this.playerPosition.getY());
                System.out.println(("ball position : ") + this.ball.getBallPosition().getX() + this.ball.getBallPosition().getY());
            }

        }// else {
        // if distance is less than 1 m, he kick to the ball towards the middle of the goal
        if (playerBallDistance <= 1)
            while (targetGoalBallDistance < 1) {

                Position newBallPosition = calcPosition(this.ball.getBallPosition(), this.gallCourt.getgcPosition(), 5);

                ball.setBallPosition(newBallPosition);
            }
    }
    public Position calcPosition(Position initialPosition, Position endPosition, double movement) {
        double x1 = initialPosition.getX();
        double y1 = initialPosition.getY();
        double x3 = endPosition.getX();
        double y3 = endPosition.getY();

        if (x1 == x3) {
            double newX = x1;
            double newY = y1 + movement;
            return new Position(newX, newY);
        }
        if (y1 == y3) {
            double newY = y1;
            double newX = x1 + movement;
            return new Position(newX, newY);

        } else {
            double newX = Math.sqrt(Math.pow(movement, 2) / (Math.pow((y3 - y1) / (x3 - x1), 2)) + 1) + x1;
            double newY = Math.sqrt(Math.pow(movement, 2) / (Math.pow((x3 - x1) / (y3 - y1), 2)) + 1) + y1;
            return new Position(newX, newY);

        }
    }
    public double calcDistance(Position initialPosition, Position endPosition) {
        //todo implement here
        double x1 = initialPosition.getX();
        double y1 = initialPosition.getY();
        double x2 = endPosition.getX();
        double y2 = endPosition.getY();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        return distance;
    }

}



