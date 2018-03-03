package Chapter11;

import javax.sound.midi.*;
import javax.sound.midi.spi.MidiDeviceProvider;

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp m = new MiniMusicApp();
        m.play();
    }

    public void play(){
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage(); // create message
            a.setMessage(144,1,100,100); // put instruction into method
            MidiEvent noteOn = new MidiEvent(a,1); // create Event
            track.add(noteOn); // add to track

            ShortMessage b = new ShortMessage();
            a.setMessage(128,1,44,100);
            //           message type   channel  nota   speed and force of playing
            MidiEvent noteOff = new MidiEvent(b,300);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
            //System.exit(1);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
