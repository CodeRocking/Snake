package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Snake extends GameObject {
    public static int SnakeX, SnakeY, pastX, pastY;
    public static ArrayList<Snake> snakeBody = new ArrayList<Snake>();


    public Snake(int x, int y, ID id) {
        super(x, y, id);
        SnakeX = x;
        SnakeY = y;
        snakeBody.add(null);
    }

    @Override
    public void tick() {
        pastX = x;
        pastY = y;
        x += velX;
        y += velY;
        SnakeX = x;
        SnakeY = y;
        //  if(snakeBody.size()==0){
//            snakeBody.add();
//        }
        Snake tempSnake = new Snake(x, y, ID.Snake);
        snakeBody.set(0, tempSnake);

        // System.out.println(snakeBody.get(0).y);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);
    }

}
