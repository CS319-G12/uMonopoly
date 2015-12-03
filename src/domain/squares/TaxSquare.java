package domain.squares;

/**
 * @author anikristo
 */
public class TaxSquare extends Square {


    // ATTRIBUTES
    private final int taxAmount;

    // CONSTRUCTOR
    public TaxSquare(int position, String name, SquareType type, int taxAmount) {
        super(position, name, type);
        this.taxAmount = taxAmount;
    }

    // METHODS
    public int getTaxAmount() {
        return taxAmount;
    }
}
