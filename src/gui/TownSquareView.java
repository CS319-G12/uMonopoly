package gui;

import models.squares.TownSquare;
import models.token.TokenFigure;

import javax.swing.*;

/**
 * @author anikristo
 */
public class TownSquareView implements SquareView {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel nameLb;
    private JPanel colorPn;
    private JLabel firstHouseLb;
    private JLabel secondHouseLb;
    private JLabel thirdHouseLb;
    private JLabel fourthHouseLb;
    private JPanel tokenPn;

    private JLabel firstTokenLb;
    private JLabel secondTokenLb;
    private JLabel thirdTokenLb;
    private JLabel fourthTokenLb;

    private ImageIcon houseIcon;
    private ImageIcon hotelIcon;

    // CONSTRUCTOR
    public TownSquareView(TownSquare square) {
        super();

        this.houseIcon = new ImageIcon(getClass().getResource("/img/house_icon"));
        this.hotelIcon = new ImageIcon(getClass().getResource("/img/hotel_icon"));

        colorPn.setBackground(square.getColor().awtColor());
        nameLb.setText(square.getName());

    }

    // METHODS
    public JPanel getContent() {
        return mainPanel;
    }

    public void addHouse() throws SquareFullException {
        if (firstHouseLb.getIcon() == null)
            firstHouseLb.setIcon(houseIcon);
        else if (secondHouseLb.getIcon() == null)
            secondHouseLb.setIcon(houseIcon);
        else if (thirdHouseLb.getIcon() == null)
            thirdHouseLb.setIcon(houseIcon);
        else if (fourthHouseLb.getIcon() == null)
            fourthHouseLb.setIcon(houseIcon);
        else
            throw new SquareFullException();
    }

    public void removeHouse() throws InvalidHouseRemovalException {
        if (fourthHouseLb.getIcon() != null)
            fourthHouseLb.setIcon(null);
        else if (thirdHouseLb.getIcon() != null)
            thirdHouseLb.setIcon(null);
        else if (secondHouseLb.getIcon() != null)
            secondHouseLb.setIcon(null);
        else if (firstHouseLb.getIcon() != null)
            firstHouseLb.setIcon(null);
        else
            throw new InvalidHouseRemovalException();
    }

    public void addTokenFigure(TokenFigure figure) throws SquareFullException {
        if (firstTokenLb.getIcon() == null)
            firstTokenLb.setIcon(figure.getIcon());
        else if (secondTokenLb.getIcon() == null)
            secondTokenLb.setIcon(figure.getIcon());
        else if (thirdTokenLb.getIcon() == null)
            thirdTokenLb.setIcon(figure.getIcon());
        else if (fourthTokenLb.getIcon() == null)
            fourthTokenLb.setIcon(figure.getIcon());
        else
            throw new SquareFullException();
    }

    public void removeTokenFigure(TokenFigure figure) throws InvalidTokenRemovalException {
        if (firstTokenLb.getIcon() != null)
            firstTokenLb.setIcon(null);
        else if (secondTokenLb.getIcon() != null)
            secondTokenLb.setIcon(null);
        else if (thirdTokenLb.getIcon() != null)
            thirdTokenLb.setIcon(null);
        else if (fourthTokenLb.getIcon() != null)
            fourthTokenLb.setIcon(null);
        else
            throw new InvalidTokenRemovalException();
    }

    public static class InvalidHouseRemovalException extends Exception {
    }
}
