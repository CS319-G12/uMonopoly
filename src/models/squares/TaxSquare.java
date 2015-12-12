package models.squares;

/**
 * @author anikristo
 */
public class TaxSquare extends Square {


    // ATTRIBUTES
    private final int taxAmount;

    // CONSTRUCTOR
    public TaxSquare(int position, String name, int taxAmount) {
        super(position, name, SquareType.TAX);
        this.taxAmount = taxAmount;
    }

    // METHODS
    public int getTaxAmount() {
        return taxAmount;
    }
}
