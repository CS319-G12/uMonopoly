package models.cards;

/**
 * @author Ani Kristo
 */
public class ChanceCardBuilder {

    // ATTRIBUTES
    private int amount;
    private boolean jail;
    private boolean outOfJail;
    private int goTo;
    private boolean hasGoTo;
    private int payPerHouse;
    private int payPerHotel;

    // CONSTRUCTOR
    public ChanceCardBuilder() {
        init();
    }

    private void init() {
        amount = 0;
        jail = false;
        outOfJail = false;
        goTo = 0;
        hasGoTo = false;
        payPerHouse = 0;
        payPerHotel = 0;
    }

    // METHODS
    public ChanceCardBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ChanceCardBuilder jail(boolean jail) {
        this.jail = jail;
        return this;
    }

    public ChanceCardBuilder outOfJail(boolean outOfJail) {
        this.outOfJail = outOfJail;
        return this;
    }

    public ChanceCardBuilder goTo(int goTo) {
        this.goTo = goTo;
        this.hasGoTo = true;
        return this;
    }

    public ChanceCardBuilder payPerHouse(int payPerHouse) {
        this.payPerHouse = payPerHouse;
        return this;
    }

    public ChanceCardBuilder payPerHotel(int payPerHotel) {
        this.payPerHotel = payPerHotel;
        return this;
    }

    public ChanceCard build(String desc) {
        ChanceCard card = new ChanceCard(amount, jail, outOfJail, desc, hasGoTo, goTo, payPerHouse, payPerHotel);
        init();
        return card;
    }
}
