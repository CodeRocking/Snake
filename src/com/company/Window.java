package com.company;

import java.awt.Canvas;
import java.awt.Dimensions;

import java.swing.JFrame;

public class Window extends Canvas {
  public static final long serialVersionHudUID = 240840600533728354L;

  public Window(int width, int height, String title){
    Jframe frame = new JFrame(title);

    frame.setPreferredsize(new Dimension(width, hieght));
    frame.setMaximumSize(new Dimension(width, hieght));
    frame.setMinimumsize(new Dimension(width, hieght));

    frame.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationTo(null);
    frame.add(game);
    frame.setVisible(true);
    game.start();

  }
}
