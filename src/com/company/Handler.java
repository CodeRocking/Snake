//Names: Neil Agrawal, Johnathan Tong, and Faraz
package com.company;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class maintains, updates, renders, and makes decisions for all of the GameObjects
 *
 * @author Neil Agrawal and Johnathan Tong
 */
public class Handler {

    LinkedList<GameObject> objects = new LinkedList<>();
    int appleCount = 1;
    private int score = 1;

    /**
     * This ticks "iterates" all of the GameObjects movements and decides what to do depending on the positions of the objects
     */
    public void tick() {
        int tailCounter = 0;
        int appleCounter = 0;
        Apple[] apples = new Apple[appleCount];
        Snake snake = new Snake(0, 0, ID.Temp);
        Tail[] tails = new Tail[objects.size() - (appleCount + 1)];

        for (GameObject tempObject : objects) {
            tempObject.tick();
            if (tempObject.getId() == ID.Apple) {
                apples[appleCounter] = (Apple) tempObject;
                appleCounter++;
            } else if (tempObject.getId() == ID.Snake) {
                snake = (Snake) tempObject;
            } else if (tempObject.getId() == ID.Tail) {
                tails[tailCounter] = (Tail) tempObject;
                tailCounter++;
            }
        }

        for (Apple tempApple : apples) {
            if (snake.getX() == tempApple.getX() && snake.getY() == tempApple.getY()) {  //Snake ate apple
                int[] xy = randomXY(snake, tails);
                tempApple.setX(xy[0]);
                tempApple.setY(xy[1]);
                addObject(new Tail(objects.getLast(), ID.Tail));
                score++;
            }
        }

        if (isDead(snake, tails)) {
            Window.gameOver(getScore());
        }
    }

    /**
     * This renders all of the GameObjects
     *
     * @param g Graphics
     */
    public void render(Graphics g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    /**
     * This adds a GameObject
     *
     * @param object GameObject to add
     */
    public void addObject(GameObject object) {
        objects.add(object);
    }

    /**
     * This removes a GameObject
     *
     * @param object GameObject to remove
     */
    public void removeObject(GameObject object) {
        objects.remove(object);
    }

    /**
     * This returns a recursively generated a random x,y pair that doesn't coincide with the Snake
     *
     * @param snake Snake object to avoid
     * @param tails Tail objects to avoid
     * @return x, y pair
     */
    private int[] randomXY(Snake snake, Tail[] tails) {
        int[] xy = {new Random().nextInt(17), new Random().nextInt(17)};

        if (snake.getX() == xy[0] && snake.getY() == xy[1]) xy = randomXY(snake, tails);

        for (Tail tempTail : tails) {
            if (tempTail.getX() == xy[0] && tempTail.getY() == xy[1]) xy = randomXY(snake, tails);
        }

        return xy;
    }

    /**
     * This returns true if the snake is dead after checking all of the cases
     *
     * @param snake Snake object to check
     * @param tails Tail objects to avoid
     * @return A boolean value
     */
    private boolean isDead(Snake snake, Tail[] tails) {
        int x = snake.getX();
        int y = snake.getY();

        if (x < 0 || x >= 17 || y < 0 || y >= 17) return true;

        for (Tail tempTail : tails) if (x == tempTail.getX() && y == tempTail.getY()) return true;

        return false;
    }

    /**
     * This returns the current score
     *
     * @return Score
     */
    public int getScore() {
        return score;
    }

}
