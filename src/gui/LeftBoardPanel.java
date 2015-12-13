package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TownSquare;
import models.squares.UtilitySquare;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author anikristo
 */
public class LeftBoardPanel extends JPanel {

    // CONSTRUCTOR
    public LeftBoardPanel(List<Square> squares) {

        // Instantiate
        LTownSquareView stCharlesPlace = new LTownSquareView((TownSquare) squares.get(0));
        LUtilitySquareView electricCompany = new LUtilitySquareView((UtilitySquare) squares.get(1));
        LTownSquareView statesAvenue = new LTownSquareView((TownSquare) squares.get(2));
        LTownSquareView virginiaAvenue = new LTownSquareView((TownSquare) squares.get(3));
        LRailroadsSquareView pennsylvaniaRailroad = new LRailroadsSquareView((RailroadsSquare) squares.get(4));
        LTownSquareView stJamesPlace = new LTownSquareView((TownSquare) squares.get(5));
        LCommunityChestSquareView communityChestCardSquare = new LCommunityChestSquareView();
        LTownSquareView tennesseeAvenue = new LTownSquareView((TownSquare) squares.get(7));
        LTownSquareView newYorkAvenue = new LTownSquareView((TownSquare) squares.get(8));

        // Add to the main panel // TODO check order
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(95, 540));
        setMaximumSize(new Dimension(95, 540));
        setPreferredSize(new Dimension(95, 540));
        add(stCharlesPlace);
        add(electricCompany);
        add(statesAvenue);
        add(virginiaAvenue);
        add(pennsylvaniaRailroad);
        add(stJamesPlace);
        add(communityChestCardSquare);
        add(tennesseeAvenue);
        add(newYorkAvenue);
    }
}
