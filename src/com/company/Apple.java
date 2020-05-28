//Names: Neil Agrawal, Johnathan Tong, and Faraz

package com.company;

import java.awt.*;

/**
 * This class extends GameObject to implement an Apple
 *
 * @author Neil Agrawal and Johnathan Tong
 */
public class Apple extends GameObject {

    /**
     * This constructs an Apple with a specified x-value, y-value, and ID using the super-class constructor
     *
     * @param x  x-value of this Apple
     * @param y  y-value of this Apple
     * @param id ID of this Apple
     */
    public Apple(int x, int y, ID id) {
        super(x, y, id);
    }

    /**
     * This ticks "iterates" movement when called
     */
    @Override
    public void tick() {
    }

    /**
     * This renders this Apple
     *
     * @param g Graphics
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);
    }

}
