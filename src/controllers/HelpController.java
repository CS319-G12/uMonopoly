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
