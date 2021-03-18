package ui;

import javax.swing.*;
import java.awt.*;
/*框架*/
public class Frame extends JFrame {
    public Frame() throws HeadlessException {
        setTitle("设计模式飞机大战");
        setResizable(false);
        setSize(512,768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//退出关闭程序
        setLocationRelativeTo(null);//居中显示
    }
}