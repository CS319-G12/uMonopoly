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
public class TopBoardPanel extends JPanel {

    // CONSTRUCTOR
    public TopBoardPanel(List<Square> squares) {

        // Instantiate
        CornerSquareView freeParking = new CornerSquareView(new ImageIcon(getClass().getResource("/img/square_freeparking.png")));
        BTownSquareView kentuckyAvenue = new BTownSquareView((TownSquare) squares.get(1));
        BChanceCardSquareView chanceCardSquareView = new BChanceCardSquareView();
        BTownSquareView indianaAvenue = new BTownSquareView((TownSquare) squares.get(3));
        BTownSquareView illinoisAvenue = new BTownSquareView((TownSquare) squares.get(4));
        TRailroadsSquareView bnoRailroads = new TRailroadsSquareView((RailroadsSquare) squares.get(5));
        BTownSquareView atlanticAvenue = new BTownSquareView((TownSquare) squares.get(6));
        BTownSquareView ventnorAvenue = new BTownSquareView((TownSquare) squares.get(7));
        LUtilitySquareView waterWorks = new LUtilitySquareView((UtilitySquare) squares.get(8));
        BTownSquareView marvinGardens = new BTownSquareView((TownSquare) squares.get(9));
        CornerSquareView goToJail = new CornerSquareView(new ImageIcon(getClass().getResource("/img/square_gotojail.png")));

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
