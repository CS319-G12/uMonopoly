package gui;

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
    public MonopolyBoardView(List<Square> squares) { // TODO check
        leftPn = new LeftBoardPanel(squares.subList(0, 11)).getContent();
        rightPn = new RightBoardPanel(squares.subList(11, 20)).getContent();
        topPn = new TopBoardPanel(squares.subList(20, 31)).getContent();
        bottomPn = new BottomBoardPanel(squares.subList(31, 40)).getContent();
        centerPn = new CenterBoardPanel();

    }

    // METHODS
    public JPanel getContent() {
        return mainPn;
    }

}
