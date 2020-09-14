import backend.people.Player;
import sample.Position;
import backend.people.Team;
import sample.*;

public class Main {

    public static void main(String[] args) {

        Position gcLeftPosition = new Position(2, 22);
        GallCourt gcLeft = new GallCourt(6, 4, gcLeftPosition);

        Position gcRightPosition = new Position(68, 22);
        GallCourt gcRight = new GallCourt(6, 4, gcRightPosition);

        Position spotPosition = new Position(35, 22);
        CenterSpot spot = new CenterSpot(6, spotPosition);

        Position ballPosition = new Position(35, 22);
        Ball ball = new Ball(0, ballPosition);

        Ground ground = new Ground(70, 44, gcLeft, gcRight, spot, ball);

        Team teamBlue = new Team();
        Team teamRed  = new Team();

        Player playerBlue = new Player("Blue");
        Position playerBluePosition = new Position(55, 22);
        playerBlue.setPlayerPosition(playerBluePosition);
        playerBlue.setGround(ground);
        playerBlue.setBall(ball);
        playerBlue.setTeam(teamBlue);
        playerBlue.setGallCourt(gcRight);
        System.out.println("Player Name: "+playerBlue.getName());
        System.out.println("Start Position: "+ playerBlue.getPlayerPosition().printPosition());

        Player playerRed = new Player("Red");
        Position playerRedPosition = new Position(38, 22);
        playerRed.setPlayerPosition(playerRedPosition);
        playerRed.setGround(ground);
        playerRed.setBall(ball);
        playerRed.setTeam(teamRed);
        playerRed.setGallCourt(gcLeft);
        System.out.println("Player Name: "+playerRed.getName());
        System.out.println("Start Position: "+ playerRed.getPlayerPosition().printPosition());
        // game start
        while (!ground.isGallHit) {
            playerRed.runOrKick();
            if (ground.evaluate()) {
                continue;
            }
            playerBlue.runOrKick();
            if (ground.evaluate()) {
                continue;
            }
        }
        System.out.println("game finished");
    }
}
