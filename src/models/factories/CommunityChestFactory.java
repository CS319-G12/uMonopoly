package models.factories;

import models.cards.CommunityChestCard;
import models.cards.CommunityChestCardBuilder;
import models.squares.CommunityChestCardSquare;
import models.squares.SquareType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alper Önder
 */
public class CommunityChestFactory implements BonusFactory {

    // ATTRIBUTES
    List<CommunityChestCard> cards;
    Set<CommunityChestCardSquare> squares;

    // CONSTRUCTOR
    public CommunityChestFactory(){
        cards = new ArrayList<>();
        squares = new HashSet<>();

        CommunityChestCardBuilder builder = new CommunityChestCardBuilder();
        CommunityChestCard card1 = builder.amount(200)
                .description("Advance to Go. Collect $200")
                .build();
        cards.add(card1);

        CommunityChestCard card2 = builder.amount(200)
                .description("Bank error in your favor. Collect $200")
                .build();
        cards.add(card2);

        CommunityChestCard card3 = builder.amount(-50)
                .description("Doctor's fees. Pay $50")
                .build();
        cards.add(card3);

        CommunityChestCard card4 = builder.amount(50)
                .description("From sale of stock you get $50")
                .build();
        cards.add(card4);

        CommunityChestCard card5 = builder.outOfJail(true)
                .description("Get Out Of Jail Free. This card may be kept until needed and used to go out of the jail for free.")
                .build();
        cards.add(card5);

        CommunityChestCard card6 = builder.jail(true)
                .description("Go to Jail directly. Do not pass Go, do not collect $200")
                .build();
        cards.add(card6);

        CommunityChestCard card7 = builder.amount(50)
                .description("Grand Opera Night. Collect $50 from every player for opening night seats")
                .getEach(50)
                .build();
        cards.add(card7);

        CommunityChestCard card8 = builder.amount(100)
                .description("Holiday Fund matures. Receive $100")
                .getEach(50)
                .build();
        cards.add(card8);

        CommunityChestCard card9 = builder.amount(20)
                .description("Income tax refund. Collect $20")
                .build();
        cards.add(card9);

        CommunityChestCard card10 = builder.amount(10)
                .description("It's you birthday. Collect 10$ from each player. ")
                .getEach(10)
                .build();
        cards.add(card10);

        CommunityChestCard card11 = builder.amount(100)
                .description("Life insurance matures. Collect $100")
                .build();
        cards.add(card11);

        CommunityChestCard card12 = builder.amount(-100)
                .description("Pay hospital fees of $100")
                .build();
        cards.add(card12);

        CommunityChestCard card13 = builder.amount(-150)
                .description("Pay school fees of $150")
                .build();
        cards.add(card13);

        CommunityChestCard card14 = builder.amount(25)
                .description("Receive $25 consultancy fee")
                .build();
        cards.add(card14);

        CommunityChestCard card15 = builder.amount(10)
                .description("You have won second prize in a beauty contest. Collect $10")
                .build();
        cards.add(card15);

        CommunityChestCard card16 = builder.amount(100)
                .description("You inherit $100")
                .build();
        cards.add(card16);

        CommunityChestCardSquare square1 = new CommunityChestCardSquare(2, "Community Chest", SquareType.COMMUNITY_CHEST, cards);
        CommunityChestCardSquare square2 = new CommunityChestCardSquare(17, "Community Chest", SquareType.COMMUNITY_CHEST, cards);
        CommunityChestCardSquare square3 = new CommunityChestCardSquare(33, "Community Chest", SquareType.COMMUNITY_CHEST, cards);

        squares.add(square1);
        squares.add(square2);
        squares.add(square3);
    }

    // METHODS
    @Override
    public Set<CommunityChestCardSquare> getSquares() {
        return squares;
    }
}
