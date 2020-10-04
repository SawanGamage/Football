package frontend;

import datatransfer.PositionData;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class FrontEndApplication {
    private final int groundWidth;
    private final int groundHeight;
    private final int panaltyCourtWidth;
    private final int panaltyCourtHeight;
    private final int gallCourtWidth;
    private final int gallCourtHeight;
    private final int centerCircleRadious;
    private final String title;
    private GameGUI gamegui;
    private BufferStrategy bs;
    private Graphics g;

    //moving items
    private Dot ballDot;
    private Dot bluePlayerDot;
    private Dot redPlayerDot;

    public FrontEndApplication(int groundWidth, int groundHeight, int panaltyCourtWidth, int panaltyCourtHeight, int gallCourtWidth, int gallCourtHeight, int centerCircleWidth, int dotRadious, String title) {
        this.groundWidth = groundWidth;
        this.groundHeight = groundHeight;
        this.panaltyCourtWidth = panaltyCourtWidth;
        this.panaltyCourtHeight = panaltyCourtHeight;
        this.gallCourtWidth = gallCourtWidth;
        this.gallCourtHeight = gallCourtHeight;
        this.centerCircleRadious = centerCircleWidth;
        this.title = title;
        init(dotRadious);
    }

    private void init(int dotRadious) {
        gamegui = new GameGUI(title, groundWidth, groundHeight);
        ballDot = new Dot(0, 0, dotRadious);
        bluePlayerDot = new Dot(0, 0, dotRadious);
        redPlayerDot = new Dot(0, 0, dotRadious);
    }

    public void redrawGUI() {

        bs = gamegui.getCanvas().getBufferStrategy();
        if (bs == null) {
            gamegui.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear all to redraw
        g.clearRect(0, 0, groundWidth, groundHeight);

        //Ground and outline boarder
        g.setColor(Color.green);
        g.fillRect(0, 0, groundWidth, groundHeight);
        g.setColor(Color.black);
        g.drawRect(0, 0, groundWidth, groundHeight);

        //Penalty Area Left
        g.setColor(Color.black);
        g.drawRect(0, (groundHeight - panaltyCourtHeight) / 2, panaltyCourtWidth, panaltyCourtHeight);
        //GoalCourt Left
        g.setColor(Color.black);
        g.drawRect(0, (groundHeight - gallCourtHeight) / 2, gallCourtWidth, gallCourtHeight);

        //Penalty Area Right
        g.setColor(Color.black);
        g.drawRect((groundWidth - panaltyCourtWidth), (groundHeight - panaltyCourtHeight) / 2, panaltyCourtWidth, panaltyCourtHeight);
        //GoalCourt Left
        g.setColor(Color.black);
        g.drawRect((groundWidth - gallCourtWidth), (groundHeight - gallCourtHeight) / 2, gallCourtWidth, gallCourtHeight);

        //Mid line
        g.setColor(Color.black);
        g.drawRect(groundWidth / 2, 0, 0, groundHeight);

        //Center Circle
        g.setColor(Color.black);
        g.drawOval((groundWidth / 2 - centerCircleRadious), (groundHeight / 2 - centerCircleRadious), centerCircleRadious * 2, centerCircleRadious * 2);

        //Ball
        g.setColor(Color.gray);
        g.fillOval(ballDot.getX() - ballDot.getRadious(), ballDot.getY() - ballDot.getRadious(), ballDot.getRadious() * 2, ballDot.getRadious() * 2);

        //Blue Player
        g.setColor(Color.blue);
        g.fillOval(bluePlayerDot.getX() - bluePlayerDot.getRadious(), bluePlayerDot.getY() - bluePlayerDot.getRadious(), bluePlayerDot.getRadious() * 2, bluePlayerDot.getRadious() * 2);

        //Red Player
        g.setColor(Color.red);
        g.fillOval(redPlayerDot.getX() - redPlayerDot.getRadious(), redPlayerDot.getY() - redPlayerDot.getRadious(), redPlayerDot.getRadious() * 2, redPlayerDot.getRadious() * 2);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    public void updateLocations(PositionData positionData) {
        ballDot.setX(positionData.getBallCoordinate().getX());
        ballDot.setY(positionData.getBallCoordinate().getY());

        bluePlayerDot.setX(positionData.getBluePlayerCoordinate().getX());
        bluePlayerDot.setY(positionData.getBluePlayerCoordinate().getY());

        redPlayerDot.setX(positionData.getRedPlayerCoordinate().getX());
        redPlayerDot.setY(positionData.getRedPlayerCoordinate().getY());
    }
}
