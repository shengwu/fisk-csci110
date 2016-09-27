import java.awt.Color;
import java.awt.Graphics;

public class RectanglesSolution {
    public static void main(String[] args) {
        // Creates a frame of width 600 and height 400
        int width = 600;
        int height = 400;
        DrawingPanel panel = new DrawingPanel(600, 400);

        // You'll need to get a Graphics object to draw on your panel
        Graphics g = panel.getGraphics();

        // Start drawing magenta things
        g.setColor(Color.MAGENTA);

        // Draw the rectangles
        int margin = 40;
        int xStep = (width - margin) / 11;
        int yStep = (height - margin) / 4;
        for (int i = 0; i < width - 2 * margin; i += xStep) {
            for (int j = 0; j < height - margin; j += yStep) {
                g.drawRect(margin/2 + i, margin/2 + j, 40, 40);
            }
        }
    }
}
