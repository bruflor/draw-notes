package swingpaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPaint {
    JButton clearBtn, blackBtn, blueBtn, greenBtn,redBtn, magentaBtn;
    DrawArea drawArea;
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == clearBtn) {
                drawArea.clear();
            }else if(e.getSource() == blackBtn) {
                drawArea.black();
            }else if(e.getSource() == blueBtn) {
                drawArea.blue();
            }else if(e.getSource() == greenBtn) {
                drawArea.green();
            }else if(e.getSource() == magentaBtn) {
                drawArea.magenta();
            }else if (e.getSource() == redBtn) {
                drawArea.red();
            }
        }
    };

    public static void main(String[] args) {
        new SwingPaint().show();
    }

    public void show(){
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();

        content.setLayout(new BorderLayout());
        drawArea  = new DrawArea();

        content.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);

        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);

        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionListener);

        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionListener);

        magentaBtn = new JButton("Magenta");
        magentaBtn.addActionListener(actionListener);

        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);

        controls.add(clearBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(magentaBtn);
        controls.add(greenBtn);
        controls.add(redBtn);

        content.add(controls, BorderLayout.NORTH);

        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
