package models.dice;

/**
 * @author Ali Gocer
 * This is a simulation of the two dice used in the Monopoly Game.
 * It providevrs the rolling method tailored for the different Dice Types.
 * INV: self.value1 > 0 && self.value1 < 7
 * INV: self.value2 > 0 && self.value2 < 7
 */
public class Dice {

    // ATTRIBUTES
    private DiceValue value1, value2;
    private DiceType type;

    // CONSTRUCTOR
    public Dice() {
        value1 = value2 = null;
        type = DiceType.SIMPLE;
    }

    // METHODS
    private void roll() {
        int value1 = ((int) (Math.random() * 6)) + 1;
        int value2 = ((int) (Math.random() * 6)) + 1;

        this.value1 = getDiceValue(value1);
        this.value2 = getDiceValue(value2);
    }

    private DiceValue getDiceValue(int value) {
        switch (value) {
            case 1:
                return DiceValue.ONE;
            case 2:
                return DiceValue.TWO;
            case 3:
                return DiceValue.THREE;
            case 4:
                return DiceValue.FOUR;
            case 5:
                return DiceValue.FIVE;
            case 6:
                return DiceValue.SIX;
        }

        return null;
    }

    public boolean isDoubles() {
        return (value1.equals(value2));
    }

    public DiceValue getValue2() {
        return value2;
    }

    public DiceValue getValue1() {
        return value1;
    }

    /**
     * This will roll the dice and return the right
     *
     * @return The total value of the roll. The sum if it is simple type, double the sum if it is platinum
     * and two roll's value if it is golden.
     * PRE: nDice == DiceType.SIMPLE || nDice == DiceType.GOLDEN || nDice == DiceType.PLATINUM
     * POST: self.value1 != PRE:.self.value1 && self.value2 != PRE:.self.value2
     */
    public int rollAndGetTotalValue() {
        int total;
        if (type == DiceType.GOLDEN) {
            this.roll();
            total = value1.getValue() + value2.getValue();
            this.roll();
            total += value1.getValue() + value2.getValue();
        } else if (type == DiceType.PLATINUM) {
            total = 2 * (value1.getValue() + value2.getValue());
        } else { // DiceType is SIMPLE
            roll();
            total = value1.getValue() + value2.getValue();
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
