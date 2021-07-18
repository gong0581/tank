package com.tank;


import java.awt.*;

/**
 * @ClassName 坦克大战启动类
 * @Description
 * @AUthor gongshihui
 * @Date 2021/07/18 21:39:38
 **/
public class TankMain {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new TankFrame();
        while (true) {
            Thread.sleep(50);
            // 刷新窗口
            frame.repaint();
        }
    }

}
