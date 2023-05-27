import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineTurn {
    // Don't touch the code below
    static int WIDTH = 640;
    static int HEIGHT = 640;

    public static void drawImage(Graphics graphics) {

        Graphics2D g2 = (Graphics2D) graphics;

        int iter = 3;
        double xInt = 320;
        double yInt = 320;
        double side = 20;
        double angle = Math.PI/6;
        double circle = 360.0d;
        double c = Math.sqrt(3);


        for (int h = 1; h <= iter; h++) {


            for (int i = 0; i < 6; i++) {

                for (int j = 1; j <= h; j++) {


                    int[] xPoints = new int[6];
                    int[] yPoints = new int[6];

                    int k = 0;
                    for (double angleS = 0.0d; angleS < circle; angleS += circle / 6) {
                        xPoints[k] = (int) (xInt + side * Math.cos(Math.toRadians(angleS)));
                        yPoints[k] = (int) (yInt + side * Math.sin(Math.toRadians(angleS)));
                        k += 1;
                    }
                    g2.draw(new Polygon(xPoints, yPoints, 6));
                    xInt = xInt + c * side * Math.cos(angle);
                    yInt = yInt + c * side * Math.sin(angle);
                }
                angle += Math.PI / 3;
            }
            yInt -= side*c;
        }

    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}