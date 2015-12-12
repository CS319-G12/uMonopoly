package models;

/**
 * @author anikristo
 */
public class Rules {
    // ATTRIBUTES
    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_HOUSE_COUNT = 4;
    public static final int START_BUDGET = 2000;
    public static final int SQUARE_COUNT = 40;


    // INNER CLASSES
    public static class Utilities {
        public static final String ELECTRIC_COMPANY = "ELECTRIC COMPANY";
        public static final String WATER_WORKS = "WATER WORKS";
    }

    public static class Railroads {
        public static final String READING = "READING RAILROAD";
        public static final String PENNSYLVANIA = "PENNSYLVANIA RAILROAD";
        public static final String BO = "B. & O RAILROAD";
        public static final String SHORT_LINE = "SHORT_LINE";
    }
}
