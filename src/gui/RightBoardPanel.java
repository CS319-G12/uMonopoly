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
public class RightBoardPanel extends JPanel {

    // CONSTRUCTOR
    public RightBoardPanel(List<Square> squares) {

        // Instantiate
        RTownSquareView pacificAvenue = new RTownSquareView((TownSquare) squares.get(0));
        RTownSquareView carolinaAvenue = new RTownSquareView((TownSquare) squares.get(1));
        RCommunityChestSquareView communityChestSquareView = new RCommunityChestSquareView();
        RTownSquareView pennsylvaniaAvenue = new RTownSquareView((TownSquare) squares.get(3));
        RRailroadsSquareView shortLine = new RRailroadsSquareView((RailroadsSquare) squares.get(4));
        RChanceCardSquareView chanceCardSquareView = new RChanceCardSquareView();
        RTownSquareView parkPlace = new RTownSquareView((TownSquare) squares.get(6));
        RTaxSquareView taxSquareView = new RTaxSquareView((TaxSquare) squares.get(7));
        RTownSquareView boardwalk = new RTownSquareView((TownSquare) squares.get(8));

        // Add to the main panel // TODO check order
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(95, 540));
        setMaximumSize(new Dimension(95, 540));
        setPreferredSize(new Dimension(95, 540));
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
