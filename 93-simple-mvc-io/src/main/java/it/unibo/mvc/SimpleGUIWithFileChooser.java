package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame("SimpleGUIWithFileChooser");

    private SimpleGUIWithFileChooser (Controller ctrl) {
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
                    ctrl.writeString(text.getText());
                } catch (IOException exc) {
                    System.out.println("could not open file");
                }
            }
            
        });
        panel1.add(save, BorderLayout.SOUTH);
        frame.getContentPane().add(panel1);
        final JPanel panel2 = new JPanel ();
        panel2.setLayout(new BorderLayout ());
        final JButton browse = new JButton("Browse");
        final JTextField currentFile = new JTextField(ctrl.getFile().getPath());
        currentFile.setEditable(false);
        panel2.add(browse, BorderLayout.EAST);
        panel2.add(currentFile, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.NORTH);
        browse .addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(ctrl.getFile());
                final int result = chooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    ctrl.setFile(chooser.getSelectedFile());
                    currentFile.setText(ctrl.getFile().getPath());
                } else if (result == JFileChooser.CANCEL_OPTION) {

                } else {
                    JOptionPane.showMessageDialog(frame, "An error has occured");
                }
            }
            
        });
        
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
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}