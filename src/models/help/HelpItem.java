package models.help;

/**
 * @author buseburcu
 */
public class HelpItem {

    // ATTRIBUTES
    private String title;
    private String description;

    // CONSTRUCTOR
    public HelpItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // METHODS
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
