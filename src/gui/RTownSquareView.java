package gui;

import models.squares.TownSquare;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ani Kristo
 */
class RTownSquareView extends SquareView {

    // ATTRIBUTES
    private JLabel firstHouseLb;
    private JLabel secondHouseLb;
    private JLabel thirdHouseLb;
    private JLabel fourthHouseLb;
    private ImageIcon houseIcon;
    private ImageIcon hotelIcon;

    // CONSTRUCTOR
    public RTownSquareView(TownSquare square) {
        this.houseIcon = new ImageIcon(getClass().getResource("/img/house.png"));
        this.hotelIcon = new ImageIcon(getClass().getResource("/img/hotel.png"));

        // House labels
        firstHouseLb = new JLabel();
        secondHouseLb = new JLabel();
        thirdHouseLb = new JLabel();
        fourthHouseLb = new JLabel();

        // Color panel
        JPanel colorPn = new JPanel(new GridLayout(4, 1, 0, 0));
        colorPn.setMinimumSize(new Dimension(24, 60));
        colorPn.setMaximumSize(new Dimension(24, 60));
        colorPn.setPreferredSize(new Dimension(24, 60));
        colorPn.setBackground(square.getColor().awtColor());
        colorPn.add(firstHouseLb);
        colorPn.add(secondHouseLb);
        colorPn.add(thirdHouseLb);
        colorPn.add(fourthHouseLb);

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
        setMinimumSize(new Dimension(95, 60));
        setMaximumSize(new Dimension(95, 60));
        setPreferredSize(new Dimension(95, 60));
        add(colorPn, BorderLayout.WEST);
        add(tokenPn, BorderLayout.CENTER);

    }

    // METHODS
    public void addHouse() {
        if (firstHouseLb.getIcon() == null)
            firstHouseLb.setIcon(houseIcon);
        else if (secondHouseLb.getIcon() == null)
            secondHouseLb.setIcon(houseIcon);
        else if (thirdHouseLb.getIcon() == null)
            thirdHouseLb.setIcon(houseIcon);
        else if (fourthHouseLb.getIcon() == null)
            fourthHouseLb.setIcon(houseIcon);
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

    public void addHotel() {
        firstHouseLb.setIcon(hotelIcon);
        secondHouseLb.setIcon(null);
        thirdHouseLb.setIcon(null);
        fourthHouseLb.setIcon(null);
    }

    public void removeHotel() {
        firstHouseLb.setIcon(null);
    }
}