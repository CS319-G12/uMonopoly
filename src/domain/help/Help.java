package domain.help;

import gui.HelpView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author buseburcu
 */
public class Help {

    // ATTRIBUTES
    private List<HelpItem> helpItems;
    private HelpView helpView; // TODO fix this

    // CONSTRUCTOR
    public Help(HelpView view, HelpItem... items) {
        this.helpView = view;
        this.helpItems = new ArrayList<>(Arrays.asList(items));
    }

    // METHODS
    public HelpItem getItemAt(int index) {
        return helpItems.get(index);
    }
}
