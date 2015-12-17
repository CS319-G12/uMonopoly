package models.cards;

/**
 * @author Ani Kristo
 */
public class CommunityChestCardBuilder {

    // ATTRIBUTES
    private int amount;
    private boolean jail;
    private boolean outOfJail;
    private int getEach;

    // CONSTRUCTOR
    public CommunityChestCardBuilder() {
        init();
    }

    // METHODS
    public CommunityChestCardBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public CommunityChestCardBuilder jail(boolean jail) {
        this.jail = jail;
        return this;
    }

    public CommunityChestCardBuilder outOfJail(boolean outOfJail) {
        this.outOfJail = outOfJail;
        return this;
    }

    public CommunityChestCardBuilder getEach(int getEach) {
        this.getEach = getEach;
        return this;
    }

    public CommunityChestCard build(String desc) {
        CommunityChestCard card = new CommunityChestCard(amount, jail, outOfJail, desc, getEach);
        init();
        return card;
    }

    private void init() {
        amount = 0;
        jail = false;
        outOfJail = false;
        getEach = 0;
    }


}
