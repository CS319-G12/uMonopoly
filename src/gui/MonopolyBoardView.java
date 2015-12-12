package gui;

import models.Game;
import models.squares.Square;

import javax.swing.*;
import java.util.List;

/**
 * @author anikristo
 */
public class MonopolyBoardView {

    // ATTRIBUTES
    private JPanel mainPn;
    private JPanel leftPn;
    private JPanel topPn;
    private JPanel rightPn;
    private JPanel bottomPn;
    private JPanel centerPn;

    // CONSTRUCTOR
    public MonopolyBoardView(Game game) { // TODO check
        List<Square> squares = game.getListOfSquares();

//        bottomPn.add(new BottomBoardPanel(squares.subList(0, 11)).getContent());
//        leftPn.add(new LeftBoardPanel(squares.subList(11, 20)).getContent());
//        topPn.add(new TopBoardPanel(squares.subList(20, 31)).getContent());
//        rightPn.add(new RightBoardPanel(squares.subList(31, 40)).getContent());
//        centerPn.add(new CenterBoardPanel(game).getContent());

    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }

}
