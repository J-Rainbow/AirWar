package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/*���*/
public class Panel extends JPanel {
    //�����������һ��ͼ
    BufferedImage bg = GetImg.getImg("bg5.jpg");
    //Plane plane = new Plane();
    Plane plane = Plane.getInstance();
    //EnemyPlane enemyPlane = new EnemyPlane();
    List<EnemyPlane> enemyPlaneList = new ArrayList<EnemyPlane>();

    //�л�
    public void begin(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    epCreate();//����
                    epMove();//�ƶ�
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        }.start();
    }

    //ÿ��20�������ǰ��10������
    private void epMove() {
        for (int i = 0; i <enemyPlaneList.size(); i++) {
            EnemyPlane enemyPlane = enemyPlaneList.get(i);
            enemyPlane.y = enemyPlane.y + 10;
        }
    }

    int anInt = 0;
    private void epCreate() {
        anInt++;
        if (anInt>=20) {
            EnemyPlane enemyPlane = new EnemyPlane();
            enemyPlaneList.add(enemyPlane);
            anInt = 0;
        }
    }

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
                if (plane.x >= 512) {
                    plane.x = 512;
                }
                if (plane.y >= 768){
                    plane.y = 768;
                }
                repaint();//����
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
        //g.drawImage(enemyPlane.image,enemyPlane.x,enemyPlane.y,null); ��һ�ܵл�
        for (int i = 0; i < enemyPlaneList.size(); i++) {
            EnemyPlane enemyPlane = enemyPlaneList.get(i);
            g.drawImage(enemyPlane.image,enemyPlane.x,enemyPlane.y,null);
        }
    }
}
