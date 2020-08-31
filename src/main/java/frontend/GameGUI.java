package frontend;

import javax.swing.*;
import java.io.IOException;

public class GameGUI {

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) throws IOException {
        JFrame ff = new JFrame("First One");
        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ff.setSize(300, 300);
        JButton bb = new JButton("press");
        JLabel jLabel = new JLabel("01");
        ff.getContentPane().add(bb);
        ff.getContentPane().add(jLabel);
        ff.setVisible(true);
        bb.setHorizontalTextPosition(100);
        bb.setVerticalTextPosition(100);
    }
}
