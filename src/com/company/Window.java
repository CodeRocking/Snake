package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas { //Handles the window for the game

    private static final long serialVersionUID = -4499223280698849981L;

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width + 32 + frame.getInsets().left + frame.getInsets().right, height + 32 + frame.getInsets().top + frame.getInsets().bottom));
        frame.setMaximumSize(new Dimension(width + 32 + frame.getInsets().left + frame.getInsets().right, height + 32 + frame.getInsets().top + frame.getInsets().bottom));
        frame.setMinimumSize(new Dimension(width + 32 + frame.getInsets().left + frame.getInsets().right, height + 32 + frame.getInsets().top + frame.getInsets().bottom));
        System.out.println(frame.getInsets());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
