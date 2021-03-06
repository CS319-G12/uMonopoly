package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TaxSquare;
import models.squares.TownSquare;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ani Kristo
 */
class RightBoardPanel extends JPanel {

    // CONSTRUCTOR
    public RightBoardPanel(List<Square> squares) {

        // Instantiate
        RTownSquareView pacificAvenue = new RTownSquareView((TownSquare) squares.get(0));
        RTownSquareView carolinaAvenue = new RTownSquareView((TownSquare) squares.get(1));
        RCommunityChestSquareView communityChestSquareView = new RCommunityChestSquareView(squares.get(2));
        RTownSquareView pennsylvaniaAvenue = new RTownSquareView((TownSquare) squares.get(3));
        RRailroadsSquareView shortLine = new RRailroadsSquareView((RailroadsSquare) squares.get(4));
        RChanceCardSquareView chanceCardSquareView = new RChanceCardSquareView(squares.get(5));
        RTownSquareView parkPlace = new RTownSquareView((TownSquare) squares.get(6));
        RTaxSquareView taxSquareView = new RTaxSquareView((TaxSquare) squares.get(7));
        RTownSquareView boardwalk = new RTownSquareView((TownSquare) squares.get(8));

        // Add to the main panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(95, 554));
        setMaximumSize(new Dimension(95, 554));
        setPreferredSize(new Dimension(95, 554));
        add(pacificAvenue);
        add(carolinaAvenue);
        add(communityChestSquareView);
        add(pennsylvaniaAvenue);
        add(shortLine);
        add(chanceCardSquareView);
        add(parkPlace);
        add(taxSquareView);
        add(boardwalk);
    }
}
