package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas { //Handles the window for the game

    private static final long serialVersionUID = -4499223280698849981L;

    private JFrame frame;

    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);

        frame.setSize(new Dimension(width + 32 + frame.getInsets().left + frame.getInsets().right, height + 32 + 22 + frame.getInsets().top + frame.getInsets().bottom));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "Use arrow keys or WASD to play");
        game.start();
    }

    public void gameOver(int score) {
        if (score >= 286) {
            JOptionPane.showMessageDialog(frame, "You Won!");
        }
        JOptionPane.showMessageDialog(frame, "Score: " + score);
    }

}
