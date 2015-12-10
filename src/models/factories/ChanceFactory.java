package models.factories;

import models.cards.ChanceCard;
import models.cards.ChanceCardBuilder;
import models.squares.ChanceCardSquare;
import models.squares.SquareType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anikristo
 */
public class ChanceFactory extends BonusFactory {

    // ATTRIBUTES
    List<ChanceCard> cards;
    List<ChanceCardSquare> squares;

    // CONSTRUCTOR
    public ChanceFactory() {

        cards = new ArrayList<>();
        squares = new ArrayList<>();

        // Instantiate all Chance Cards
        ChanceCardBuilder builder = new ChanceCardBuilder();
        ChanceCard card1 = builder
                .amount(200)
                .description("Advance to GO and collect 200$.")
                .build();
        cards.add(card1);

        ChanceCard card2 = builder
                .goTo(24)
                .description("Advance to Illinois Avenue. If you pass GO, collect 200$")
                .build();
        cards.add(card2);

        ChanceCard card3 = builder
                .description("Advance to St. Charles Place. If you pass GO, collect 200$")
                .goTo(11)
                .build();
        cards.add(card3);


        // Instantiate all Chance Squares and give them the correct chance cards
        ChanceCardSquare square1 = new ChanceCardSquare(7, "Chance", SquareType.CHANCE, cards);
        ChanceCardSquare square2 = new ChanceCardSquare(22, "Chance", SquareType.CHANCE, cards);
        ChanceCardSquare square3 = new ChanceCardSquare(36, "Chance", SquareType.CHANCE, cards);
    }

    // METHODS
    public List<ChanceCardSquare> getSquare(){
        return squares;
    }
}
