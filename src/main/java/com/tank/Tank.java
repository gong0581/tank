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
    private TankFrame tankFrame;

    public static final int MY_TANK_WIDTH = 50;

    public static final int MY_TANK_HEIGHT = 50;

    public Tank(Integer x, Integer y, DirectionEnum direction, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
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

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        // 画出一个黑色方块
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, MY_TANK_WIDTH, MY_TANK_HEIGHT);
        g.setColor(c);
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
            default:
                break;
        }
    }

    public void fire() {
        int xPosition = this.x + (MY_TANK_WIDTH / 2) - (Bullet.WIDTH / 2);
        int yPosition = this.y + (MY_TANK_HEIGHT / 2) - (Bullet.HEIGHT / 2);
        tankFrame.bulletList.add(new Bullet(xPosition, yPosition, this.direction, true, this.tankFrame));
    }
}
