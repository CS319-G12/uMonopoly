package gui;

import models.squares.TownSquare;

import javax.swing.*;

/**
 * @author anikristo
 */
public class TownSquareView extends SquareView {

    // ATTRIBUTES
    protected final JLabel firstHouseLb;
    protected final JLabel secondHouseLb;
    protected final JLabel thirdHouseLb;
    protected final JLabel fourthHouseLb;
    protected final ImageIcon houseIcon;
    protected final ImageIcon hotelIcon;

    // CONSTRUCTOR
    public TownSquareView(TownSquare square) {
        super(square);

        this.houseIcon = new ImageIcon(getClass().getResource("/img/house.png"));
        this.hotelIcon = new ImageIcon(getClass().getResource("/img/hotel.png"));

        // House labels
        firstHouseLb = new JLabel();
        secondHouseLb = new JLabel();
        thirdHouseLb = new JLabel();
        fourthHouseLb = new JLabel();
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

    public void removeHouse() {
        if (fourthHouseLb.getIcon() != null)
            fourthHouseLb.setIcon(null);
        else if (thirdHouseLb.getIcon() != null)
            thirdHouseLb.setIcon(null);
        else if (secondHouseLb.getIcon() != null)
            secondHouseLb.setIcon(null);
        else if (firstHouseLb.getIcon() != null)
            firstHouseLb.setIcon(null);
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
