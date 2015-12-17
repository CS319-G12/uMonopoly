package gui;

import models.Game;

import javax.swing.*;
import java.util.Observable;

/**
 * @author Ani Kristo
 */
public class GameScreen extends Observable {

    // ATTRIBUTES
    private JPanel mainPn;
    private JPanel centerPn;
    private JPanel rightPn;

    // CONSTRUCTOR
    public GameScreen(Game game) {

        MonopolyBoardView boardView = new MonopolyBoardView(game);
        SidePanel sidePanel = new SidePanel(game);

        centerPn.add(boardView);
        rightPn.add(sidePanel.getContent());
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }

    public void closeWindow(boolean hasGameFinished) {
        setChanged();
        if (hasGameFinished) {
            notifyObservers(Window.NotificationMsg.EXIT_FINISHED);
        } else {
            notifyObservers(Window.NotificationMsg.EXIT_NOT_FINISHED);
        }
    }
}
