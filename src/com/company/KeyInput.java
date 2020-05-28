//Names: Neil Agrawal, Johnathan Tong, and Faraz
package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class gathers keyboard input
 *
 * @author Neil Agrawal
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean isUpLastPressed;
    private boolean isLeftLastPressed;
    private boolean isDownLastPressed;
    private boolean isRightLastPressed;

    /**
     * This constructs a KeyInput object from the Game Handler
     * @param handler Handler for the game
     */
    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    /**
     * This decides what to do when a key is pressed (when a KeyEvent occurs)
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject : handler.objects) {
            if (tempObject.getId() == ID.Snake) {
                if ((key == KeyEvent.VK_W || key == KeyEvent.VK_UP) && !isDownLastPressed) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(-1);
                    isUpLastPressed = true;
                    isLeftLastPressed = false;
                    isDownLastPressed = false;
                    isRightLastPressed = false;
                } else if ((key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) && !isRightLastPressed) {
                    tempObject.setVelX(-1);
                    tempObject.setVelY(0);
                    isUpLastPressed = false;
                    isLeftLastPressed = true;
                    isDownLastPressed = false;
                    isRightLastPressed = false;
                } else if ((key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) && !isUpLastPressed) {
                    tempObject.setVelX(0);
                    tempObject.setVelY(1);
                    isUpLastPressed = false;
                    isLeftLastPressed = false;
                    isDownLastPressed = true;
                    isRightLastPressed = false;
                } else if ((key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) && !isLeftLastPressed) {
                    tempObject.setVelX(1);
                    tempObject.setVelY(0);
                    isUpLastPressed = false;
                    isLeftLastPressed = false;
                    isDownLastPressed = false;
                    isRightLastPressed = true;
                }
            }
        }
    }
}
