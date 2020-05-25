package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Handler { //This class maintains, updates, and renders all of the game object (apples, snake)

    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject tempObject : objects) {
            tempObject.tick();
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

}
