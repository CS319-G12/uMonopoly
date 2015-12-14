package gui;

import models.squares.TownSquare;
import models.token.TokenFigure;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
public class TTownSquareView extends SquareView {

    // ATTRIBUTES
    private JLabel firstHouseLb;
    private JLabel secondHouseLb;
    private JLabel thirdHouseLb;
    private JLabel fourthHouseLb;
    private JLabel firstTokenLb;
    private JLabel secondTokenLb;
    private JLabel thirdTokenLb;
    private JLabel fourthTokenLb;
    private ImageIcon houseIcon;
    private ImageIcon hotelIcon;

    // CONSTRUCTOR
    public TTownSquareView(TownSquare square) {
        this.houseIcon = new ImageIcon(getClass().getResource("/img/house.png"));
        this.hotelIcon = new ImageIcon(getClass().getResource("/img/hotel.png"));

        // House labels
        firstHouseLb = new JLabel();
        secondHouseLb = new JLabel();
        thirdHouseLb = new JLabel();
        fourthHouseLb = new JLabel();

        // Color panel
        JPanel colorPn = new JPanel(new GridLayout(1, 4, 0, 0));
        colorPn.setMinimumSize(new Dimension(60, 24));
        colorPn.setMaximumSize(new Dimension(60, 24));
        colorPn.setPreferredSize(new Dimension(60, 24));
        colorPn.setBackground(square.getColor().awtColor());
        colorPn.add(firstHouseLb);
        colorPn.add(secondHouseLb);
        colorPn.add(thirdHouseLb);
        colorPn.add(fourthHouseLb);

        // Token labels
        firstTokenLb = new JLabel();
        secondTokenLb = new JLabel();
        thirdTokenLb = new JLabel();
        fourthTokenLb = new JLabel();

        // Token panel
        JPanel tokenPn = new JPanel(new GridLayout(2, 2, 0, 0));
        tokenPn.setMinimumSize(new Dimension(60, 60));
        tokenPn.setMaximumSize(new Dimension(60, 60));
        tokenPn.setPreferredSize(new Dimension(60, 60));
        tokenPn.setBackground(Color.BACKGROUND.awtColor());
        tokenPn.add(firstTokenLb);
        tokenPn.add(secondTokenLb);
        tokenPn.add(thirdTokenLb);
        tokenPn.add(fourthTokenLb);

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(60, 95));
        setMaximumSize(new Dimension(60, 95));
        setPreferredSize(new Dimension(60, 95));
        add(colorPn, BorderLayout.SOUTH);
        add(tokenPn, BorderLayout.CENTER);

    }

    // METHODS
    public void addHouse() throws SquareView.SquareFullException {
        if (firstHouseLb.getIcon() == null)
            firstHouseLb.setIcon(houseIcon);
        else if (secondHouseLb.getIcon() == null)
            secondHouseLb.setIcon(houseIcon);
        else if (thirdHouseLb.getIcon() == null)
            thirdHouseLb.setIcon(houseIcon);
        else if (fourthHouseLb.getIcon() == null)
            fourthHouseLb.setIcon(houseIcon);
        else
            throw new SquareView.SquareFullException();
    }

    public void removeHouse() throws SquareView.InvalidHouseRemovalException {
        if (fourthHouseLb.getIcon() != null)
            fourthHouseLb.setIcon(null);
        else if (thirdHouseLb.getIcon() != null)
            thirdHouseLb.setIcon(null);
        else if (secondHouseLb.getIcon() != null)
            secondHouseLb.setIcon(null);
        else if (firstHouseLb.getIcon() != null)
            firstHouseLb.setIcon(null);
        else
            throw new SquareView.InvalidHouseRemovalException();
    }

    public void addHotel() {
        firstHouseLb.setIcon(hotelIcon);
        secondHouseLb.setIcon(null);
        thirdHouseLb.setIcon(null);
        fourthHouseLb.setIcon(null);
    }

    public void removeHotel() {
        firstHouseLb.setIcon(null);
    }

    public void addTokenFigure(TokenFigure figure) throws SquareView.SquareFullException {
        if (firstTokenLb.getIcon() == null)
            firstTokenLb.setIcon(figure.getIcon());
        else if (secondTokenLb.getIcon() == null)
            secondTokenLb.setIcon(figure.getIcon());
        else if (thirdTokenLb.getIcon() == null)
            thirdTokenLb.setIcon(figure.getIcon());
        else if (fourthTokenLb.getIcon() == null)
            fourthTokenLb.setIcon(figure.getIcon());
        else
            throw new SquareView.SquareFullException();
    }

    public void removeTokenFigure(TokenFigure figure) throws SquareView.InvalidTokenRemovalException {
        if (firstTokenLb.getIcon() != null)
            firstTokenLb.setIcon(null);
        else if (secondTokenLb.getIcon() != null)
            secondTokenLb.setIcon(null);
        else if (thirdTokenLb.getIcon() != null)
            thirdTokenLb.setIcon(null);
        else if (fourthTokenLb.getIcon() != null)
            fourthTokenLb.setIcon(null);
        else
            throw new SquareView.InvalidTokenRemovalException();
    }
}
