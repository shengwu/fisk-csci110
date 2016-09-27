import java.awt.Color;
import java.awt.Graphics;

public class Rectangles {
    public static void main(String[] args) {
        // Creates a frame of width 600 and height 400
        DrawingPanel panel = new DrawingPanel(600, 400);

        // You'll need to get a Graphics object to draw on your panel
        Graphics g = panel.getGraphics();

        // Start drawing magenta things
        g.setColor(Color.MAGENTA);

        // Draw two purple rectangles
        // TODO: change this to draw a 11 by 4 grid of rectangles
        for (int i = 0; i < 300; i += 80) {
            g.drawRect(50 + i, 25, 40 - i/5, 40);
        }
    }
}
