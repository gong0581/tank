package com.tank;

import java.awt.*;

/**
 * @ClassName Bullet 子弹类
 * @Description
 * @AUthor gongshihui
 * @Date 2021/07/19 22:15:09
 **/
public class Bullet {

    // 速度
    private static final int SPEED = 10;

    private int x, y;

    private static final int HEIGHT = 10;

    private static final int WIDTH = 10;

    private DirectionEnum direction;

    public Bullet(int x, int y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);
        graphics.fillOval(x, y, WIDTH, HEIGHT);
        graphics.setColor(color);
        move();
    }

    private void move() {
        switch (direction) {
            case UP:
                y -= SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;

        }
    }

}
