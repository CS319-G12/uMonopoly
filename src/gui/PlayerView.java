package gui;

import models.Player;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ani Kristo
 */
public class PlayerView implements Observer {

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel nameLb;
    private JLabel budgetLb;

    private int rank;

    // CONSTRUCTOR
    public PlayerView(int rank, Player p) {
        p.addObserver(this);
        this.rank = rank;
        setNameLb(p);
        setBudgetLb(p);
    }

    // METHODS
    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Player) {
            Player p = (Player) observable;
            setNameLb(p);
            setBudgetLb(p);
            if (p.isPlaying())
                setSelected(true);
            else
                setSelected(false);
        }
    }

    public JPanel getContent() {
        return mainPanel;
    }

    public void setSelected(boolean selected) {
        if (selected)
            mainPanel.setBackground(new java.awt.Color(0xaae0fa));
        else
            mainPanel.setBackground(new java.awt.Color(0xf2f2f2));
    }

    private void setBudgetLb(Player p) {
        this.budgetLb.setText(String.format("%d", p.getBudget()));
    }

    private void setNameLb(Player p) {
        this.nameLb.setText(
                String.format("%d. %s (%s) %s",
                        this.rank,
                        p.getName(),
                        p.getTokenFigure().getName(),
                        p.isInJail() ? "- JAIL" : ""));
    }
}
