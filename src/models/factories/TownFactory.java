package models.factories;

import gui.Color;
import models.cards.TownCard;
import models.squares.PropertyGroup;
import models.squares.PropertyGroupType;
import models.squares.TownSquare;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ani Kristo, Alper Önder
 */
public class TownFactory implements PropertyFactory {

    // ATTRIBUTES
    private Set<TownSquare> squares;

    // CONSTRUCTOR
    public TownFactory() {

        // Instantiates the property cards
        TownCard card1 = new TownCard("MEDITERRANEAN AVENUE", Color.BROWN, 60, 30, 4, 10, 30, 90, 160, 250, 50, 50);
        TownCard card2 = new TownCard("BALTIC AVENUE", Color.BROWN, 60, 30, 4, 20, 60, 180, 320, 450, 50, 50);
        TownCard card3 = new TownCard("ORIENTAL AVENUE", Color.LIGHT_BLUE, 100, 50, 6, 30, 90, 270, 400, 550, 50, 50);
        TownCard card4 = new TownCard("VERMONT AVENUE", Color.LIGHT_BLUE, 100, 50, 6, 30, 90, 270, 400, 550, 50, 50);
        TownCard card5 = new TownCard("CONNECTICUT AVENUE", Color.LIGHT_BLUE, 120, 60, 8, 40, 100, 300, 450, 600, 50, 50);
        TownCard card6 = new TownCard("ST. CHARLES PLACE", Color.PINK, 140, 70, 10, 50, 150, 450, 625, 750, 100, 100);
        TownCard card7 = new TownCard("STATES AVENUE", Color.PINK, 140, 70, 10, 50, 150, 450, 625, 750, 100, 100);
        TownCard card8 = new TownCard("VIRGINIA AVENUE", Color.PINK, 160, 80, 60, 12, 180, 500, 700, 900, 100, 100);
        TownCard card9 = new TownCard("ST. JAMES PLACE", Color.ORANGE, 180, 90, 14, 70, 200, 500, 750, 950, 100, 100);
        TownCard card10 = new TownCard("TENNESSEE AVENUE", Color.ORANGE, 180, 90, 14, 70, 200, 550, 750, 950, 100, 100);
        TownCard card11 = new TownCard("NEW YORK AVENUE", Color.ORANGE, 200, 100, 16, 80, 220, 600, 800, 1000, 100, 100);
        TownCard card12 = new TownCard("KENTUCKY AVENUE", Color.RED, 220, 110, 18, 90, 250, 700, 875, 1050, 150, 150);
        TownCard card13 = new TownCard("INDIANA AVENUE", Color.RED, 220, 110, 18, 90, 250, 700, 875, 1050, 150, 150);
        TownCard card14 = new TownCard("ILLINOIS AVENUE", Color.RED, 240, 120, 20, 100, 300, 750, 925, 1100, 150, 150);
        TownCard card15 = new TownCard("ATLANTIC AVENUE", Color.YELLOW, 260, 130, 22, 110, 330, 800, 975, 1150, 150, 150);
        TownCard card16 = new TownCard("VENTNOR AVENUE", Color.YELLOW, 260, 130, 22, 110, 330, 800, 975, 1150, 150, 150);
        TownCard card17 = new TownCard("MARVIN GARDENS", Color.YELLOW, 280, 140, 24, 120, 360, 850, 1025, 1200, 150, 150);
        TownCard card18 = new TownCard("PACIFIC AVENUE", Color.GREEN, 300, 150, 26, 130, 390, 900, 1100, 1275, 150, 150);
        TownCard card19 = new TownCard("NORTH CAROLINA AVENUE", Color.GREEN, 300, 150, 26, 130, 390, 900, 1100, 1275, 200, 200);
        TownCard card20 = new TownCard("PENNSYLVANIA AVENUE", Color.GREEN, 320, 160, 28, 150, 450, 1000, 1200, 1400, 200, 200);
        TownCard card21 = new TownCard("PARK PLACE", Color.BLUE, 350, 175, 35, 175, 500, 1100, 1300, 1500, 200, 200);
        TownCard card22 = new TownCard("BOARDWALK", Color.BLUE, 400, 200, 50, 200, 600, 1400, 1700, 2000, 200, 200);

        // Instantiate the squares
        TownSquare square1 = new TownSquare(1, card1);
        TownSquare square2 = new TownSquare(3, card2);
        TownSquare square3 = new TownSquare(6, card3);
        TownSquare square4 = new TownSquare(8, card4);
        TownSquare square5 = new TownSquare(9, card5);
        TownSquare square6 = new TownSquare(11, card6);
        TownSquare square7 = new TownSquare(13, card7);
        TownSquare square8 = new TownSquare(14, card8);
        TownSquare square9 = new TownSquare(16, card9);
        TownSquare square10 = new TownSquare(18, card10);
        TownSquare square11 = new TownSquare(19, card11);
        TownSquare square12 = new TownSquare(21, card12);
        TownSquare square13 = new TownSquare(23, card13);
        TownSquare square14 = new TownSquare(24, card14);
        TownSquare square15 = new TownSquare(26, card15);
        TownSquare square16 = new TownSquare(27, card16);
        TownSquare square17 = new TownSquare(29, card17);
        TownSquare square18 = new TownSquare(31, card18);
        TownSquare square19 = new TownSquare(32, card19);
        TownSquare square20 = new TownSquare(34, card20);
        TownSquare square21 = new TownSquare(37, card21);
        TownSquare square22 = new TownSquare(39, card22);

        squares = new HashSet<>();
        squares.add(square1);
        squares.add(square2);
        squares.add(square3);
        squares.add(square4);
        squares.add(square5);
        squares.add(square6);
        squares.add(square7);
        squares.add(square8);
        squares.add(square9);
        squares.add(square10);
        squares.add(square11);
        squares.add(square12);
        squares.add(square13);
        squares.add(square14);
        squares.add(square15);
        squares.add(square16);
        squares.add(square17);
        squares.add(square18);
        squares.add(square19);
        squares.add(square20);
        squares.add(square21);
        squares.add(square22);

        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square1,  square2));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square3,  square4,  square5));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square6,  square7,  square8));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square9,  square10, square11));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square12, square13, square14));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square15, square16, square17));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square18, square19, square20));
        new PropertyGroup<TownSquare>(PropertyGroupType.TOWN, Arrays.asList(square21, square22));

    }

    // METHOD
    @Override
    public Set<TownSquare> getSquares() {
        return squares;
    }
}
