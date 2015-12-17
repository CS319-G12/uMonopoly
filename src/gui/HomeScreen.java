package gui;

import javax.swing.*;
import java.util.Observable;

/**
 * @author Ani Kristo
 */
class HomeScreen extends Observable {

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
            setChanged();
            notifyObservers(Window.NotificationMsg.PLAY_REG);
        });

        highScores.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers(Window.NotificationMsg.HIGH_SCORES);
        });

        help.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers(Window.NotificationMsg.HELP);
        });

        quit.addActionListener(e -> {
            setChanged();
            notifyObservers(Window.NotificationMsg.QUIT);
        });

    }

    // METHODS
    JPanel getContent() {
        return content;
    }
}
