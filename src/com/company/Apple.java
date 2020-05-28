//Names: Neil Agrawal, Johnathan Tong, and Faraz
package com.company;

import java.awt.*;

public class Apple extends GameObject {

    public Apple(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);
    }

}
