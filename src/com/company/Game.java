package com.company;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

  public static final int WIDTH = 32 * (17 + 2), HEIGHT = 32 * (15 + 2);

  public Game() {
    new Window(WIDTH, HEIGHT, "Snake", this);
  }

  public synchronized void start() {

  }

  public void run() {

  }

  public static void main(String[] args) {
    new Game();
  }

}
