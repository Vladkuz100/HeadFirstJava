package Chapter13;


import javax.swing.*;
import java.awt.*;

public class Panel_1 {
    public static void main(String[] args) {
        Panel_1 gui = new Panel_1();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);

        JButton button = new JButton("click me");
        panel.add(button);
//
//        Font bigFont = new Font("serif", Font.BOLD, 28);
//        button.setFont(bigFont);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
