package Chapter12;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;

public class MyDrawPannel extends JPanel {
    public void paintComponent( Graphics g){
        //g.setColor(Color.orange);
        //g.fillRect(20,50,100,100);
//        try {
//            Image image2 = ImageIO.read(new FileImageInputStream(new File("resources/images/3x3.jpg")));
//        }
//        catch ( Exception er){
//            er.printStackTrace();
//        }


//        Image image = new ImageIcon("test1.jpeg").getImage();
//        g.drawImage(image,3,4,this);


//        g.fillRect(0,0,this.getWidth(), this.getHeight());
//        int red = (int ) (Math.random()*255);
//        int green = (int ) (Math.random()*255);
//        int blue = (int ) (Math.random()*255);
//        Color randomColor = new Color(red,green,blue);
//        g.setColor(randomColor);
//        g.fillOval(70,70,100,100);


        int red = (int ) (Math.random()*255);
        int green = (int ) (Math.random()*255);
        int blue = (int ) (Math.random()*255);
        Color randomColor1 = new Color(red,green,blue);
        red = (int ) (Math.random()*255);
        green = (int ) (Math.random()*255);
        blue = (int ) (Math.random()*255);
        Color randomColor2 = new Color(red,green,blue);


        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(10,10, randomColor1, 300,300,randomColor2);
        g2d.setPaint(gradient);
        g2d.fillOval(10,10,300,300);

    }
}
