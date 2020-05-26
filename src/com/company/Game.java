package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -7343609367987596684L;
    public static final int WIDTH = 32 * (17), HEIGHT = 32 * (17);
    private Thread thread;
    private boolean running = false;
    private int score = 1;
    private Handler handler;
    private Window window;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        window = new Window(WIDTH, HEIGHT, "Snake", this);
        handler.addObject(new Apple(12, 8, ID.Apple));
        handler.addObject(new Snake(4, 8, ID.Snake));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
            window.gameOver(score);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() { //Game loop
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 3;  //changes speed
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(71, 122, 39));
        g.fillRect(0, 0, WIDTH + 32, HEIGHT + 32);

        g.setColor(new Color(147, 202, 57));
        g.fillRect(16, 16, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 16, 12);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public boolean isRunning() {
        return running;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        new Game();
    }

}
