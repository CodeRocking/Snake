//Names: Neil Agrawal, Johnathan Tong, and Faraz

package com.company;

import java.awt.*;

/**
 * This class extends GameObject to implement a Snake
 *
 * @author Neil Agrawal and Johnathan Tong
 */
public class Snake extends GameObject {

    /**
     * This constructs a Snake with a specified x-value, y-value, and ID using the super-class constructor
     *
     * @param x  x-value of this Snake
     * @param y  y-value of this Snake
     * @param id ID of this Snake
     */
    public Snake(int x, int y, ID id) {
        super(x, y, id);
    }

    /**
     * This ticks "iterates" movement when called
     */
    @Override
    public void tick() {
        prevX = x;
        prevY = y;

        x += velX;
        y += velY;
    }

    /**
     * This renders this Snake
     *
     * @param g Graphics
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);
    }
}
