package ui;

import java.awt.image.BufferedImage;

public class Fire {
    BufferedImage image;
    int x;
    int y;

    public Fire(Plane plane) {
        image = GetImg.getImg("fire.png");
        x = plane.x + plane.image.getWidth() / 2 - image.getWidth() / 4 / 2;
        y = plane.y - image.getHeight() / 4 / 2;
    }


}
