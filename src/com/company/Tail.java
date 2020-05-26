package com.company;

import java.awt.*;

public class Tail extends GameObject {

    private GameObject leadObject;

    public Tail(GameObject leadObject, ID id) {
        super(leadObject.getPrevX(), leadObject.getPrevY(), id);
        this.leadObject = leadObject;
    }

    @Override
    public void tick() {
        prevX = x;
        prevY = y;
        x = leadObject.getPrevX();
        y = leadObject.getPrevY();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);
    }
}
