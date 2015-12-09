package controllers.dbmanagement;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Alper Önder
 * DatabaseHelper is the connection class between the application and uMonopoly's SQLite database.
 * This class gets high scores from database and sort the high scores, adds new HighScore and delete
 * selected High Score or delete all High Scores.
 */
public class DatabaseHelper {

    // ATTRIBUTES
    private ArrayList<HighScores> theHighScores;
    private Connection dbConnection;
    private Statement  stmt;

    // CONSTRUCTOR
    public DatabaseHelper(){
        theHighScores = new ArrayList<HighScores>();
        dbConnection  = null;
        stmt          = null;
    }

    // METHODS
    /**
     * @post self.dbConnection.isClosed()
     * @post self.stmt.isClosed()
     * @post self.dbConnection.isCommited()
     */
    public ArrayList<HighScores> getHighScoresFromDB()
    {
        if(theHighScores.size() > 0)
            theHighScores.clear();
        dbConnection = null;
        stmt         = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:uMonopolyDB");
            dbConnection.setAutoCommit(false);
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HighScores;");
            while(rs.next())
                theHighScores.add(new HighScores(rs.getInt("ID"), rs.getString("Name"), rs.getString("TokenFigure"), rs.getInt("Amount"), rs.getString("Date")));
            //rs.close(); TODO
            stmt.close();
            dbConnection.commit();
            dbConnection.close();
            sortingHighScores();
            return theHighScores;
        }
        catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            JOptionPane.showMessageDialog(null,
                    "High Scores cannot be loaded from Database!",
                    "Database Error! (Reading)",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * @param name is the name of the player won
     * @param tokenFigure is used token by player won
     * @param amount is the money which is had by player won
     * @param date is the date the game played
     * @post self.dbConnection.isClosed()
     * @post self.stmt.isClosed()
     * @post self.dbConnection.isCommited()
     */
    public void insertHighScoreToDB(String name, String tokenFigure, int amount, String date)
    {
        dbConnection = null;
        stmt         = null;
        String insertSQL;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:uMonopolyDB");
            dbConnection.setAutoCommit(false);
            stmt = dbConnection.createStatement();
            insertSQL = "INSERT INTO HighScores (Name,TokenFigure,Amount,Date) "
                    + "VALUES ('" + name + "', '" + tokenFigure + "', " + amount + ", '" + date + "');";
            stmt.executeUpdate(insertSQL);
            //rs.close(); TODO
            stmt.close();
            dbConnection.commit();
            dbConnection.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            JOptionPane.showMessageDialog(null,
                    "High Score cannot be written to Database!",
                    "Database Error! (Writing)",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param selectedID is the id of the score which is selected for deleting
     * @post self.dbConnection.isClosed()
     * @post self.stmt.isClosed()
     * @post self.dbConnection.isCommited()
     */
    public void removeHighScoreFromDB(int selectedID) // 0 means remove All
    {
        dbConnection = null;
        stmt         = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:uMonopolyDB");
            dbConnection.setAutoCommit(false);
            stmt = dbConnection.createStatement();
            if(selectedID == 0) // Delete All Items
                stmt.executeUpdate("DELETE FROM HighScores;");
            else // Delete Selected Items
                stmt.executeUpdate("DELETE FROM HighScores WHERE ID =" + selectedID + ";");
            //rs.close();
            stmt.close();
            dbConnection.commit();
            dbConnection.close();
        }
        catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            JOptionPane.showMessageDialog(null,
                    "High Scores cannot be found or cannot be removed from Database!",
                    "Database Error! (Removing)",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sortingHighScores(){
        Collections.sort(theHighScores, new Comparator<HighScores>() {
            @Override
            public int compare(HighScores hs1, HighScores hs2)
            {
                return hs2.getAmount() - hs1.getAmount();
            }
        });
    }
}
