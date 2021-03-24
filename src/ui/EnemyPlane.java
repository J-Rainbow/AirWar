package ui;

import java.awt.image.BufferedImage;
import java.util.Random;

//敌机
public class EnemyPlane {
    BufferedImage image;
    int x;
    int y;

    public EnemyPlane() {
        Random random = new Random();
        int index = random.nextInt(15) + 1;
        String path = (index<10)?("0"+index):(""+index);
        String name = "ep" + path + ".png";
        image = GetImg.getImg(name);
        y = 0;
        x = random.nextInt(512 - image.getWidth());
    }
}
