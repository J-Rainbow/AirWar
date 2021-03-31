package ui;

import java.awt.image.BufferedImage;

/*飞机的图*/
public class Plane {

    BufferedImage image;
    int x;
    int y;

    public Plane() {
        image = GetImg.getImg("hero.png");
        x = 200;
        y = 500;
    }
    //单例模式
    private static class HolderClass{
        private final static Plane instance = new Plane();
    }

    public static Plane getInstance(){
        return HolderClass.instance;
    }
}
