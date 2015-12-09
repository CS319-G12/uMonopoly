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
public class TopBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    private CornerSquareView freeParking;
    private TownSquareView kentuckyAvenue;
    private ChanceCardSquareView chanceCardSquareView;
    private TownSquareView indianaAvenue;
    private TownSquareView illinoisAvenue;
    private RailroadsSquareView bnoRailroads;
    private TownSquareView atlanticAvenue;
    private TownSquareView ventnorAvenue;
    private UtilitySquareView waterWorks;
    private TownSquareView marvinGardens;
    private CornerSquareView goToJail;

    // CONSTRUCTOR
    public TopBoardPanel(List<Square> squares) {

        // Instantiate
        freeParking = new CornerSquareView(new ImageIcon(getClass().getResource("/img/square_freeparking.png")));
        kentuckyAvenue = new TownSquareView((TownSquare) squares.get(1));
        chanceCardSquareView = new ChanceCardSquareView();
        indianaAvenue = new TownSquareView((TownSquare) squares.get(3));
        illinoisAvenue = new TownSquareView((TownSquare) squares.get(4));
        bnoRailroads = new RailroadsSquareView((RailroadsSquare) squares.get(5));
        atlanticAvenue = new TownSquareView((TownSquare) squares.get(6));
        ventnorAvenue = new TownSquareView((TownSquare) squares.get(7));
        waterWorks = new UtilitySquareView((UtilitySquare) squares.get(8));
        marvinGardens = new TownSquareView((TownSquare) squares.get(9));
        goToJail = new CornerSquareView(new ImageIcon(getClass().getResource("/img/square_gotojail.png")));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.X_AXIS));
        mainPn.add(rotate(freeParking.getContent()));
        mainPn.add(rotate(kentuckyAvenue.getContent()));
        mainPn.add(rotate(chanceCardSquareView.getContent()));
        mainPn.add(rotate(indianaAvenue.getContent()));
        mainPn.add(rotate(illinoisAvenue.getContent()));
        mainPn.add(rotate(bnoRailroads.getContent()));
        mainPn.add(rotate(atlanticAvenue.getContent()));
        mainPn.add(rotate(ventnorAvenue.getContent()));
        mainPn.add(rotate(waterWorks.getContent()));
        mainPn.add(rotate(marvinGardens.getContent()));
        mainPn.add(rotate(goToJail.getContent()));
    }

    // METHODS
    private JPanel rotate(JPanel content) {  // TODO test
        Graphics2D g = (Graphics2D) content.getGraphics();
        g.transform(AffineTransform.getQuadrantRotateInstance(2));
        return content;
    }

    public JPanel getContent() {
        return mainPn;
    }
}
