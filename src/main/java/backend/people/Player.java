package backend.people;

import backend.objects.*;
import backend.shared.Position;

public class Player {
    public static final int LONG_RUN_DISTANCE = 20;
    public static final int LONG_KICK_DISTANCE = 30;
    public static final int TOLARENCE = 6;
    private Position playerPosition;
    private GallCourt gallCourt;
    private String name;
    private Team team;
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

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public GallCourt getGallCourt() {
        return gallCourt;
    }

    public void setGallCourt(GallCourt gallCourt) {
        this.gallCourt = gallCourt;
    }

    public void runOrKick() {
        //measure distance between ball and players
        Position initialPlayerPosition = playerPosition.clone();
        Position initialBallPosition = ball.getBallPosition().clone();

        double playerBallDistance = calcDistance(this.ball.getBallPosition(), this.playerPosition);
        double targetGoalBallDistance = calcDistance(this.gallCourt.getgcPosition(), this.ball.getBallPosition());

        boolean isRunning = false;
        boolean longPlayerDistance = false;
        boolean longBallDistance = false;
        if (playerBallDistance > TOLARENCE) {
            isRunning = true;
            if (playerBallDistance <= LONG_RUN_DISTANCE) {
                longPlayerDistance = false;
                setPlayerPosition(this.ball.getBallPosition());
            } else {
                longPlayerDistance = true;

                Position newPlayerPosition = calcPosition(this.playerPosition, this.ball.getBallPosition(), getRandomDoubleBetweenRange(TOLARENCE, LONG_RUN_DISTANCE));
                setPlayerPosition(newPlayerPosition);
            }
        } else {
            isRunning = false;
            if (targetGoalBallDistance <= LONG_KICK_DISTANCE) {
                longBallDistance = false;
                ball.setBallPosition(this.gallCourt.getgcPosition());
            } else {
                longBallDistance = true;
                Position newBallPosition = calcPosition(this.ball.getBallPosition(), this.gallCourt.getgcPosition(), getRandomDoubleBetweenRange(TOLARENCE, LONG_KICK_DISTANCE));
                ball.setBallPosition(newBallPosition);
            }
        }

        String summery = "Player: " + name + " on " + initialPlayerPosition.printPosition() + " sees ball at " + initialBallPosition.printPosition() + " and" +
                " distance to ball is " + playerBallDistance + "\n" +
                (isRunning ? "He decided to take " + (longPlayerDistance ? "long" : "short") + " run" : "he decided to take " + (longBallDistance ? "long" : "short") + " kick to the ball.") +
                (isRunning ? " and palyer's end position is " + getPlayerPosition().printPosition() : " and ball end position is " + ball.getBallPosition().printPosition() + "and" +
                        " distance to gall is " + targetGoalBallDistance);
        System.out.println(summery);
    }
    public Position calcPosition(Position initialPosition, Position endPosition, int movement) {
        double x1 = initialPosition.getX();
        double y1 = initialPosition.getY();
        double x3 = endPosition.getX();
        double y3 = endPosition.getY();

        if (x1 == x3 && y1 < y3) {
            double newX = x1;
            double newY = y1 + movement;
            return new Position(newX, newY);
        }
        if (y1 == y3 && x1 < x3) {
            double newY = y1;
            double newX = x1 + movement;
            return new Position(newX, newY);
        }
        if (x1 == x3 && y1 > y3) {
            double newX = x1;
            double newY = y1 - movement;
            return new Position(newX, newY);
        }
        if (y1 == y3 && x1 > x3) {
            double newY = y1;
            double newX = x1 - movement;
            return new Position(newX, newY);
        }
        if (x1 > x3 && y1 > y3) {
            double newX = x1 - Math.sqrt(Math.pow(movement, 2) / (Math.pow((y3 - y1) / (x3 - x1), 2) + 1));
            double newY = y1 - Math.sqrt(Math.pow(movement, 2) / (Math.pow((x3 - x1) / (y3 - y1), 2) + 1));
            return new Position(newX, newY);
        }
        if (x1 > x3 && y1 < y3) {
            double newX = x1 - Math.sqrt(Math.pow(movement, 2) / (Math.pow((y3 - y1) / (x3 - x1), 2) + 1));
            double newY = Math.sqrt(Math.pow(movement, 2) / (Math.pow((x3 - x1) / (y3 - y1), 2) + 1)) + y1;
            return new Position(newX, newY);
        }
        if (x1 < x3 && y1 > y3) {
            double newX = Math.sqrt(Math.pow(movement, 2) / (Math.pow((y3 - y1) / (x3 - x1), 2) + 1)) + x1;
            double newY = y1 - Math.sqrt(Math.pow(movement, 2) / (Math.pow((x3 - x1) / (y3 - y1), 2) + 1));
            return new Position(newX, newY);
        } else {
            double newX = Math.sqrt(Math.pow(movement, 2) / (Math.pow((y3 - y1) / (x3 - x1), 2) + 1)) + x1;
            double newY = Math.sqrt(Math.pow(movement, 2) / (Math.pow((x3 - x1) / (y3 - y1), 2) + 1)) + y1;
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
        return (Math.round(distance * 100.0) / 100.0);
    }
    public static int getRandomDoubleBetweenRange(int min, int max) {

        int x = (int) Math.round ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

}



