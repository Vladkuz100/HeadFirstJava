package Chapter13;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;


public class Button_1 {
    public static void main(String[] args) {
        Button_1 gui = new Button_1();
        gui.go();

    }

    public void go(){
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);

        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(200,200);
        frame.setVisible(true);


    }

}
