package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;

    private final JFrame frame = new JFrame("94-mvc-io");

    private SimpleGUI(SimpleController ctrlr) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JTextField upperField = new JTextField();
        mainPanel.add(upperField, BorderLayout.NORTH);
        final JTextArea centerArea = new JTextArea();
        centerArea.setEditable(false);
        mainPanel.add(centerArea, BorderLayout.CENTER);
        final JPanel southPanel = new JPanel(new BorderLayout());
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        southPanel.add(print, BorderLayout.NORTH);
        southPanel.add(showHistory, BorderLayout.SOUTH);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ctrlr.setString(upperField.getText());
                ctrlr.printCurrent();
            }
            
        });
        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                centerArea.setText(ctrlr.getHistory().toString());
            }
            
        });
        frame.getContentPane().add(mainPanel);

    }


    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension frameSize =  new Dimension();
        frameSize.setSize(screen.getWidth()/PROPORTION, screen.getHeight()/PROPORTION);
        frame.setSize(frameSize);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUI(new SimpleController()).display();;
    }
}
