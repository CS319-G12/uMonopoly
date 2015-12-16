package models;

import models.cards.PropertyCard;
import models.dice.Dice;
import models.dice.DiceType;
import models.dice.DiceValue;
import models.token.Token;
import models.token.TokenFigure;
import models.token.TokenType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Ani Kristo & Alper Önder
 */
public class Player extends Observable {

    // ATTRIBUTES
    private String name;
    private boolean inJail;
    private boolean isPlaying;
    private boolean hasLost;
    private int budget;
    private Token token;
    private Dice dice;
    private List<PropertyCard> propertyCards;
    private int turnsInJail;
    private int oldPosition;

    // CONSTRUCTOR
    public Player(String name, TokenFigure tokenFigure) {
        this.name = name;
        this.budget = Rules.START_BUDGET;
        this.inJail = false;
        this.isPlaying = false;
        this.hasLost = false;
        this.dice = new Dice();
        this.token = new Token(tokenFigure);
        this.propertyCards = new ArrayList<>();
        this.turnsInJail = 0;
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
        oldPosition = getPosition();
        token.setPosition(position);
        notifyObservers();
    }

    public void upgradeToken() throws TokenCannotBeUpgradedException {
        if (token.getType() == TokenType.SIMPLE && canUpgradeToken()) {
            budget -= Rules.GOLDEN_TOKEN_UPGRADE_PRICE;
            token.setType(TokenType.GOLDEN);
        } else if (token.getType() == TokenType.GOLDEN && canUpgradeToken()) {
            budget -= Rules.PLATINUM_TOKEN_UPGRADE_PRICE;
            token.setType(TokenType.PLATINUM);
        } else
            throw new TokenCannotBeUpgradedException();

        setChanged();
        notifyObservers();
    }

    public TokenType getTokenType() {
        return token.getType();
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

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
        setPosition(Rules.JAIL_VISITOR_POSITION);
        oldPosition = getPosition(); // trick
    }

    public void upgradeDice() throws DiceCannotBeUpgradedException {
        if (dice.getType() == DiceType.SIMPLE && canUpgradeDice()) {
            budget -= Rules.GOLDEN_DICE_UPGRADE_PRICE;
            dice.setType(DiceType.GOLDEN);
        } else if (dice.getType() == DiceType.GOLDEN && canUpgradeDice()) {
            budget -= Rules.PLATINUM_DICE_UPGRADE_PRICE;
            dice.setType(DiceType.PLATINUM);
        } else
            throw new DiceCannotBeUpgradedException();

        setChanged();
        notifyObservers();
    }

    /**
     * @return true if it was doubles otherwise false
     */
    public boolean roll() {

        oldPosition = getPosition();

        int roll = dice.rollAndGetTotalValue();

        if ((inJail && dice.isDoubles()) || (inJail && !dice.isDoubles() && turnsInJail == 3)) {
            inJail = false;
            turnsInJail = 0;
            updatePosition(roll);
        } else if (!inJail) {
            updatePosition(roll);
        }

        return dice.isDoubles();
    }

    private void updatePosition(int val) {
        oldPosition = getPosition();
        setPosition(getPosition() + val);
        if (getPosition() >= Rules.SQUARE_COUNT)
            setPosition(getPosition() - Rules.SQUARE_COUNT);
    }

    public DiceType getDiceType() {
        return dice.getType();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public List<PropertyCard> getListOfPropertyCards() {
        return propertyCards;
    }

    public void addPropertyCard(PropertyCard newPropertyCard) {
        propertyCards.add(newPropertyCard);
        newPropertyCard.setOwner(this);
    }

    public void removePropertyCard(PropertyCard thePropertyCard) {
        if (propertyCards.contains(thePropertyCard)) {
            propertyCards.remove(propertyCards.indexOf(thePropertyCard));
            thePropertyCard.removeOwner();
        }
    }

    public DiceValue getDiceValue1() {
        return dice.getValue1();
    }

    public DiceValue getDiceValue2() {
        return dice.getValue2();
    }

    public boolean hasLost() {
        return hasLost;
    }

    public void lost() {
        hasLost = true;
        notifyObservers();
    }

    public void incrementJailTurns() {
        turnsInJail++;
    }

    public int getOldPosition() {
        return oldPosition;
    }

    public boolean canUpgradeDice() {
        return getDiceType() != DiceType.PLATINUM && budget > getDiceUpgradePrice();
    }

    public boolean canUpgradeToken() {
        return getTokenType() != TokenType.PLATINUM && budget > getTokenUpgradePrice();
    }

    public int getDiceUpgradePrice() {
        if (dice.getType() == DiceType.SIMPLE)
            return Rules.GOLDEN_DICE_UPGRADE_PRICE;
        if (dice.getType() == DiceType.GOLDEN)
            return Rules.PLATINUM_DICE_UPGRADE_PRICE;
        return -1;
    }

    public int getTokenUpgradePrice() {
        if (token.getType() == TokenType.SIMPLE)
            return Rules.GOLDEN_TOKEN_UPGRADE_PRICE;
        if (token.getType() == TokenType.GOLDEN)
            return Rules.PLATINUM_TOKEN_UPGRADE_PRICE;
        return -1;
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
