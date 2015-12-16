package models.factories;

import models.cards.ChanceCard;
import models.cards.ChanceCardBuilder;
import models.squares.ChanceCardSquare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ani Kristo
 */
public class ChanceFactory implements BonusFactory {

    private final Set<ChanceCardSquare> squares;

    // CONSTRUCTOR
    public ChanceFactory() {

        List<ChanceCard> cards = new ArrayList<>();
        squares = new HashSet<>();

        // Instantiate all Chance Cards
        ChanceCardBuilder builder = new ChanceCardBuilder();
        ChanceCard card1 = builder
                .amount(200)
                .build("Advance to GO and collect 200$.");
        cards.add(card1);

        ChanceCard card2 = builder
                .goTo(24)
                .build("Advance to Illinois Avenue. If you pass GO, collect 200$");
        cards.add(card2);

        ChanceCard card3 = builder
                .goTo(11)
                .build("Advance to St. Charles Place. If you pass GO, collect 200$");
        cards.add(card3);

        ChanceCard card4 = builder
                .build("Advance to Electric Company utility square." +
                        "If unowned, you may buy it from the Bank. If owned, then" +
                        "pay the rent accordingly.");
        cards.add(card4);

        ChanceCard card5 = builder
                .amount(50)
                .build("Bank pays you dividend of $50");
        cards.add(card5);

        ChanceCard card6 = builder
                .goTo(-3)
                .build("Go Back 3 Spaces");
        cards.add(card6);

        ChanceCard card7 = builder
                .outOfJail(true)
                .goTo(30)
                .build("Go to Jail directly. Do not pass Go, do not collect $200");
        cards.add(card7);

        ChanceCard card8 = builder
                .payPerHouse(25)
                .payPerHotel(100)
                .build("Make general repairs on all your property.For each house pay $25, for each hotel $100");
        cards.add(card8);

        ChanceCard card9 = builder
                .amount(-15)
                .build("Pay poor tax of $15");
        cards.add(card9);


        ChanceCard card10 = builder
                .goTo(5)
                .build("Take a trip to Reading Railroad. If you pass Go, collect $200");
        cards.add(card10);

        ChanceCard card11 = builder
                .amount(150)
                .build("Your building loan matures. Collect $150");
        cards.add(card11);


        ChanceCard card12 = builder
                .amount(100)
                .build("You have won a crossword competition. Collect $100");
        cards.add(card12);

        ChanceCard card13 = builder
                .outOfJail(true)
                .build("Get out of Jail Free. This card may be kept until needed, or traded/sold");
        cards.add(card13);

        // Instantiate all Chance Squares and give them the correct chance cards
        ChanceCardSquare square1 = new ChanceCardSquare(7, cards);
        ChanceCardSquare square2 = new ChanceCardSquare(22, cards);
        ChanceCardSquare square3 = new ChanceCardSquare(36, cards);

        squares.add(square1);
        squares.add(square2);
        squares.add(square3);
    }

    // METHODS
    @Override
    public Set<ChanceCardSquare> getSquares() {
        return squares;
    }
}
