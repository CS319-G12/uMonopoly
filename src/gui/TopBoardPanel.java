package gui;

import models.squares.RailroadsSquare;
import models.squares.Square;
import models.squares.TownSquare;
import models.squares.UtilitySquare;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ani Kristo
 */
class TopBoardPanel extends JPanel {

    // CONSTRUCTOR
    public TopBoardPanel(List<Square> squares) {

        // Instantiate
        CornerSquareView freeParking = new CornerSquareView(squares.get(0), new ImageIcon(getClass().getResource("/img/square_freeparking.png")));
        TTownSquareView kentuckyAvenue = new TTownSquareView((TownSquare) squares.get(1));
        TChanceCardSquareView chanceCardSquareView = new TChanceCardSquareView(squares.get(2));
        TTownSquareView indianaAvenue = new TTownSquareView((TownSquare) squares.get(3));
        TTownSquareView illinoisAvenue = new TTownSquareView((TownSquare) squares.get(4));
        TRailroadsSquareView bnoRailroads = new TRailroadsSquareView((RailroadsSquare) squares.get(5));
        TTownSquareView atlanticAvenue = new TTownSquareView((TownSquare) squares.get(6));
        TTownSquareView ventnorAvenue = new TTownSquareView((TownSquare) squares.get(7));
        TUtilitySquareView waterWorks = new TUtilitySquareView((UtilitySquare) squares.get(8));
        TTownSquareView marvinGardens = new TTownSquareView((TownSquare) squares.get(9));
        CornerSquareView goToJail = new CornerSquareView(squares.get(10), new ImageIcon(getClass().getResource("/img/square_gotojail.png")));

        // Add to the main panel // TODO check order
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setMinimumSize(new Dimension(730, 95));
        setMaximumSize(new Dimension(730, 95));
        setPreferredSize(new Dimension(730, 95));
        add(freeParking);
        add(kentuckyAvenue);
        add(chanceCardSquareView);
        add(indianaAvenue);
        add(illinoisAvenue);
        add(bnoRailroads);
        add(atlanticAvenue);
        add(ventnorAvenue);
        add(waterWorks);
        add(marvinGardens);
        add(goToJail);
    }
}
