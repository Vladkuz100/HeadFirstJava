package Chapter12;

import javax.swing.*;


public class SimpleGUI {
    public static void main(String[] args) {


            JFrame frame = new JFrame();
            //JButton button = new JButton("click me");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window -> program close

            //frame.getContentPane().add(button);
        while ( true) {
            MyDrawPannel drawPannel = new MyDrawPannel();
            frame.getContentPane().add(drawPannel);

            frame.setSize(400, 400);
            frame.setVisible(true);
            try {
                Thread.sleep(1);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }
}
