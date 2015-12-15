package models;

import models.factories.SquareFactory;
import models.squares.Square;

import java.util.List;

/**
 * @author Ani Kristo
 * @invariant self.squareList.size() == 40
 */
class MonopolyBoard {

    // ATTRIBUTES
    private List<Square> squareList;

    // METHODS
    /**
     * @pre self.squareList->at(currentSquare).getHouseCount() < 5 ||
     * (self.squareList->at(currentSquare).getHouseCount() == 4 && !self.squareList->at(currentSquare).hasHotel())
     * @post self.squareList->at(currentSquare).getHouseCount() == self@pre.squareList->at(currentSquare).getHouseCount() + 1
     * || (self.squareList->at(currentSquare).houseCount() == 0 && self.squareList->at(currentSquare).hasHotel())
     */
    public List<Square> getListOfSquares() {
        if (squareList == null) {
            // Generate squares
            squareList = new SquareFactory().getSquares();
            return squareList;
        } else
            return squareList;
    }
}
