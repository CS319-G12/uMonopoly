package models.cards;

/**
 * @author anikristo
 */
public class ChanceCardBuilder {

    // ATTRIBUTES
    private int amount;
    private boolean jail;
    private boolean outOfJail;
    private String desc;
    private int goTo;
    private int payPerHouse;
    private int payPerHotel;

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

    public ChanceCardBuilder description(String desc) {
        this.desc = desc;
        return this;
    }

    public ChanceCardBuilder goTo(int goTo) {
        this.goTo = goTo;
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

    public ChanceCard build() {
        return new ChanceCard(amount, jail, outOfJail, desc, goTo, payPerHouse, payPerHotel);
    }
}
