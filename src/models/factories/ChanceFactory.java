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
public class ChanceFactory implements BonusFactory {

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

        ChanceCard card4 = builder
                .description("Advance to Electric Company utility square." +
                        "If unowned, you may buy it from the Bank. If owned, then" +
                        "pay the rent accordingly.")
                .build();
        cards.add(card4);

        ChanceCard card5 = builder
                .amount(50)
                .description("Bank pays you dividend of $50")
                .build();
        cards.add(card5);

        ChanceCard card6 = builder
                .description("Go Back 3 Spaces")
                .goTo(-3)
                .build();
        cards.add(card6);

        ChanceCard card7 = builder
                .outOfJail(true)
                .description("Go to Jail directly. Do not pass Go, do not collect $200")
                .goTo(30)
                .build();
        cards.add(card7);

        ChanceCard card8 = builder
                .description("Make general repairs on all your property.For each house pay $25, for each hotel $100")
                .payPerHouse(25)
                .payPerHotel(100)
                .build();
        cards.add(card8);

        ChanceCard card9 = builder
                .amount(-15)
                .description("Pay poor tax of $15")
                .build();
        cards.add(card9);


        ChanceCard card10 = builder
                .description("Take a trip to Reading Railroad. If you pass Go, collect $200")
                .goTo(5)
                .build();
        cards.add(card10);

        ChanceCard card11 = builder
                .amount(150)
                .description("Your building {and} loan matures. Collect $150")
                .build();
        cards.add(card11);


        ChanceCard card12 = builder
                .amount(100)
                .description("You have won a crossword competition. Collect $100")
                .build();
        cards.add(card12);

        ChanceCard card13 = builder
                .description("Get out of Jail Free. This card may be kept until needed, or traded/sold")
                .outOfJail(true)
                .build();
        cards.add(card13);

        // Instantiate all Chance Squares and give them the correct chance cards
        ChanceCardSquare square1 = new ChanceCardSquare(7, "Chance", SquareType.CHANCE, cards);
        ChanceCardSquare square2 = new ChanceCardSquare(22, "Chance", SquareType.CHANCE, cards);
        ChanceCardSquare square3 = new ChanceCardSquare(36, "Chance", SquareType.CHANCE, cards);
    }

    // METHODS
    @Override
    public List<ChanceCardSquare> getSquares() {
        return squares;
    }
}
