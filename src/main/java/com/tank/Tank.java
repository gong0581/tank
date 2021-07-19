package com.tank;

import java.awt.*;

/**
 * @ClassName Tank
 * @Description
 * @AUthor gongshihui
 * @Date 2021/07/19 21:55:55
 **/
public class Tank {
    private Integer x;
    private Integer y;
    // 方向
    private DirectionEnum direction;
    // 是否移动
    private Boolean moving = false;
    private static final int SPEED = 5;

    public Tank(Integer x, Integer y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public Boolean getMoving() {
        return moving;
    }

    public void setMoving(Boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        // 画出一个黑色方块
        g.fillRect(x, y, 50, 50);
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
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
