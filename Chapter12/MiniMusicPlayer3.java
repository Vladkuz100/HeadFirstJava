package Chapter12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

// this one plays random music with it, but only because there is a listener.

public class MiniMusicPlayer3 {

    static JFrame frame = new JFrame("My First Music Video");
    static MyDrawPanel myDrawPanel;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }


    public  void setUpGui() {
        myDrawPanel = new MyDrawPanel();
        frame.setContentPane(myDrawPanel);
        frame.setBounds(30,30, 300,300);
        frame.setVisible(true);
    }


    public void go() {
        setUpGui();

        try {

            // make (and open) a sequencer, make a sequence and track

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequencer.addControllerEventListener(myDrawPanel, new int[] {127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // now make two midi events (containing a midi message)

            int r = 0;
            for (int i = 0; i < 6000000; i+= 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144,1,r,100,i));
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,r,100,i + 2));
            } // end loop

            // add the events to the track
            // add the sequence to the sequencer, set timing, and start

            sequencer.setSequence(seq);

            sequencer.start();
            sequencer.setTempoInBPM(360000);
        } catch (Exception ex) {ex.printStackTrace();}
    } // close go


    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) { //OLD
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);

        }catch(Exception e) { }
        return event;
    }



    class MyDrawPanel extends JPanel implements ControllerEventListener {  //OLD

        // only if we got an event do we want to paint
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {

                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r,gr,b));

                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x,y,ht, width);
                msg = false;

            } // close if
        } // close method
    }  // close inner class

} // close class