import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class Music {

    // Increase to make your song faster, decrease to make it slower
    private static final int BPM = 90;



    // DO NOT TOUCH BELOW THIS LINE
    // ----------------------------
    private static final Random random = new Random();

    // Change this to change how your notes sound
    private static final int NOTE_VELOCITY = 70;

    // The song you'll be composing. Consists of 1024 sixteenth notes
    // by default.
    private static final int SONG_LEN = 1024;
    private static int[] notes = new int[SONG_LEN];
    private static int[] rhythm = new int[SONG_LEN];

    // Increase the beats per minute to determine how fast the song goes
    private static final int MS_BETWEEN_SIXTEENTH_NOTES = 1000 * 60 / BPM / 4;

    private static int getEndOfSong() {
        // Finds the end of the song
        int endOfSong;
        for (endOfSong = SONG_LEN-1;
                endOfSong >= 0
                    && notes[endOfSong] == -1
                    && rhythm[endOfSong] == -1;
                endOfSong--) {}
        return endOfSong;
    }

    private static void notesOn(MidiChannel[] mc, int i) {
        if (notes[i] != -1) {
            mc[0].noteOn(notes[i], NOTE_VELOCITY);
        }
        if (rhythm[i] != -1) {
            mc[0].noteOn(rhythm[i], NOTE_VELOCITY);
        }
    }

    private static void notesOff(MidiChannel[] mc, int i) {
        if (i < 0) {
            return;
        }
        if (notes[i] != -1) {
            mc[0].noteOff(notes[i], NOTE_VELOCITY);
        }
        if (rhythm[i] != -1) {
            mc[0].noteOff(rhythm[i], NOTE_VELOCITY);
        }
    }

    static void playSong(MidiChannel[] mc) throws InterruptedException {
        int endOfSong = getEndOfSong();
        if (endOfSong == 0) {
            // no notes have been added; nothing to do
            return;
        }

        // Play all of the notes
        for (int i = 0; i <= endOfSong; i++) {
            notesOff(mc, i-1);
            notesOn(mc, i);
            Thread.sleep(MS_BETWEEN_SIXTEENTH_NOTES);
        }

        // Let the song finish
        Thread.sleep(1000);
    }

    // ----------------------------
    // DO NOT TOUCH ABOVE THIS LINE



    // TODO
    // TODO
    // TODO
    //
    // LAB 11: WRITE FUNCTIONS HERE TO GENERATE RANDOM MUSIC
    //
    // This example generates 20 notes worth of random music.
    //
    // The lowest note is 0. The highest note is 127.
    // 60 is middle C. Notes go up by half steps.

    static int getRandomNote() {
        // Generates a random note between 40 and 79
        return random.nextInt(40) + 40;
    }

    // The number of half steps to add for each note
    private static int[] scale = {0, 2, 4, 5, 7, 9, 11, 12};

    static void addScaleStartingAtTime(int t) {
        // Adds an ascending scale to 'notes' starting at time 't'
        int startNote = getRandomNote();
        for (int i = 0; i < 8; i++) {
            //notes[i+t] = startNote + scale[i];
            notes[i+t] = getRandomNote();
        }
    }

    static void genRandomScales() {
        // Adds 5 random scales to the music
        for (int i = 0; i < 40; i += 8) {
            addScaleStartingAtTime(i);
        }
    }



    private static int[] warmup = {0, 2, 4, 5, 7, 5, 4, 2};
    static void addWarmUpAt(int start, int t) {
        // Adds an ascending scale to 'notes' starting at time 't'
        for (int i = 0; i < 8; i++) {
            notes[i+t] = start + warmup[i];
        }
        notes[t + 8] = start;
        notes[t + 10] = start + 12;
        notes[t + 12] = start;
    }

    static void vocalWarmUp() {
        int start = 80;
        for (int i = 0; i < 32; i += 16) {
            addWarmUpAt(start, i);
            start++;
        }
    }


    public static void main(String[] args) throws Exception {
        Arrays.fill(notes, -1);
        Arrays.fill(rhythm, -1);

        // TODO TODO TODO
        //
        // COMPOSE YOUR SONG HERE
        //
        // TIP: WRITE FUNCTIONS THAT GENERATE SEQUENCES OF NOTES

        //genRandomScales();

        vocalWarmUp();





        // Here's an example of code you could write to directly set notes.
        //
        // Since 60 is Middle C, this adds the notes C, D, E, F, and G
        // to the first five spots.
        //notes[0] = 60;
        //notes[1] = 62;
        //notes[2] = 64;
        //notes[3] = 65;
        //notes[4] = 67;






        // DO NOT TOUCH
        // ------------

        // Plays the music composed above. You don't need to change this part.
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
        // index 29 is an overdriven electric guitar on my system
        synth.loadInstrument(instr[10]);
        final MidiChannel[] mc = synth.getChannels();

        playSong(mc);
    }
}
