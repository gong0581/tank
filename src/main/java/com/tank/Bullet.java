package com.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    public static final int HEIGHT = 20;

    public static final int WIDTH = 20;

    private DirectionEnum direction;

    private Boolean live = true;

    private TankFrame tankFrame;

    public Bullet(int x, int y, DirectionEnum direction, Boolean live, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.live = live;
        this.tankFrame = tankFrame;
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

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics graphics) {
        if (!live) {
            this.tankFrame.bulletList.remove(this);
        }
        BufferedImage image;
        switch (direction) {
            case LEFT:
                image = ResourceMar.bulletL;
                break;
            case RIGHT:
                image = ResourceMar.bulletR;
                break;
            case DOWN:
                image = ResourceMar.bulletD;
                break;
            default:
                image = ResourceMar.bulletU;
                break;
        }
        graphics.drawImage(image, x, y, null);
//        Color color = graphics.getColor();
//        graphics.setColor(Color.RED);
//        graphics.fillOval(x, y, WIDTH, HEIGHT);
//        graphics.setColor(color);
        try {
            move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void move() throws Exception {
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
                throw new Exception("方向错误");
        }
        if (!(this.x >= 0 && this.x <= TankFrame.GAME_WIDTH && this.y >= 0 && this.y <= TankFrame.GAME_HEIGHT)) {
            this.live = false;
        }
    }

}
