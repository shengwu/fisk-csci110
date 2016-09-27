import java.awt.*;

public class Face {
    static void drawFace(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(10, 30, 100, 100);
        g.setColor(Color.BLUE);
        g.fillOval(30, 60, 20, 20);
        g.fillOval(70, 60, 20, 20);
        g.setColor(Color.RED);
        g.drawLine(40, 100, 80, 100);
    }

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(320, 180);
        Graphics g = panel.getGraphics();

        drawFace(g);
    }
}
