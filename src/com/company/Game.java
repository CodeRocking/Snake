//Names: Neil Agrawal, Johnathan Tong, and Faraz
package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * This class runs the game
 *
 * @author Neil Agrawal, Johnathan Tong, and Faraz Mirza
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -7343609367987596684L;
    public static final int WIDTH = 32 * (17), HEIGHT = 32 * (17);
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Window window;

    /**
     * This constructs a Game object
     */
    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        window = new Window(WIDTH, HEIGHT, "Snake", this);
        handler.addObject(new Apple(12, 8, ID.Apple));
        handler.addObject(new Snake(4, 8, ID.Snake));
    }

    /**
     * This starts the game
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * This restarts the game
     */
    public synchronized void restart() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        handler.addObject(new Apple(12, 8, ID.Apple));
        handler.addObject(new Snake(4, 8, ID.Snake));
    }

    /**
     * This is the game loop that runs the game
     */
    public void run() { //Game loop
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 5;  //changes speed
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

    /**
     * This tells the handler to tick "iterate" movement in the game
     */
    private void tick() {
        handler.tick();
    }

    /**
     * This renders the game board
     */
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
        g.drawString("Score: " + handler.getScore(), 16, 12);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    /**
     * This returns if the game is running
     *
     * @return is the game running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        new Game();
    }

}
