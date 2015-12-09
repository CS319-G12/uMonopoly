package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TaxSquare;
import models.squares.TownSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

/**
 * @author anikristo
 */
public class RightBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    private TownSquareView pacificAvenue;
    private TownSquareView carolinaAvenue;
    private CommunityChestSquareView communityChestSquareView;
    private TownSquareView pennsylvaniaAvenue;
    private RailroadsSquareView shortLine;
    private ChanceCardSquareView chanceCardSquareView;
    private TownSquareView parkPlace;
    private TaxSquareView taxSquareView;
    private TownSquareView broadwalk;

    // CONSTRUCTOR
    public RightBoardPanel(List<Square> squares) {

        // Instantiate
        pacificAvenue = new TownSquareView((TownSquare) squares.get(0));
        carolinaAvenue = new TownSquareView((TownSquare) squares.get(1));
        communityChestSquareView = new CommunityChestSquareView();
        pennsylvaniaAvenue = new TownSquareView((TownSquare) squares.get(3));
        shortLine = new RailroadsSquareView((RailroadsSquare) squares.get(4));
        chanceCardSquareView = new ChanceCardSquareView();
        parkPlace = new TownSquareView((TownSquare) squares.get(6));
        taxSquareView = new TaxSquareView((TaxSquare) squares.get(7));
        broadwalk = new TownSquareView((TownSquare) squares.get(8));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.Y_AXIS));
        mainPn.add(rotate(pacificAvenue.getContent()));
        mainPn.add(rotate(carolinaAvenue.getContent()));
        mainPn.add(rotate(communityChestSquareView.getContent()));
        mainPn.add(rotate(pennsylvaniaAvenue.getContent()));
        mainPn.add(rotate(shortLine.getContent()));
        mainPn.add(rotate(chanceCardSquareView.getContent()));
        mainPn.add(rotate(parkPlace.getContent()));
        mainPn.add(rotate(taxSquareView.getContent()));
        mainPn.add(rotate(broadwalk.getContent()));
    }

    // METHODS
    private JPanel rotate(JPanel content) {  // TODO test
        Graphics2D g = (Graphics2D) content.getGraphics();
        g.transform(AffineTransform.getQuadrantRotateInstance(3));
        return content;
    }

    public JPanel getContent() {
        return mainPn;
    }
}
