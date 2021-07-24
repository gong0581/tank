package com.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @ClassName ResourceMar 资源管理
 * @Description
 * @AUthor gongshihui
 * @Date 2021/07/24 16:18:58
 **/
public class ResourceMar {

    public static BufferedImage tankL, tankU, tankR, tankD;

    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    static {
        try {
            tankL = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/tankL.png")));
            tankU = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/tankU.png")));
            tankR = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/tankR.png")));
            tankD = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/tankD.png")));
            bulletL = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/bulletL.png")));
            bulletU = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/bulletU.png")));
            bulletR = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/bulletR.png")));
            bulletD = ImageIO.read(Objects.requireNonNull(ResourceMar.class.getResourceAsStream("/static/images/bulletD.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
