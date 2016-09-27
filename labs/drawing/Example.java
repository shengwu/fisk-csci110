import java.awt.Color;
import java.awt.Graphics;

public class Example {
    public static void main(String[] args) {
        // Creates a frame of width 220 and height 150
        DrawingPanel panel = new DrawingPanel(220, 150);

        // Makes the background yellow
        panel.setBackground(Color.YELLOW);

        // You'll need to get a Graphics object to draw on your panel
        Graphics g = panel.getGraphics();

        // Start drawing blue things
        g.setColor(Color.BLUE);

        // Draw the outline of a blue rectangle
        // The upper left point of the rectangle is at the point (50, 25)
        // The width is 15 and the height is 10
        g.drawRect(50, 25, 15, 10);

        // Start drawing red things
        g.setColor(Color.RED);

        // Draw a solid red oval
        // The upper left point of the oval is at the point (130, 25)
        // The width is 42 and the height is 40
        g.fillOval(130, 25, 42, 40);
    }
}
