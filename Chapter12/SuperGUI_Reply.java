package Chapter12;

import javax.swing.*;
import java.awt.event.*;

public class SuperGUI_Reply implements ActionListener{

    JButton button;
    public static int n = 0;
    public static void main(String[] args) {
        SuperGUI_Reply gui = new SuperGUI_Reply();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click me");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window -> program close
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed( ActionEvent event){
        button.setText("I've been clicked " + n +" times!");
        n++;
    }
}
