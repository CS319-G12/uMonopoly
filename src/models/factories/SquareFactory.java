package models.factories;

import models.Rules;
import models.squares.*;

import java.util.*;

/**
 * @author Alper Önder
 */
public class SquareFactory {

    // ATTRIBUTES
    List<Square> list;

    // CONSTRUCTOR
    public SquareFactory() {
        list = new ArrayList<>(Rules.SQUARE_COUNT);
        for (int i = 0; i < Rules.SQUARE_COUNT; i++) {
            list.add(null);
        }

        Square go = new Square(0, "GO", SquareType.GO);
        Square jailVisitor = new Square(10, "JAIL VISITOR", SquareType.JAIL_VISITOR);
        Square freeParking = new Square(20, "FREE PARKING", SquareType.FREE_PARKING);
        Square jail = new Square(30, "JAIL", SquareType.JAIL);

        TaxSquare tax1 = new TaxSquare(4, "INCOME TAX", 200);
        TaxSquare tax2 = new TaxSquare(38, "LUXURY TAX", 75);

        Set<TownSquare> towns = new TownFactory().getSquares();
        Set<UtilitySquare> utilities = new UtilityFactory().getSquares();
        Set<RailroadsSquare> railroads = new RailroadsFactory().getSquares();
        Set<ChanceCardSquare> chances = new ChanceFactory().getSquares();
        Set<CommunityChestCardSquare> communities = new CommunityChestFactory().getSquares();

        Set<Square> allSquares = new HashSet<>();
        allSquares.add(go);
        allSquares.add(jailVisitor);
        allSquares.add(freeParking);
        allSquares.add(jail);
        allSquares.add(tax1);
        allSquares.add(tax2);
        allSquares.addAll(towns);
        allSquares.addAll(utilities);
        allSquares.addAll(railroads);
        allSquares.addAll(chances);
        allSquares.addAll(communities);

        Square[] array = new Square[Rules.SQUARE_COUNT];
        for (Square s : allSquares) {
            array[s.getPosition()] = s;
        }

        list = Arrays.asList(array);

    }

    // METHOD
    public List<Square> getSquares() {
        return list;
    }
}
