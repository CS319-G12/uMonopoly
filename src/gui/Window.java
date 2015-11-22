package src.gui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by anikristo on 22-Nov-15.
 */
public class Window extends JFrame implements WindowListener {


    // CONSTRUCTOR
    public Window() {
        super("µMonopoly");
        setSize(1152, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new HomeScreen().getContent());

        setVisible(true);
    }


    // METHODS
    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
