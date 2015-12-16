package models.factories;

import models.cards.CommunityChestCard;
import models.cards.CommunityChestCardBuilder;
import models.squares.CommunityChestCardSquare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alper Önder
 */
public class CommunityChestFactory implements BonusFactory {

    private final Set<CommunityChestCardSquare> squares;

    // CONSTRUCTOR
    public CommunityChestFactory(){
        List<CommunityChestCard> cards = new ArrayList<>();
        squares = new HashSet<>();

        CommunityChestCardBuilder builder = new CommunityChestCardBuilder();
        CommunityChestCard card1 = builder
                .amount(200)
                .build("Advance to Go. Collect $200");
        cards.add(card1);

        CommunityChestCard card2 = builder
                .amount(200)
                .build("Bank error in your favor. Collect $200");
        cards.add(card2);

        CommunityChestCard card3 = builder
                .amount(-50)
                .build("Doctor's fees. Pay $50");
        cards.add(card3);

        CommunityChestCard card4 = builder
                .amount(50)
                .build("From sale of stock you get $50");
        cards.add(card4);

        CommunityChestCard card5 = builder
                .outOfJail(true)
                .build("Get Out Of Jail Free. This card may be kept until needed and used to go out of the jail for free.");
        cards.add(card5);

        CommunityChestCard card6 = builder
                .jail(true)
                .build("Go to Jail directly. Do not pass Go, do not collect $200");
        cards.add(card6);

        CommunityChestCard card7 = builder
                .amount(50)
                .getEach(50)
                .build("Grand Opera Night. Collect $50 from every player for opening night seats");
        cards.add(card7);

        CommunityChestCard card8 = builder
                .amount(100)
                .getEach(50)
                .build("Holiday Fund matures. Receive $100");
        cards.add(card8);

        CommunityChestCard card9 = builder
                .amount(20)
                .build("Income tax refund. Collect $20");
        cards.add(card9);

        CommunityChestCard card10 = builder
                .amount(10)
                .getEach(10)
                .build("It's you birthday. Collect 10$ from each player. ");
        cards.add(card10);

        CommunityChestCard card11 = builder
                .amount(100)
                .build("Life insurance matures. Collect $100");
        cards.add(card11);

        CommunityChestCard card12 = builder
                .amount(-100)
                .build("Pay hospital fees of $100");
        cards.add(card12);

        CommunityChestCard card13 = builder
                .amount(-150)
                .build("Pay school fees of $150");
        cards.add(card13);

        CommunityChestCard card14 = builder
                .amount(25)
                .build("Receive $25 consultancy fee");
        cards.add(card14);

        CommunityChestCard card15 = builder
                .amount(10)
                .build("You have won second prize in a beauty contest. Collect $10");
        cards.add(card15);

        CommunityChestCard card16 = builder
                .amount(100)
                .build("You inherit $100");
        cards.add(card16);

        CommunityChestCardSquare square1 = new CommunityChestCardSquare(2, cards);
        CommunityChestCardSquare square2 = new CommunityChestCardSquare(17, cards);
        CommunityChestCardSquare square3 = new CommunityChestCardSquare(33, cards);

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
