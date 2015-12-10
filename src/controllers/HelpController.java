package controllers;

import models.help.Help;
import models.help.HelpItem;

/**
 * @author buseburcu
 */
public class HelpController {

    // ATTRIBUTES
    private int currentItem;
    private Help helpModel;
    private Help help;


    // CONSTRUCTOR
    public HelpController() {

        // Instantiate Help items
        HelpItem item1 = new HelpItem("OBJECT", "The object of the game is to become the wealthiest player through" +
                " buying, renting and selling property\n");

        HelpItem item2 = new HelpItem("PREPARATION", "Place the board on a table and put the Chance and Community Chest " +
                "cards facedown on their allotted spaces on the board. Each player chooses one token to represent himther " +
                "while traveling around the board\n");

        HelpItem item3 = new HelpItem("BANKER", "A Banker who plays in the game must keep hislher personal funds separate " +
                "from those of the Bank.");

        HelpItem item4 = new HelpItem("THE BANK", "the Bank holds the Title Deed cards and houses and hotels prior to purchase" +
                "and use by the players, pays salaries and bonuses and sells and auctions properties and hands out their proper " +
                "Title Deed cards; it sells houses and hotels to the players and loans money when required on mortgages.");

        HelpItem item5 = new HelpItem("THE PLAY", "Starting with the Banker, each player in turn throws the dice. " +
                "The player with the highest total starts the play: Place your token on the corner marked 'GO' throw" +
                "the dice and move your token in the direction of the arrow the number of spaces indicated by the dice. " +
                "After you have completed your play, the turn passes to the left. The tokens remain on the spaces qccupied " +
                "and proceed from that point on the player's next turn. " + "Two or more tokens may rest on the same space at the same time.");

        HelpItem item6 = new HelpItem("GO", "Each time a player's token lands on or passes over GO, whether by throwing the dice or drawing " +
                "a card, the Banker pays himther a $200 salary.");

        HelpItem item7 = new HelpItem("BUYING PROPERTY", "Whenever you land on an unowned property you may buy that property from the Bank" +
                "at its printed price. You receive the Title Deed card showing ownership; place it faceup in front of you. ");

        HelpItem item8 = new HelpItem("PAYING RENT", "When you land on property owned by another player, the owner collects rent from you " +
                "in accordance with the list printed on its Title Deed card.");

        HelpItem item9 = new HelpItem("CHANCE AND COMMUNITY CHEST", " When you land on either of these spaces, take the top card from the " +
                "deck indicated, follow the instructions and return the card facedown to the bottom of the deck. ");

        HelpItem item10 = new HelpItem("INCOME TAX", "If you land here you have two options: You may estimate your tax at $900 and pay " +
                "the Bank, or you may pay 10% of your total worth to the Bank. Your total worth is all your cash on hand," +
                "printed prices of mortgaged and unmortgaged properties and cost price of all buildings you own.");

        HelpItem item11 = new HelpItem("JAIL", "You land in Jail when. ..(I) your token lands on the space" +
                "marked 'Go to Jail'; (2) you draw a card marked 'Go to Jail'; or (3) you throw doubles three times in succession.");

        HelpItem item12 = new HelpItem("FREE PARKING", "A player landing on this place does not receive any money, " +
                "property or reward of any kind. This is just a 'free' resting place.");

        HelpItem item13 = new HelpItem("HOUSES", "When you own all the propert~es in a color-group you may buy houses" +
                " from the Bank and erect them on those properties.");

        HelpItem item14 = new HelpItem("HOTELS", "When a player has four houses on each property of a complete color-group," +
                " he/she may buy a hotel from the Bank and erect it on any property of the color-group." +
                " He/she returns the four houses from that property to the Bank and pays the price for the hotel as shown" +
                " on the Ttle Deed card.Only one hotel may be erected on any one property");

        HelpItem item15 = new HelpItem("BUILDING SHORTAGES", "When the Bank has no houses to sell, players wishing to build must " +
                "wait for some player to return or sell histher houses to the Bank before building. If there are a limited number of" +
                "houses and hotels available and two or more players wish to buy more than the Bank has, the houses or hotels must be " +
                "sold at auction to the highest bidder.");

        HelpItem item16 = new HelpItem("SELLING PROPERTY", "Unimproved properties, railroads and utilities (but not buildings)" +
                " may be sold to any player as a private transaction for any amount the owner can get; however, no property can be " +
                "sold to - another player if buildings are standing on any properties of that colorgroup." +
                " Any buildings so located must be sold back to the Bank before the owner can sell any property of that color-group. " +
                "Houses and hotels may be sold back to the Bank at any time for onehalf the price paid for them." +
                " All houses on one color-group must be sold one by one, evenly, in reverse of the manner in which they were erected. " +
                "All hotels on one color-group may be sold at once, or they may be sold one house at a time (one hotel equals five houses), " +
                "evenly, in reverse of the manner in which they were erected.");

        HelpItem item17 = new HelpItem("MORTGAGES", "Unimproved properties can be mortgaged through the Bank at any time." +
                " Before an improved property can be mortgaged, all the buildings on all the properties of its color-group" +
                " must be sold back to the Bank at half price. The mortgage value is printed on each Title Deed card. " +
                "No rent can be collected on mortgaged");

        HelpItem item18 = new HelpItem("BANKRUPTCY", "You are declared bankrupt if you owe more than you" +
                "can pay either to another player or to the Bank. If your ,debt is to another player, you must tum over to that" +
                "player all that you have of value and retire from the game");

        HelpItem item19 = new HelpItem("MİSCELLANEOUS", "Money can be loaned to a player only by the Bank and then " +
                "only by mortgaging property. No player may borrow from or lend money to another player.");

        this.helpModel = new Help();
        currentItem = 0;
    }

    // METHODS
    public HelpItem getCurrentItem() {
        return helpModel.getItemAt(currentItem);
    }

    public HelpItem getPreviousItem() {
        return helpModel.getItemAt(currentItem--);
    }

    public HelpItem getNextItem() {
        return helpModel.getItemAt(currentItem++);
    }

    public HelpItem getItemAt(int index) {
        return helpModel.getItemAt(index);
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }
}
