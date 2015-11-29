package domain.help;

/**
 * @author buseburcu
 */
public class HelpController {

    // ATTRIBUTES
    private int currentItem;
    private Help helpModel;


    // CONSTRUCTOR
    public HelpController(Help helpModel) {
        this.helpModel = helpModel;
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
        return helpModel.getItemAt(currentItem--);
    }

    public HelpItem getItemAt(int index) {
        return helpModel.getItemAt(index);
    }
}
