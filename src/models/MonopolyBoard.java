package models;

import models.factories.SquareFactory;
import models.squares.Square;

import java.util.List;

/**
 * @author anikristo
 * @invariant self.squareList.size() == 40
 */
public class MonopolyBoard {

    // ATTRIBUTES
    private List<Square> squareList;

    // CONSTRUCTOR

    // METHODS
//    public int getTurn() {
//        return turn;
//    }
//
//    public void movePlayer(int distance) {
//        // todo
//    }
//
//    public void setPlayerPosition(int newPosition){
//        // TODO
//    }

    /**
     * @pre self.squareList->at(currentSquare).getHouseCount() < 5 ||
     * (self.squareList->at(currentSquare).getHouseCount() == 4 && !self.squareList->at(currentSquare).hasHotel())
     * @post self.squareList->at(currentSquare).getHouseCount() == self@pre.squareList->at(currentSquare).getHouseCount() + 1
     * || (self.squareList->at(currentSquare).houseCount() == 0 && self.squareList->at(currentSquare).hasHotel())
     */
    public void build(int currentSquare) {
        // TODO current player in current square
    }

    public void buyProperty() {
        // TODO

    }

    public void sellProperty() {
        // todo
    }

//    public void endTurn(){
//        // todo
//    }

//    public void getPlayerPosition(){
//        // todo
//    }

//    public Square getPlayerSquare(){
//        // todo
//        return null;
//    }

//    public Player getCurrentPlayer(){
//        return null; // todo
//    }

    public Square getCurrentSquare() {
        return null; // todo
    }

    public List<Square> getListOfSquares() {
        if (squareList == null) {
            // Generate squares
            squareList = new SquareFactory().getSquares();
            return squareList;
        } else
            return squareList;
    }
}
