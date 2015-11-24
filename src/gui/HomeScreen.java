package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by anikristo on 22-Nov-15.
 */
public class HomeScreen {

    // ATTRIBUTES
    private JPanel content;
    private JButton start;
    private JButton highScores;
    private JButton help;
    private JButton quit;
    private JLabel title;
    private JLabel credits;
    private JPanel buttons;

    // CONSTRUCTOR
    public HomeScreen() {
        super();

        // Fixing the margins
        title.setBorder(BorderFactory.createEmptyBorder(68, 0, 0, 0));
        credits.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(116, 0, 0, 0));

        // Setting action listeners
        start.addActionListener(actionEvent -> {
            // TODO
        });

        highScores.addActionListener(actionEvent -> {
            // TODO
        });

        help.addActionListener(actionEvent -> {
            // TODO
        });

        quit.addActionListener(e -> {
            // TODO
        });

    }

    // METHODS
    public JPanel getContent() {
        return content;
    }
}
