package ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*读图*/
public class GetImg {
    public static BufferedImage getImg(String name){
        BufferedImage image = null;
        try {
            image = ImageIO.read(GetImg.class.getResource("/img/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
