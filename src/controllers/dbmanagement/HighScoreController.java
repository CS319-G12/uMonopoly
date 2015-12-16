package controllers.dbmanagement;

import models.HighScores;

import java.util.List;

/**
 * @author anikristo
 */
public class HighScoreController {

    // ATTRIBUTES
    private List<HighScores> listOfHighScores;
    private DatabaseHelper helper;

    // CONSTRUCTOR
    public HighScoreController() {
        helper = new DatabaseHelper();
        listOfHighScores = helper.getHighScoresFromDB();
    }

    // METHODS
    public List<HighScores> getHighScores() {
        if (helper.hasChanged()) {
            listOfHighScores = helper.getHighScoresFromDB();
        }
        return listOfHighScores;
    }

    public boolean hasChanged() {
        return helper.hasChanged();
    }
}
