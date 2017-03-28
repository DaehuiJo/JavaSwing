package Transh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JLabelTransparent {

    public static void main(String[] args) {
        new JLabelTransparent();
    }

    public JLabelTransparent() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    TranslucentLabel label = new TranslucentLabel("This is a translucent label");
                    label.setBackground(new Color(255, 0, 0, 128));
                    label.setForeground(Color.WHITE);

                    JLabel background = new JLabel();
                    background.setIcon(new ImageIcon(ImageIO.read(new File("Images/LIbrary.jpg"))));
                    background.setLayout(new GridBagLayout());
                    background.add(label);

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(background);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public class TranslucentLabel extends JLabel {

        public TranslucentLabel(String text, Icon icon, int horizontalAlignment) {
            super(text, icon, horizontalAlignment);
        }

        public TranslucentLabel(String text, int horizontalAlignment) {
            super(text, horizontalAlignment);
        }

        public TranslucentLabel(String text) {
            super(text);
        }

        public TranslucentLabel(Icon image, int horizontalAlignment) {
            super(image, horizontalAlignment);
        }

        public TranslucentLabel(Icon image) {
            super(image);
        }

        public TranslucentLabel() {
            super();
        }

        @Override
        public boolean isOpaque() {
            return false;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g2d);
            g2d.dispose();
        }
    }
}