package domain.dice;

/**
 * @author Ali Gocer
 */
public class Dice {

    // ATTRIBUTES
    private int value1, value2;
    private DiceType type;

    // CONSTRUCTOR
    public Dice() {
        value1 = value2 = 0;
        type = DiceType.SIMPLE;
    }

    // METHODS
    private void roll() {
        value1 = ((int) Math.random() * 6) + 1;
        value2 = ((int) Math.random() * 6) + 1;
    }

    public boolean isDoubles() {
        return (value1 == value2);
    }

    public int getValue2() {
        return value2;
    }

    public int getValue1() {
        return value1;
    }

    public int rollAndGetTotalValue(DiceType nDice) {
        int total = 0;
        if (nDice == DiceType.GOLDEN) {
            this.roll();
            total = value1 + value2;
            this.roll();
            total += value1 + value2;
        } else if (nDice == DiceType.PLATINUM) {
            total = 2 * (value1 + value2);
        } else { // DiceType is SIMPLE
            roll();
            total = value1 + value2;
        }
        return total;
    }

    public void setType(DiceType newType) {
        this.type = newType;
    }

    public DiceType getType() {
        return type;
    }
}
