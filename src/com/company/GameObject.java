//Names: Neil Agrawal, Johnathan Tong, and Faraz

package com.company;

import java.awt.*;

/**
 * This class implements some basic methods providing a convenient base for GameObjects to build on
 *
 * @author Neil Agrawal and Johnathan Tong
 */
public abstract class GameObject {

    protected int x, y, velX, velY, prevX, prevY;
    protected ID id;

    /**
     * This constructs a GameObject with a specified x-value, y-value, and ID
     *
     * @param x  x-value of this GameObject
     * @param y  y-value of this GameObject
     * @param id id of this GameObject
     */
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * This ticks "iterates" movement when called
     */
    public abstract void tick();

    /**
     * This renders the GameObject
     *
     * @param g Graphics
     */
    public abstract void render(Graphics g);

    /**
     * This returns the current x-value of this GameObject
     *
     * @return x-value
     */
    public int getX() {
        return x;
    }

    /**
     * This sets the current x-value of this GameObject
     *
     * @param x x-value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * This returns the current y-value of this GameObject
     *
     * @return y-value
     */
    public int getY() {
        return y;
    }

    /**
     * This sets the current y-value of this GameObject
     *
     * @param y y-value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * This returns the current velocity of x of this GameObject
     *
     * @return Velocity of x
     */
    public int getVelX() {
        return velX;
    }

    /**
     * This sets the current velocity of x of this GameObject
     *
     * @param velX Velocity of x
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * This returns the current velocity of y of this GameObject
     *
     * @return Velocity of y
     */
    public int getVelY() {
        return velY;
    }

    /**
     * This sets the current velocity of y of this GameObject
     *
     * @param velY Velocity of y
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * This returns the previous x-value of this GameObject
     *
     * @return Previous x-value
     */
    public int getPrevX() {
        return prevX;
    }

    /**
     * This sets the previous x-value of this GameObject
     *
     * @param prevX Previous x-value
     */
    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    /**
     * This returns the previous y-value of this GameObject
     *
     * @return Previous y-value
     */
    public int getPrevY() {
        return prevY;
    }

    /**
     * This sets the previous y-value of this GameObject
     *
     * @param prevY Previous y-value
     */
    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    /**
     * This returns the ID of this GameObject
     *
     * @return ID
     */
    public ID getId() {
        return id;
    }

    /**
     * This sets the ID of this GameObject
     *
     * @param id ID
     */
    public void setId(ID id) {
        this.id = id;
    }

}
