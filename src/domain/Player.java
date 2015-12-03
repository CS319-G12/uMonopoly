package domain;

import domain.dice.Dice;
import domain.dice.DiceType;
import domain.token.Token;
import domain.token.TokenFigure;
import domain.token.TokenType;

/**
 * @author anikristo
 */
public class Player {

    // ATTRIBUTES
    private String name;
    private Token token;
    private Dice dice;

    // CONSTRUCTOR
    public Player(String name, TokenFigure tokenFigure) {
        this.name = name;
        this.dice = new Dice();
        this.token = new Token(tokenFigure);
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

    public boolean equals(Player o) {
        return o.getName().equals(name);
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
        return dice.rollAndGetTotalValue(dice.getType());
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
