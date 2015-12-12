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
public class TopBoardPanel {

    // ATTRIBUTES
    private JPanel mainPn;

    // CONSTRUCTOR
    public TopBoardPanel(List<Square> squares) {

        // Instantiate
        CornerSquareView freeParking = new CornerSquareView(SquareView.Rotation.TOP, new ImageIcon(getClass().getResource("/img/square_freeparking.png")));
        TownSquareView kentuckyAvenue = new TownSquareView(SquareView.Rotation.TOP, (TownSquare) squares.get(1));
        ChanceCardSquareView chanceCardSquareView = new ChanceCardSquareView(SquareView.Rotation.TOP);
        TownSquareView indianaAvenue = new TownSquareView(SquareView.Rotation.TOP, (TownSquare) squares.get(3));
        TownSquareView illinoisAvenue = new TownSquareView(SquareView.Rotation.TOP, (TownSquare) squares.get(4));
        RailroadsSquareView bnoRailroads = new RailroadsSquareView(SquareView.Rotation.TOP, (RailroadsSquare) squares.get(5));
        TownSquareView atlanticAvenue = new TownSquareView(SquareView.Rotation.TOP, (TownSquare) squares.get(6));
        TownSquareView ventnorAvenue = new TownSquareView(SquareView.Rotation.TOP, (TownSquare) squares.get(7));
        UtilitySquareView waterWorks = new UtilitySquareView(SquareView.Rotation.TOP, (UtilitySquare) squares.get(8));
        TownSquareView marvinGardens = new TownSquareView(SquareView.Rotation.TOP, (TownSquare) squares.get(9));
        CornerSquareView goToJail = new CornerSquareView(SquareView.Rotation.TOP, new ImageIcon(getClass().getResource("/img/square_gotojail.png")));

        // Add to the main panel // TODO check order
        mainPn.setLayout(new BoxLayout(mainPn, BoxLayout.X_AXIS));
        mainPn.add(freeParking);
        mainPn.add(kentuckyAvenue);
        mainPn.add(chanceCardSquareView);
        mainPn.add(indianaAvenue);
        mainPn.add(illinoisAvenue);
        mainPn.add(bnoRailroads);
        mainPn.add(atlanticAvenue);
        mainPn.add(ventnorAvenue);
        mainPn.add(waterWorks);
        mainPn.add(marvinGardens);
        mainPn.add(goToJail);
    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
