package gui;

import domain.token.TokenFigure;

import javax.swing.*;
import java.awt.*;

/**
 * Created by anikristo on 25-Nov-15.
 */
public class PlayerRegistrationSection {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JTextField nameTF;
    private JLabel nameLb;
    private JButton dogBtn;
    private JButton carBtn;
    private JButton shoeBtn;
    private JButton thimbleBtn;
    private JButton hatBtn;
    private JButton ironBtn;

    // CONSTRUCTOR
    public PlayerRegistrationSection(int playerNr){

        // Setting the borders of the TF
        nameTF.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        // Set the Player number text
        playerNrLb.setText("Player #" + playerNr);

        // Editing default visibility
        mainPanel.setVisible(false);

        // TODO make sure only one is selected at a time

    }

    // METHODS
    public String getName(){
        return nameTF.getText();
    }

    public TokenFigure getToken() throws TokenNotSelectedException {
        if(dogBtn.isSelected()){
            return TokenFigure.DOG;
        } else if(carBtn.isSelected()){
            return TokenFigure.CAR;
        } else if(shoeBtn.isSelected()){
            return TokenFigure.SHOE;
        } else if(thimbleBtn.isSelected()){
            return TokenFigure.THIMBLE;
        } else if(hatBtn.isSelected()){
            return TokenFigure.HAT;
        } else if(ironBtn.isSelected()){
            return TokenFigure.IRON;
        }

        throw new TokenNotSelectedException();
    }

    private class TokenNotSelectedException extends Throwable {
        @Override
        public String getMessage() {
            return super.getMessage() + "Please make sure you have selected a token!";
        }
    }

    public JPanel getContent(){
        return mainPanel;
    }

    public void setVisible( boolean visible){
        mainPanel.setVisible(visible);
    }
}
