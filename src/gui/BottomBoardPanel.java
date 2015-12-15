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
class BottomBoardPanel extends JPanel {

    // CONSTRUCTOR
    public BottomBoardPanel(List<Square> squares) {

        // Instantiate
        CornerSquareView go = new CornerSquareView(squares.get(0), new ImageIcon(getClass().getResource("/img/square_go.png")));
        BTownSquareView mediterraneanAvenue = new BTownSquareView((TownSquare) squares.get(1));
        BCommunityChestSquareView communityChestSquareView = new BCommunityChestSquareView(squares.get(2));
        BTownSquareView balticAvenue = new BTownSquareView((TownSquare) squares.get(3));
        BTaxSquareView taxSquareView = new BTaxSquareView((TaxSquare) squares.get(4));
        BRailroadsSquareView reading = new BRailroadsSquareView((RailroadsSquare) squares.get(5));
        BTownSquareView orientalAvenue = new BTownSquareView((TownSquare) squares.get(6));
        BChanceCardSquareView chanceCardSquareView = new BChanceCardSquareView(squares.get(7));
        BTownSquareView vermontAvenue = new BTownSquareView((TownSquare) squares.get(8));
        BTownSquareView connecticutAvenue = new BTownSquareView((TownSquare) squares.get(9));
        CornerSquareView jail = new CornerSquareView(squares.get(10), new ImageIcon(getClass().getResource("/img/square_jail.png")));

        // Add to the main panel
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setMinimumSize(new Dimension(730, 95));
        setMaximumSize(new Dimension(730, 95));
        setPreferredSize(new Dimension(730, 95));
        setBorder(null);
        add(jail);
        add(connecticutAvenue);
        add(vermontAvenue);
        add(chanceCardSquareView);
        add(orientalAvenue);
        add(reading);
        add(taxSquareView);
        add(balticAvenue);
        add(communityChestSquareView);
        add(mediterraneanAvenue);
        add(go);
    }
}
