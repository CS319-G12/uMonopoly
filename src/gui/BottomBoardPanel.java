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
public class BottomBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    // CONSTRUCTOR
    public BottomBoardPanel(List<Square> squares) {

        // Instantiate
        CornerSquareView go = new CornerSquareView(SquareView.Rotation.BOTTOM, new ImageIcon(getClass().getResource("/img/square_go.png")));
        TownSquareView mediterraneanAvenue = new TownSquareView(SquareView.Rotation.BOTTOM, (TownSquare) squares.get(1));
        CommunityChestSquareView communityChestSquareView = new CommunityChestSquareView(SquareView.Rotation.BOTTOM);
        TownSquareView balticAvenue = new TownSquareView(SquareView.Rotation.BOTTOM, (TownSquare) squares.get(3));
        TaxSquareView taxSquareView = new TaxSquareView(SquareView.Rotation.BOTTOM, (TaxSquare) squares.get(4));
        RailroadsSquareView reading = new RailroadsSquareView(SquareView.Rotation.BOTTOM, (RailroadsSquare) squares.get(5));
        TownSquareView orientalAvenue = new TownSquareView(SquareView.Rotation.BOTTOM, (TownSquare) squares.get(6));
        ChanceCardSquareView chanceCardSquareView = new ChanceCardSquareView(SquareView.Rotation.BOTTOM);
        TownSquareView vermontAvenue = new TownSquareView(SquareView.Rotation.BOTTOM, (TownSquare) squares.get(8));
        TownSquareView connecticutAvenue = new TownSquareView(SquareView.Rotation.BOTTOM, (TownSquare) squares.get(9));
        CornerSquareView jail = new CornerSquareView(SquareView.Rotation.BOTTOM, new ImageIcon(getClass().getResource("/img/square_jail.png")));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.X_AXIS));
        mainPn.add(go);
        mainPn.add(mediterraneanAvenue);
        mainPn.add(communityChestSquareView);
        mainPn.add(balticAvenue);
        mainPn.add(taxSquareView);
        mainPn.add(reading);
        mainPn.add(orientalAvenue);
        mainPn.add(chanceCardSquareView);
        mainPn.add(vermontAvenue);
        mainPn.add(connecticutAvenue);
        mainPn.add(jail);
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
