package com.company;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Handler { //This class maintains, updates, and renders all of the game object (apples, snake)

    LinkedList<GameObject> objects = new LinkedList<>();
    int appleCount = 1;

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
            if (snake.getX() == tempApple.getX() && snake.getY() == tempApple.getY()) {
                int[] xy = randomXY(snake, tails);
                tempApple.setX(xy[0]);
                tempApple.setY(xy[1]);
                addObject(new Tail(objects.getLast(), ID.Tail));
            }
        }
    }

    public void render(Graphics g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

    private int[] randomXY(Snake snake, Tail[] tails) {
        int[] xy = {new Random().nextInt(17), new Random().nextInt(17)};

        if (snake.getX() == xy[0] && snake.getY() == xy[1]) xy = randomXY(snake, tails);
        for (Tail tempTail : tails) {
            if (tempTail.getX() == xy[0] && tempTail.getY() == xy[1]) xy = randomXY(snake, tails);
        }
        return xy;
    }

}
