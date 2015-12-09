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


    private CornerSquareView go;
    private TownSquareView mediterreanAvenue;
    private CommunityChestSquareView communityChestSquareView;
    private TownSquareView balticAvenue;
    private TaxSquareView taxSquareView;
    private RailroadsSquareView reading;
    private TownSquareView orientalAvenue;
    private ChanceCardSquareView chanceCardSquareView;
    private TownSquareView vermontAvenue;
    private TownSquareView connecticutAvenue;
    private CornerSquareView jail;

    // CONSTRUCTOR
    public BottomBoardPanel(List<Square> squares) {

        // Instantiate
        go = new CornerSquareView(new ImageIcon(getClass().getResource("/img/square_go.png")));
        mediterreanAvenue = new TownSquareView((TownSquare) squares.get(1));
        communityChestSquareView = new CommunityChestSquareView();
        balticAvenue = new TownSquareView((TownSquare) squares.get(3));
        taxSquareView = new TaxSquareView((TaxSquare) squares.get(4));
        reading = new RailroadsSquareView((RailroadsSquare) squares.get(5));
        orientalAvenue = new TownSquareView((TownSquare) squares.get(6));
        chanceCardSquareView = new ChanceCardSquareView();
        vermontAvenue = new TownSquareView((TownSquare) squares.get(8));
        connecticutAvenue = new TownSquareView((TownSquare) squares.get(9));
        jail = new CornerSquareView(new ImageIcon(getClass().getResource("/img/square_jail.png")));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.X_AXIS));
        mainPn.add(go.getContent());
        mainPn.add(mediterreanAvenue.getContent());
        mainPn.add(communityChestSquareView.getContent());
        mainPn.add(balticAvenue.getContent());
        mainPn.add(taxSquareView.getContent());
        mainPn.add(reading.getContent());
        mainPn.add(orientalAvenue.getContent());
        mainPn.add(chanceCardSquareView.getContent());
        mainPn.add(vermontAvenue.getContent());
        mainPn.add(connecticutAvenue.getContent());
        mainPn.add(jail.getContent());
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
