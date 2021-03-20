package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*面板*/
public class Panel extends JPanel {
    //背景本身就是一张图
    BufferedImage bg = GetImg.getImg("bg5.jpg");
    Plane plane = new Plane();

    public Panel(Frame frame) {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                plane.x = e.getX() - plane.image.getWidth() / 2;
                plane.y = e.getY() - plane.image.getHeight() / 2;
                if (plane.x <= 0){
                    plane.x = 0;
                }
                if (plane.y <= 0){
                    plane.y = 0;
                }
                repaint();//更新
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_LEFT || i == KeyEvent.VK_A){
                    plane.x = plane.x - 10;
                }else if (i == KeyEvent.VK_RIGHT || i == KeyEvent.VK_D){
                    plane.x = plane.x + 10;
                }else if (i == KeyEvent.VK_UP || i == KeyEvent.VK_W){
                    plane.y = plane.y - 10;
                }else if (i == KeyEvent.VK_DOWN || i == KeyEvent.VK_S){
                    plane.y = plane.y + 10;
                }
                repaint();
            }
        };
        frame.addKeyListener(keyAdapter);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg,0,0,null);
        g.drawImage(plane.image,plane.x,plane.y,null);
    }
}
