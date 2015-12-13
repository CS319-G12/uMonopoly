package models.cards;

/**
 * @author Ani Kristo
 */
public class CommunityChestCardBuilder {

    // ATTRIBUTES
    private int amount;
    private boolean jail;
    private boolean outOfJail;
    private String desc;
    private int getEach;

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

    public CommunityChestCardBuilder description(String desc) {
        this.desc = desc;
        return this;
    }

    public CommunityChestCardBuilder getEach(int getEach) {
        this.getEach = getEach;
        return this;
    }

    public CommunityChestCard build() {
        return new CommunityChestCard(amount, jail, outOfJail, desc, getEach);
    }


}
