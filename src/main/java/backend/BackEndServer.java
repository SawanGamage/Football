package backend;

import backend.people.Player;
import backend.shared.Position;
import backend.people.Team;
import backend.objects.*;
import datatransfer.Coordinate;
import datatransfer.PositionData;

import java.util.concurrent.TimeUnit;

public class BackEndServer {
    private final int groundWidth;
    private final int groundHeight;
    private Ground ground;
    private Player playerBlue;
    private Player playerRed;

    public BackEndServer(int groundWidth, int groundHeight) {
        this.groundWidth = groundWidth;
        this.groundHeight = groundHeight;
    }

    public void initServer() {
        //define goals
        GallCourt gcLeft = new GallCourt(new Position(0, groundHeight / 2));
        GallCourt gcRight = new GallCourt(new Position(groundWidth, groundHeight / 2));
        Ball ball = new Ball( new Position(groundWidth / 2, groundHeight / 3));

        //define ground
        ground = new Ground(gcLeft, gcRight, ball);

        //blue players
        Team teamBlue = new Team();
        playerBlue = new Player("Blue");
        playerBlue.setPlayerPosition(new Position(200, 300));
        playerBlue.setGround(ground);
        playerBlue.setBall(ball);
        playerBlue.setTeam(teamBlue);
        playerBlue.setGallCourt(gcRight);

        //red players
        Team teamRed = new Team();
        playerRed = new Player("Red");
        playerRed.setPlayerPosition(new Position(500, 70));
        playerRed.setGround(ground);
        playerRed.setBall(ball);
        playerRed.setTeam(teamRed);
        playerRed.setGallCourt(gcLeft);
    }

    public void processData() {
        //imitate that processing takes 2 seconds
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ground.evaluate()) {
            return;
        }
        playerRed.runOrKick();
        if (ground.evaluate()) {
            return;
        }
        playerBlue.runOrKick();
    }

    public boolean isGameOver() {
        return ground.isGallHit();
    }

    public PositionData sendNewCoordinates() {
        Coordinate ballCoordinate = new Coordinate((int) ground.getBall().getBallPosition().getX(), (int) ground.getBall().getBallPosition().getY());
        Coordinate bluePlayerCoordinate = new Coordinate((int) playerBlue.getPlayerPosition().getX(), (int) playerBlue.getPlayerPosition().getY());
        Coordinate redPlayerCoordinate = new Coordinate((int) playerRed.getPlayerPosition().getX(), (int) playerRed.getPlayerPosition().getY());
        return new PositionData(ballCoordinate, redPlayerCoordinate, bluePlayerCoordinate);
    }
}
