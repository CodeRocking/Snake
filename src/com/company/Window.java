//Names: Neil Agrawal, Johnathan Tong, and Faraz
package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates a Window for the game to run in as well as popups that display the score and restart the game
 *
 * @author Neil Agrawal
 */
public class Window extends Canvas { //Handles the window for the game

    private static final long serialVersionUID = -4499223280698849981L;

    private static JFrame frame;
    private static Game game;

    /**
     * This constructs a window of the appropriate width and height for the game
     * @param width Width of the window
     * @param height Height of the window
     * @param title Title of the window
     * @param game Game to put in the window
     */
    public Window(int width, int height, String title, Game game) {
        frame = new JFrame(title);
        this.game = game;

        frame.setSize(new Dimension(width + 32 + frame.getInsets().left + frame.getInsets().right, height + 32 + 22 + frame.getInsets().top + frame.getInsets().bottom));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "Use arrow keys or WASD to play");
        game.start();
    }

    /**
     * This displays the popups with the score and the option te restart when the game is over
     * @param score Score
     */
    public static void gameOver(int score) {
        if (score >= 286) {
            JOptionPane.showMessageDialog(frame, "You Won!");
        }
        JOptionPane.showMessageDialog(frame, "Score: " + score);
        int n = JOptionPane.showConfirmDialog(frame, "Play Again?", "Play Again?", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            game.restart();
        } else {
            System.exit(0);
        }
    }

}
