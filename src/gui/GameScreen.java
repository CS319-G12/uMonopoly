package gui;

import models.Game;

import javax.swing.*;

/**
 * @author anikristo
 */
public class GameScreen {

    // ATTRIBUTES
    private JPanel mainPn;
    private JPanel centerPn;
    private JPanel rightPn;
    private MonopolyBoardView boardView;
    private SidePanel sidePanel;

    // CONSTRUCTOR
    public GameScreen(Game game) {
        boardView = new MonopolyBoardView(game.getListOfSquares());
        sidePanel = new SidePanel(game.getListOfPlayers());

        centerPn = boardView.getContent();
        rightPn = sidePanel.getContent();
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
