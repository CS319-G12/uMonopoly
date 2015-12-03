package gui;

import domain.GameController;
import domain.token.TokenFigure;
import storage.Rules;

import javax.swing.*;
import java.util.*;

/**
 * @author anikristo
 */
public class PlayerRegistrationScreen extends Observable implements Observer {

    // ATTRIBUTES
    private java.util.List<PlayerRegistrationSection> playerRegSections;
    private JPanel mainPanel;
    private JButton backBtn;
    private JButton nextBtn;
    private JPanel northPn;
    private JLabel titleLb;
    private JLabel subTitleLb;
    private JPanel centerPn;
    private JPanel southPn;
    private JButton plusBtn;

    private int shownPlayerSections;

    // CONSTRUCTOR
    public PlayerRegistrationScreen(GameController gameController) {
        super();

        // Fixing North panel alignment
        northPn.setBorder(BorderFactory.createEmptyBorder(15, 34, 34, 0));

        // Declaring LayoutManager for the center panel
        centerPn.setLayout(new BoxLayout(centerPn, BoxLayout.Y_AXIS));

        // Instantiate the sections
        playerRegSections = new ArrayList<>(Rules.MAX_PLAYERS);
        for (int i = 0; i < Rules.MAX_PLAYERS; i++) {
            playerRegSections.add(new PlayerRegistrationSection(i + 1));
            playerRegSections.get(i).addObserver(this);
            centerPn.add(playerRegSections.get(i).getContent());
        }

        // Adding the plus button
        plusBtn = new JButton();
        plusBtn.setBorderPainted(false);
        plusBtn.setContentAreaFilled(false);
        plusBtn.setFocusPainted(false);
        plusBtn.setIcon(new ImageIcon(getClass().getResource("/img/playReg_btn_plus.png")));
        centerPn.add(plusBtn);

        // Adding ActionListeners
        plusBtn.addActionListener(actionEvent -> {


            // Checking if the player has selected a token
            PlayerRegistrationSection currentSection = playerRegSections.get(shownPlayerSections - 1);
            try {
                // Delegate the Player details to the Game Controller
                gameController.createPlayerDetails(currentSection.getName(), currentSection.getTokenFigure());

                currentSection.setError(false, null);
                currentSection.lock();

                playerRegSections.get(shownPlayerSections++).setVisible(true);

                checkTokens();

                if (shownPlayerSections == Rules.MAX_PLAYERS)
                    plusBtn.setEnabled(false);

            } catch (PlayerRegistrationSection.TokenNotSelectedException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.NO_TOKEN_SELECTED);
            } catch (PlayerRegistrationSection.NameNotEnteredException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.NO_NAME_ENTERED);
            } catch (PlayerRegistrationSection.NameNotUniqueException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.NAME_NOT_UNIQUE);
            }

        });
        backBtn.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers(Window.NotificationMsg.BACK);
        });
        nextBtn.addActionListener(actionEvent -> {

            // Checking the last section has a unique name and token
            PlayerRegistrationSection currentSection = playerRegSections.get(shownPlayerSections - 1);
            try {
                gameController.createPlayerDetails(currentSection.getName(), currentSection.getTokenFigure());
                currentSection.setError(false, null);

                gameController.startGame();

            } catch (PlayerRegistrationSection.TokenNotSelectedException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.NO_TOKEN_SELECTED);
            } catch (PlayerRegistrationSection.NameNotEnteredException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.NO_NAME_ENTERED);
            } catch (PlayerRegistrationSection.NameNotUniqueException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.NAME_NOT_UNIQUE);
            } catch (PlayerRegistrationSection.TooFewPlayersException e) {
                playerRegSections.get(shownPlayerSections - 1).setError(true, PlayerRegistrationSection.FEW_PLAYERS);
                try {
                    gameController.removePlayer(currentSection.getName());
                } catch (PlayerRegistrationSection.NameNotEnteredException e1) {
                }
            }
        });

        // making the first section visible
        playerRegSections.get(0).setVisible(true);
        shownPlayerSections = 1;
    }

    // METHODS
    @Override
    public void update(Observable observable, Object o) {
        checkTokens();
    }

    /**
     * Recalculates the disable and enabled tokens
     */
    private void checkTokens() {
        // Finding all the used tokens
        Set<TokenFigure> usedTokens = new HashSet<>(); // TODO change to enum
        for (int i = 0; i < shownPlayerSections; i++) {
            try {
                usedTokens.add(playerRegSections.get(i).getTokenFigure());
            } catch (PlayerRegistrationSection.TokenNotSelectedException e) {
            }
        }

        // Disabling all the used tokens
        TokenFigure[] usedTokensArr = usedTokens.toArray(new TokenFigure[usedTokens.size()]);
        playerRegSections.get(shownPlayerSections - 1).disableTokens(usedTokensArr); // TODO change to enum
    }

    public JPanel getContent() {
        return mainPanel;
    }
}
