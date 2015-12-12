package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TownSquare;
import models.squares.UtilitySquare;

import javax.swing.*;
import java.util.List;

/**
 * @author anikristo
 */
public class LeftBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    // CONSTRUCTOR
    public LeftBoardPanel(List<Square> squares) {

        // Instantiate
        TownSquareView stCharlesPlace = new TownSquareView(SquareView.Rotation.LEFT, (TownSquare) squares.get(0));
        UtilitySquareView electricCompany = new UtilitySquareView(SquareView.Rotation.LEFT, (UtilitySquare) squares.get(1));
        TownSquareView statesAvenue = new TownSquareView(SquareView.Rotation.LEFT, (TownSquare) squares.get(2));
        TownSquareView virginiaAvenue = new TownSquareView(SquareView.Rotation.LEFT, (TownSquare) squares.get(3));
        RailroadsSquareView pennsylvaniaRailroad = new RailroadsSquareView(SquareView.Rotation.LEFT, (RailroadsSquare) squares.get(4));
        TownSquareView stJamesPlace = new TownSquareView(SquareView.Rotation.LEFT, (TownSquare) squares.get(5));
        CommunityChestSquareView communityChestCardSquare = new CommunityChestSquareView(SquareView.Rotation.LEFT);
        TownSquareView tennesseeAvenue = new TownSquareView(SquareView.Rotation.LEFT, (TownSquare) squares.get(7));
        TownSquareView newYorkAvenue = new TownSquareView(SquareView.Rotation.LEFT, (TownSquare) squares.get(8));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.Y_AXIS));
        mainPn.add(stCharlesPlace);
        mainPn.add(electricCompany);
        mainPn.add(statesAvenue);
        mainPn.add(virginiaAvenue);
        mainPn.add(pennsylvaniaRailroad);
        mainPn.add(stJamesPlace);
        mainPn.add(communityChestCardSquare);
        mainPn.add(tennesseeAvenue);
        mainPn.add(newYorkAvenue);
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
