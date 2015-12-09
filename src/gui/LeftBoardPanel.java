package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TownSquare;
import models.squares.UtilitySquare;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

/**
 * @author anikristo
 */
public class LeftBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    private TownSquareView stCharlesPlace;
    private UtilitySquareView electricCompany;
    private TownSquareView statesAvenue;
    private TownSquareView virginiaAvenue;
    private RailroadsSquareView pennsylvaniaRailroad;
    private TownSquareView stJamesPlace;
    private CommunityChestSquareView communityChestCardSquare;
    private TownSquareView tennesseAvenue;
    private TownSquareView newYorkAvenue;

    // CONSTRUCTOR
    public LeftBoardPanel(List<Square> squares) {

        // Instantiate
        stCharlesPlace = new TownSquareView((TownSquare) squares.get(0));
        electricCompany = new UtilitySquareView((UtilitySquare) squares.get(1));
        statesAvenue = new TownSquareView((TownSquare) squares.get(2));
        virginiaAvenue = new TownSquareView((TownSquare) squares.get(3));
        pennsylvaniaRailroad = new RailroadsSquareView((RailroadsSquare) squares.get(4));
        stJamesPlace = new TownSquareView((TownSquare) squares.get(5));
        communityChestCardSquare = new CommunityChestSquareView();
        tennesseAvenue = new TownSquareView((TownSquare) squares.get(7));
        newYorkAvenue = new TownSquareView((TownSquare) squares.get(8));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.Y_AXIS));
        mainPn.add(rotate(stCharlesPlace.getContent()));
        mainPn.add(rotate(electricCompany.getContent()));
        mainPn.add(rotate(statesAvenue.getContent()));
        mainPn.add(rotate(virginiaAvenue.getContent()));
        mainPn.add(rotate(pennsylvaniaRailroad.getContent()));
        mainPn.add(rotate(stJamesPlace.getContent()));
        mainPn.add(rotate(communityChestCardSquare.getContent()));
        mainPn.add(rotate(tennesseAvenue.getContent()));
        mainPn.add(rotate(newYorkAvenue.getContent()));
    }

    // METHODS
    private JPanel rotate(JPanel content) {  // TODO test
        Graphics2D g = (Graphics2D) content.getGraphics();
        g.transform(AffineTransform.getQuadrantRotateInstance(1));
        return content;
    }

    public JPanel getContent() {
        return mainPn;
    }
}
