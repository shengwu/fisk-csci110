import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 */
public class Music {

    // Change this to change how your notes sound
    private static final int NOTE_VELOCITY = 70;

    // The song you'll be composing. Consists of 1024 sixteenth notes
    // by default.
    private static final int SONG_LEN = 1024;
    private static int[] song = new int[SONG_LEN];
    // TODO: allow multiple tracks (3)?

    // Increase the beats per minute to determine how fast the song goes
    private static final int BPM = 90;
    private static final int MS_BETWEEN_SIXTEENTH_NOTES = 1000 * 60 / BPM / 4;

    /**
     * The two functions getPartA and getPartB are two examples
     * of functions that return a random piece of music.
     *
     * getPartA has two possibiliites
     * getPartB has three possibilities
     *
     * so there are six possible songs generated
     */
    static void playSong(MidiChannel[] mc) throws InterruptedException {
        int endOfSong;
        // Finds the end of the song
        for (endOfSong = SONG_LEN-1;
                endOfSong >= 0 && song[endOfSong] == -1;
                endOfSong--) {}
        if (endOfSong == 0) {
            // no notes have been added; nothing to do
            return;
        }

        // Play all of the notes
        System.out.println(MS_BETWEEN_SIXTEENTH_NOTES);
        System.out.println(endOfSong);
        mc[0].noteOn(song[0], NOTE_VELOCITY);
        for (int i = 1; i <= endOfSong; i++) {
            mc[0].noteOff(song[i-1], NOTE_VELOCITY);
            if (song[i] != -1) {
                mc[0].noteOn(song[i], NOTE_VELOCITY);
            }
            /*
                mc[5].noteOn(60,60);
                mc[5].noteOn(64,60);
                mc[5].noteOn(67,60);
                */
            Thread.sleep(MS_BETWEEN_SIXTEENTH_NOTES);
        }

        // Let the song finish
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws Exception {
        Arrays.fill(song, -1);

        // COMPOSE YOUR SONG HERE
        //
        // TIP: WRITE FUNCTIONS THAT GENERATE SEQUENCES OF NOTES

        song[0] = 60;
        song[1] = 61;
        song[2] = 62;
        song[3] = 63;
        song[4] = 64;




        // Plays the music composed above. You don't need to change this part.
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
        // index 29 is an overdriven electric guitar on my system
        synth.loadInstrument(instr[10]);
        final MidiChannel[] mc = synth.getChannels();


        playSong(mc);

        /*
        // Display the window
        JFrame frame = new JFrame("CSCI 110 Music Lab");
        JPanel pane = new JPanel();
        JButton button1 = new JButton("Play song");
        Border padding = BorderFactory.createEmptyBorder(40, 40, 40, 40);
        pane.setBorder(padding);
        frame.getContentPane().add(pane);
        button1.setPreferredSize(new Dimension(200, 120));
        button1.setFont(new Font("Helvetica", Font.BOLD, 30));
        pane.add(button1);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    playSong(mc);
                } catch (InterruptedException ex) {
                    // Quit
                    System.exit(0);
                }
            }});
            */

    }
}
