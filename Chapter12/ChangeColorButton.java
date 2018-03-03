package Chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChangeColorButton implements ActionListener {

    JFrame frame;

    public static void main(String[] args) {
        ChangeColorButton gui = new ChangeColorButton();
        gui.go();
    }


    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        MyDrawPannel drawPannel = new MyDrawPannel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPannel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void actionPerformed (ActionEvent event){
        frame.repaint();
    }


}
