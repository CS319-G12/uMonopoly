package models;

import models.dice.Dice;
import models.dice.DiceType;
import models.token.Token;
import models.token.TokenFigure;
import models.token.TokenType;

/**
 * @author anikristo
 */
public class Player {

    // ATTRIBUTES
    private String name;
    private Token token;
    private int budget;
    private Dice dice;

    // CONSTRUCTOR
    public Player(String name, TokenFigure tokenFigure) {
        this.name = name;
        this.dice = new Dice();
        this.token = new Token(tokenFigure);
        this.budget = Rules.START_BUDGET;
    }

    // METHODS
    public String getName() {
        return name;
    }

    public TokenFigure getTokenFigure() {
        return token.getFigure();
    }

    public int getTokenPosition() {
        return token.getPosition();
    }

    public void upgradeDice() throws DiceCannotBeUpgradedException {
        if (dice.getType() == DiceType.SIMPLE)
            dice.setType(DiceType.GOLDEN);
        else if (dice.getType() == DiceType.GOLDEN)
            dice.setType(DiceType.PLATINUM);
        else
            throw new DiceCannotBeUpgradedException();
    }

    public void upgradeToken() throws TokenCannotBeUpgradedException {
        if (token.getType() == TokenType.SIMPLE)
            token.setType(TokenType.GOLDEN);
        else if (token.getType() == TokenType.GOLDEN)
            token.setType(TokenType.PLATINUM);
        else
            throw new TokenCannotBeUpgradedException();
    }

    public int roll() {
        return dice.rollAndGetTotalValue();
    }

    public void updateBudget(int difference) {
        budget += difference;
    }

    public static class DiceCannotBeUpgradedException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The dice has reached the maximum upgrade level!";
        }
    }

    public static class TokenCannotBeUpgradedException extends Exception {
        @Override
        public String getMessage() {
            return super.getMessage() + "The token has reached the maximum upgrade level!";
        }
    }
}
