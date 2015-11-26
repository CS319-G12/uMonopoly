package gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author anikristo
 */
public class PlayerRegistrationSection extends java.util.Observable {

    // CONSTANTS
    final static String NO_TOKEN_SELECTED = "Please select a token!";
    final static String NO_NAME_ENTERED = "Please enter the player's name!";
    final static String NAME_NOT_UNIQUE = "Please enter a unique name!";
    final static String FEW_PLAYERS = "Please register at least two players!";

    // ATTRIBUTES
    private JPanel mainPanel;
    private JTextField nameTf;
    private JLabel nameLb;
    private JButton dogBtn;
    private JButton carBtn;
    private JButton shoeBtn;
    private JButton thimbleBtn;
    private JButton hatBtn;
    private JButton ironBtn;
    private JPanel namePn;
    private JLabel playerNrLb;
    private JPanel content;
    private JLabel errorLb;

    private boolean isLocked;

    // CONSTRUCTOR
    public PlayerRegistrationSection(int playerNr) {

        // Setting the borders of the TF
        nameTf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        // Set the Player number text
        playerNrLb.setText("Player #" + playerNr + ":");

        // Editing default visibility
        mainPanel.setVisible(false);

        // Adding action listeners
        dogBtn.addActionListener(actionEvent -> {
            if (!isLocked) {
                if (dogBtn.isSelected())
                    dogBtn.setSelected(false);
                else {
                    dogBtn.setSelected(true);
                    carBtn.setSelected(false);
                    shoeBtn.setSelected(false);
                    thimbleBtn.setSelected(false);
                    hatBtn.setSelected(false);
                    ironBtn.setSelected(false);
                }
                notifyObservers();
            }
        });
        carBtn.addActionListener(actionEvent -> {

            if (!isLocked) {
                if (carBtn.isSelected())
                    carBtn.setSelected(false);
                else {
                    dogBtn.setSelected(false);
                    carBtn.setSelected(true);
                    shoeBtn.setSelected(false);
                    thimbleBtn.setSelected(false);
                    hatBtn.setSelected(false);
                    ironBtn.setSelected(false);
                }
                notifyObservers();
            }
        });
        shoeBtn.addActionListener(actionEvent -> {

            if (!isLocked) {
                if (shoeBtn.isSelected())
                    shoeBtn.setSelected(false);
                else {
                    dogBtn.setSelected(false);
                    carBtn.setSelected(false);
                    shoeBtn.setSelected(true);
                    thimbleBtn.setSelected(false);
                    hatBtn.setSelected(false);
                    ironBtn.setSelected(false);
                }
                notifyObservers();
            }
        });
        thimbleBtn.addActionListener(actionEvent -> {

            if (!isLocked) {
                if (thimbleBtn.isSelected())
                    thimbleBtn.setSelected(false);
                else {
                    dogBtn.setSelected(false);
                    carBtn.setSelected(false);
                    shoeBtn.setSelected(false);
                    thimbleBtn.setSelected(true);
                    hatBtn.setSelected(false);
                    ironBtn.setSelected(false);
                }
                notifyObservers();
            }
        });
        hatBtn.addActionListener(actionEvent -> {

            if (!isLocked) {
                if (hatBtn.isSelected())
                    hatBtn.setSelected(false);
                else {
                    dogBtn.setSelected(false);
                    carBtn.setSelected(false);
                    shoeBtn.setSelected(false);
                    thimbleBtn.setSelected(false);
                    hatBtn.setSelected(true);
                    ironBtn.setSelected(false);
                }
                notifyObservers();
            }
        });
        ironBtn.addActionListener(actionEvent -> {

            if (!isLocked) {
                if (ironBtn.isSelected())
                    ironBtn.setSelected(false);
                else {
                    dogBtn.setSelected(false);
                    carBtn.setSelected(false);
                    shoeBtn.setSelected(false);
                    thimbleBtn.setSelected(false);
                    hatBtn.setSelected(false);
                    ironBtn.setSelected(true);
                }
                notifyObservers();
            }
        });

        setError(false, null);
        isLocked = false;
    }

    // METHODS
    public String getName() throws NameNotEnteredException {
        String str = nameTf.getText();
        if (!str.isEmpty())
            return str;
        else throw new NameNotEnteredException();
    }

    public String getTokenFigure() throws TokenNotSelectedException { // TODO change to enum
        if (dogBtn.isSelected()) {
            return "DOG";
//            return TokenFigure.DOG;
        } else if (carBtn.isSelected()) {
            return "CAR";
//            return TokenFigure.CAR;
        } else if (shoeBtn.isSelected()) {
            return "SHOE";
//            return TokenFigure.SHOE;
        } else if (thimbleBtn.isSelected()) {
            return "THIMBLE";
//            return TokenFigure.THIMBLE;
        } else if (hatBtn.isSelected()) {
            return "HAT";
//            return TokenFigure.HAT;
        } else if (ironBtn.isSelected()) {
            return "IRON";
//            return TokenFigure.IRON;
        }

        throw new TokenNotSelectedException();
    }

    public void setError(boolean error, String msg) {
        errorLb.setText(msg);
        errorLb.setVisible(error);
    }

    JPanel getContent() {
        return mainPanel;
    }

    public void setVisible(boolean visible) {
        mainPanel.setVisible(visible);
    }

    public void disableTokens(String[] figures) { // TODO change to enum
        for (String figure : figures) {
            if (figure == "DOG")//TokenFigure.DOG)
                dogBtn.setEnabled(false);
            else if (figure == "CAR")//TokenFigure.CAR)
                carBtn.setEnabled(false);
            else if (figure == "SHOE")//TokenFigure.SHOE)
                shoeBtn.setEnabled(false);
            else if (figure == "THIMBLE")//TokenFigure.THIMBLE)
                thimbleBtn.setEnabled(false);
            else if (figure == "HAT")//TokenFigure.HAT)
                hatBtn.setEnabled(false);
            else if (figure == "IRON")//TokenFigure.IRON)
                ironBtn.setEnabled(false);
        }
    }

    public void lock() {
        isLocked = true;
    }

    /**
     * TODO
     */
    class TokenNotSelectedException extends Throwable {
        @Override
        public String getMessage() {
            return super.getMessage() + "Please make sure you have selected a token!";
        }
    }

    /**
     * TODO
     */
    class NameNotEnteredException extends Throwable {
        @Override
        public String getMessage() {
            return super.getMessage() + "Please make sure you have entered a player name!";
        }
    }

    /**
     * TODO
     */
    public static class NameNotUniqueException extends Throwable {
        @Override
        public String getMessage() {
            return super.getMessage() + "Please make sure you have entered a unique name!";
        }
    }

    /**
     * TODO
     */
    public static class TooFewPlayersException extends Throwable {
        @Override
        public String getMessage() {
            return super.getMessage() + "Please make sure you have registered at least two players!";
        }
    }
}
