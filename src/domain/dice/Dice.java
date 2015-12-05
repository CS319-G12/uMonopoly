package domain.dice;

/**
 * @author Ali Gocer
 * This is a simulation of the two dice used in the Monopoly Game.
 * It provides the rolling method tailored for the different Dice Types.
 * @invariant self.value1 > 0 && self.value1 < 7
 * @invariant self.value2 > 0 && self.value2 < 7
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

    /**
     * This will roll the dice and return the right
     *
     * @param nDice This is the dice type that the current player owns
     * @return The total value of the roll. The sum if it is simple type, double the sum if it is platinum
     * and two roll's value if it is golden.
     * @pre nDice == DiceType.SIMPLE || nDice == DiceType.GOLDEN || nDice == DiceType.PLATINUM
     * @post self.value1 != @pre.self.value1 && self.value2 != @pre.self.value2
     */
    public int rollAndGetTotalValue(DiceType nDice) {
        int total;
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

    public DiceType getType() {
        return type;
    }

    public void setType(DiceType newType) {
        this.type = newType;
    }
}
