package swingpaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawArea extends JComponent {

    private Image image; // image canvas we draw in
    private Graphics2D g2; // graphic object to draw on
    private int currentX, currentY, oldX, oldY; //mouse coordinates

    public DrawArea() {
        setDoubleBuffered(false);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                //draw line if g2 context not null
                if(g2 != null){
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if(image == null){
            image = createImage(getWidth(), getHeight());
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.BLACK);
        repaint();
    }

    public void red(){
        g2.setPaint(Color.RED);
    }
    public void black(){
        g2.setPaint(Color.BLACK);
    }
    public void magenta(){
        g2.setPaint(Color.MAGENTA);
    }
    public void green(){
        g2.setPaint(Color.GREEN);
    }
    public void blue(){
        g2.setPaint(Color.BLUE);
    }
}
