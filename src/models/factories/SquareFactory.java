package models.factories;

import models.Rules;
import models.squares.*;

import java.util.*;

/**
 * @author Alper Önder
 */
public class SquareFactory {
    public List<Square> getSquares() {
        List<Square> list;

        list = new ArrayList<>(Rules.SQUARE_COUNT);
        for (int i = 0; i < Rules.SQUARE_COUNT; i++) {
            list.add(null);
        }

        Square go = new Square(Rules.GO_POSITION, "GO", SquareType.GO);
        Square jailVisitor = new Square(Rules.JAIL_VISITOR_POSITION, "JAIL VISITOR", SquareType.JAIL_VISITOR);
        Square freeParking = new Square(Rules.FREE_PARKING_POSITION, "FREE PARKING", SquareType.FREE_PARKING);
        Square jail = new Square(Rules.JAIL_POSITION, "JAIL", SquareType.JAIL);

        TaxSquare tax1 = new TaxSquare(4, "INCOME TAX", 200);
        TaxSquare tax2 = new TaxSquare(38, "LUXURY TAX", 75);

        Set<TownSquare> towns = new TownFactory().makeSquares();
        Set<UtilitySquare> utilities = new UtilityFactory().makeSquares();
        Set<RailroadsSquare> railroads = new RailroadsFactory().makeSquares();
        Set<ChanceCardSquare> chances = new ChanceFactory().makeSquares();
        Set<CommunityChestCardSquare> communities = new CommunityChestFactory().makeSquares();

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
        return list;
    }
}
