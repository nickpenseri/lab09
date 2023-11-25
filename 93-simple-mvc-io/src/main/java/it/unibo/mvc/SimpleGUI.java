package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first Java Graphical interface");
    private static final int PROPORTION = 5;


    private SimpleGUI(final Controller viewController) {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        panel1.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    viewController.writeString(text.getText());
                } catch (IOException exc) {
                    System.out.println("could not open file");
                }
            }
            
        });
        panel1.add(save, BorderLayout.SOUTH);
        frame.getContentPane().add(panel1);
    }

    private void display(){
        final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int windowWidth = (int) screenDimension.getWidth() / PROPORTION;
        final int windowHeigth = (int) screenDimension.getHeight() / PROPORTION;
        frame.setSize(windowWidth, windowHeigth);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUI(new Controller()).display();
    }

}
