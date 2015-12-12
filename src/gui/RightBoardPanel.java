package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TaxSquare;
import models.squares.TownSquare;

import javax.swing.*;
import java.util.List;

/**
 * @author anikristo
 */
public class RightBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    // CONSTRUCTOR
    public RightBoardPanel(List<Square> squares) {

        // Instantiate
        TownSquareView pacificAvenue = new TownSquareView(SquareView.Rotation.RIGHT, (TownSquare) squares.get(0));
        TownSquareView carolinaAvenue = new TownSquareView(SquareView.Rotation.RIGHT, (TownSquare) squares.get(1));
        CommunityChestSquareView communityChestSquareView = new CommunityChestSquareView(SquareView.Rotation.RIGHT);
        TownSquareView pennsylvaniaAvenue = new TownSquareView(SquareView.Rotation.RIGHT, (TownSquare) squares.get(3));
        RailroadsSquareView shortLine = new RailroadsSquareView(SquareView.Rotation.RIGHT, (RailroadsSquare) squares.get(4));
        ChanceCardSquareView chanceCardSquareView = new ChanceCardSquareView(SquareView.Rotation.RIGHT);
        TownSquareView parkPlace = new TownSquareView(SquareView.Rotation.RIGHT, (TownSquare) squares.get(6));
        TaxSquareView taxSquareView = new TaxSquareView(SquareView.Rotation.RIGHT, (TaxSquare) squares.get(7));
        TownSquareView boardwalk = new TownSquareView(SquareView.Rotation.RIGHT, (TownSquare) squares.get(8));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.Y_AXIS));
        mainPn.add(pacificAvenue);
        mainPn.add(carolinaAvenue);
        mainPn.add(communityChestSquareView);
        mainPn.add(pennsylvaniaAvenue);
        mainPn.add(shortLine);
        mainPn.add(chanceCardSquareView);
        mainPn.add(parkPlace);
        mainPn.add(taxSquareView);
        mainPn.add(boardwalk);
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
