package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName TankFrame 坦克大战窗口
 * @Description
 * @AUthor gongshihui
 * @Date 2021/07/18 21:53:04
 **/
public class TankFrame extends Frame {

    private static final int GAME_WIDTH = 800;

    private static final int GAME_HEIGHT = 600;

    Tank myTank = new Tank(200, 200, DirectionEnum.UP);
    Bullet bullet = new Bullet(300, 300, DirectionEnum.UP);

    public TankFrame() {
        // 设置窗口长宽
        setSize(GAME_WIDTH, GAME_HEIGHT);
        // 设置窗口大小不能改变
        setResizable(false);
        // 设置窗口标题
        setTitle("tank war");

        // 监听键盘按键
        this.addKeyListener(new MyKeyListener());

        // 监听窗口
        addWindowListener(new WindowAdapter() {
            // 关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 窗口设置为可见
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        bullet.paint(g);

    }


    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics offScreen = offScreenImage.getGraphics();
        Color c = offScreen.getColor();
        offScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        offScreen.setColor(c);
        paint(offScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 处理键盘事件
     */
    class MyKeyListener extends KeyAdapter {

        boolean leftFlag = false;
        boolean upFlag = false;
        boolean rightFlag = false;
        boolean downFlag = false;

        @Override
        public void keyPressed(KeyEvent e) {
            // 获取按键的代码
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    leftFlag = true;
                    break;
                case KeyEvent.VK_UP:
                    upFlag = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightFlag = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downFlag = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    leftFlag = false;
                    break;
                case KeyEvent.VK_UP:
                    upFlag = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightFlag = false;
                    break;
                case KeyEvent.VK_DOWN:
                    downFlag = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!leftFlag && !rightFlag && !upFlag && !downFlag) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (leftFlag) myTank.setDirection(DirectionEnum.LEFT);
                if (rightFlag) myTank.setDirection(DirectionEnum.RIGHT);
                if (upFlag) myTank.setDirection(DirectionEnum.UP);
                if (downFlag) myTank.setDirection(DirectionEnum.DOWN);
            }
        }
    }
}
