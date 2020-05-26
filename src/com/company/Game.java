package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -7343609367987596684L;
    public static final int WIDTH = 32 * (17), HEIGHT = 32 * (17);
    private Thread thread;
    private Boolean running = false;
    public Handler handler;
    public static Snake newSnake = new Snake(4, 8, ID.Snake);
    public static Apple newApple = new Apple(12, 8, ID.Apple);

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Snake", this);

        //for (int xinc = 0; xinc < 17; xinc += 2) {
        //for (int yinc = 0; yinc < 17; yinc += 2) {
        // handler.addObject(new Snake(4, 8, ID.Snake));
        handler.addObject(newSnake);
        handler.addObject(newApple);
        //}
        //}
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

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }

}
