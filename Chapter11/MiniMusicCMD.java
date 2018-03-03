package Chapter11;

import javax.sound.midi.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MiniMusicCMD {
    public static void main(String[] args) {
        MiniMusicCMD mini = new MiniMusicCMD();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int instrument = Integer.parseInt(br.readLine());
            int nota = Integer.parseInt(br.readLine());
            mini.play(instrument,nota);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void play( int instrument, int nota){
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,instrument,0);
            MidiEvent changeInstrument = new MidiEvent(first,1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage(); // create message
            a.setMessage(144,1,nota,100);
            // put instruction into method
            MidiEvent noteOn = new MidiEvent(a,1); // create Event
            track.add(noteOn); // add to track

            ShortMessage b = new ShortMessage();
            a.setMessage(128,1,nota,100);
            //           message type   channel  nota   speed and force of playing
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
