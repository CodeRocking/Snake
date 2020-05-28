//Names: Neil Agrawal, Johnathan Tong, and Faraz
package com.company;

import java.awt.*;

/**
 * This class extends GameObject to implement a Tail
 *
 * @author Neil Agrawal
 */
public class Tail extends GameObject {

    private GameObject leadObject;

    /**
     * This constructs a Tail with a specified lead GameObject, and ID overriding the super-class constructor
     *
     * @param leadObject GameObject the this Tail follows.
     *                   Should only be a Snake or Tail object.
     * @param id         ID
     */
    public Tail(GameObject leadObject, ID id) {
        super(leadObject.getPrevX(), leadObject.getPrevY(), id);
        this.leadObject = leadObject;
    }

    /**
     * This ticks "iterates" movement when called
     */
    @Override
    public void tick() {
        prevX = x;
        prevY = y;
        x = leadObject.getPrevX();
        y = leadObject.getPrevY();
    }

    /**
     * This renders this Tail
     *
     * @param g Graphics
     */
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);
    }
}
