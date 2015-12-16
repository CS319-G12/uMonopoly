package models.help;

import gui.HelpScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author buseburcu
 */
public class Help {

    // ATTRIBUTES
    private List<HelpItem> helpItems;
    private HelpScreen helpScreen;

    // CONSTRUCTOR
    public Help(HelpItem... items) {
        this.helpItems = new ArrayList<>(Arrays.asList(items));
        this.helpScreen = new HelpScreen(this);
    }

    // METHODS
    public HelpItem getItemAt(int index) {
        return helpItems.get(index);
    }

    public HelpScreen getView() {
        return helpScreen;
    }

    public List<HelpItem> getHelpItems() {
        return helpItems;
    }
}
