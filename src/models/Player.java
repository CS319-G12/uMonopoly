package models;

import models.dice.Dice;
import models.dice.DiceType;
import models.token.Token;
import models.token.TokenFigure;
import models.token.TokenType;

import java.util.Observable;

/**
 * @author anikristo
 */
public class Player extends Observable {

    // ATTRIBUTES
    private String name;
    private boolean inJail;
    private int budget;
    private Token token;
    private Dice dice;

    // CONSTRUCTOR
    public Player(String name, TokenFigure tokenFigure) {
        this.name = name;
        this.budget = Rules.START_BUDGET;
        this.inJail = false;
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

    public int getPosition() {
        return token.getPosition();
    }

    public void setPosition(int position) {
        token.setPosition(position);
        notifyObservers(); // TODO see if is changed
    }

    public void upgradeToken() throws TokenCannotBeUpgradedException {
        if (token.getType() == TokenType.SIMPLE)
            token.setType(TokenType.GOLDEN);
        else if (token.getType() == TokenType.GOLDEN)
            token.setType(TokenType.PLATINUM);
        else
            throw new TokenCannotBeUpgradedException();

        notifyObservers();
    }

    public TokenType getTokenType() {
        return token.getType();
    }

    public void move(int difference) {
        token.setPosition(token.getPosition() + difference);
        notifyObservers();
    }

    public int getBudget() {
        return budget;
    }

    public void updateBudget(int difference) {
        budget += difference;
        notifyObservers();
    }

    public boolean isInJail() {
        return inJail;
    }

    public void upgradeDice() throws DiceCannotBeUpgradedException {
        if (dice.getType() == DiceType.SIMPLE)
            dice.setType(DiceType.GOLDEN);
        else if (dice.getType() == DiceType.GOLDEN)
            dice.setType(DiceType.PLATINUM);
        else
            throw new DiceCannotBeUpgradedException();

        notifyObservers();
    }

    public int roll() {
        return dice.rollAndGetTotalValue();
    }

    public DiceType getDiceType() {
        return dice.getType();
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
