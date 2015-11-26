package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by anikristo on 25-Nov-15.
 */
public class PlayerRegistrationSection extends java.util.Observable {

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
    private JLabel errorLb; // TODO add error for unique name

    private boolean isLocked;

    // CONSTRUCTOR
    public PlayerRegistrationSection(int playerNr){

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

        errorLb.setBorder(BorderFactory.createEmptyBorder(10, 30, 50, 0));
        setError(false);

        isLocked = false;
    }

    // METHODS
    public String getName(){
        return nameTf.getText();
    }

    public String getTokenFigure() throws TokenNotSelectedException { // TODO change to enum
        if(dogBtn.isSelected()){
            return "DOG";
//            return TokenFigure.DOG;
        } else if(carBtn.isSelected()){
            return "CAR";
//            return TokenFigure.CAR;
        } else if(shoeBtn.isSelected()){
            return "SHOE";
//            return TokenFigure.SHOE;
        } else if(thimbleBtn.isSelected()){
            return "THIMBLE";
//            return TokenFigure.THIMBLE;
        } else if(hatBtn.isSelected()){
            return "HAT";
//            return TokenFigure.HAT;
        } else if(ironBtn.isSelected()){
            return "IRON";
//            return TokenFigure.IRON;
        }

        throw new TokenNotSelectedException();
    }

    public void setError(boolean error) {
        errorLb.setVisible(error);
    }

    public JPanel getContent(){
        return mainPanel;
    }

    public void setVisible( boolean visible){
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
        isLocked = false;
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
}
