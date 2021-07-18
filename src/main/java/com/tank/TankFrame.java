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

    int x = 200;
    int y = 200;

    public TankFrame() {
        // 设置窗口长宽
        setSize(800, 600);
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
        // 画出一个黑色方块
        g.fillRect(x, y, 50, 50);

    }

    /**
     * 处理键盘事件
     */
    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            x += 50;
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
