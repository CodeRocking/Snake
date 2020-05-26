package com.company;

import java.awt.*;

import com.company.Game;

import java.util.ArrayList;
import java.util.Random;

import static com.company.Game.newSnake;
import static com.company.Game.newApple;
import static com.company.Snake.snakeBody;
import static com.company.Snake.pastX;
import static com.company.Snake.pastY;


public class Apple extends GameObject {
    public int appleX, appleY;


    public Apple(int x, int y, ID id) {
        super(x, y, id);
        appleX = x;
        appleY = y;

    }

    @Override
    public void tick() {
        int touch = 0;
        if (touch == 1) {
            snakeBody.add(new Snake(pastX, pastY, ID.Snake));
            touch = 0;
        }
//
        if (newApple.x == newSnake.x && newApple.y == newSnake.y) {
            Random rand = new Random();
            int newX = rand.nextInt(17);
            int newY = rand.nextInt(17);
            while (newSnake.x == newX && newSnake.y == newY) {
                newX = rand.nextInt(17);
                newY = rand.nextInt(17);
            }
            newApple.x = newX;
            newApple.y = newY;
            touch = 1;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((x * 32) + 16, (y * 32) + 16, 32, 32);

    }
//    public Apple generatePoint(){
//
//        return
//    }
}

