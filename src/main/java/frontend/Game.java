package frontend;


import sample.Position;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    public int width, height;
    public String title;
    private Position playerPosition;
    private GameGUI gamegui;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    private void init() {
        gamegui = new GameGUI(title, width, height);
    }

    private void tick() {

    }

    private void render() {

        bs = gamegui.getCanvas().getBufferStrategy();
        if (bs == null) {
            gamegui.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear Scree
        g.clearRect(0, 0, width, height);
        //Draw Here!

        //Ground
        g.setColor(Color.green);

        g.fillRect(0, 0, 700, 440);

        //Border
        g.setColor(Color.black);
        g.drawRect(0, 0, 700, 440);

        //Penalty Area Left
        g.setColor(Color.black);
        g.drawRect(0, 90, 110, 260);
        //GoalCourt Left
        g.setColor(Color.black);
        g.drawRect(0, 160, 40, 120);

        //Penalty Area Right
        g.setColor(Color.black);
        g.drawRect(590, 90, 110, 260);
        //GoalCourt Left
        g.setColor(Color.black);
        g.drawRect(660, 160, 40, 120);

        //Mid line
        g.setColor(Color.black);
        g.drawRect(350, 0, 0, 440);

        //Center Spot
        g.setColor(Color.black);
        g.drawOval(290, 160, 120, 120);

        //Ball
        g.setColor(Color.gray);
        g.fillOval(345, 215, 10, 10);

        //Blue Player
        g.setColor(Color.blue);
        g.fillOval(315, 215, 10, 10);

        //Red Player
        g.setColor(Color.red);
        g.fillOval(375, 215, 10, 10);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        while (running) {
            tick();
            render();
        }
        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
