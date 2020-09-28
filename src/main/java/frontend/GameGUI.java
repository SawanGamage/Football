package frontend;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GameGUI {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public GameGUI(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createGameGUI();
    }


    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    private void createGameGUI(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }



    public static void main(String[] args) throws IOException {
        Game game =new Game("Foot Ball Game", 900, 600);
        game.start();
    }
}
