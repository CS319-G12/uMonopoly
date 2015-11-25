package gui;

import storage.Rules;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by anikristo on 22-Nov-15.
 */
public class PlayerRegistrationScreen {

    // ATTRIBUTES
    private java.util.List<PlayerRegistrationSection> playerRegSections;
    private JPanel mainPanel;
    private JButton backBtn;
    private JButton nextBtn;
    private JPanel northPn;
    private JLabel titleLb;
    private JLabel subTitleLb;
    private JPanel centerPn;
    private JPanel southPn;
    private JButton plusBtn;

    private int shownPlayerSections;

    // CONSTRUCTOR
    public PlayerRegistrationScreen(){
        super();

        // Fixing North panel alignment
        northPn.setBorder(BorderFactory.createEmptyBorder(68, 0, 0, 0));

        // Declaring LayoutManager for the center panel
        centerPn.setLayout(new BoxLayout(centerPn,BoxLayout.Y_AXIS));

        // Instantiate the sections
        playerRegSections = new ArrayList<>(Rules.MAX_PLAYERS);
        for (int i = 0; i < Rules.MAX_PLAYERS; i++){
            playerRegSections.set(i, new PlayerRegistrationSection(i));
            centerPn.add(playerRegSections.get(i).getContent());
        }

        // Adding the plus button
        plusBtn = new JButton();
        plusBtn.setBorderPainted(false);
        plusBtn.setContentAreaFilled(false);
        plusBtn.setFocusPainted(false);
        plusBtn.setIcon(new ImageIcon("/src/img/playReg_btn_plus.png")); //TODO test the link
        centerPn.add(plusBtn);

        // Adding ActionListeners
        plusBtn.addActionListener(actionEvent -> {
            playerRegSections.get(++shownPlayerSections).setVisible(true);
            // TODO deactivate the selected token
        });
        backBtn.addActionListener(actionEvent -> {
            //TODO go back and lose all info
        });
        backBtn.addActionListener(actionEvent -> {
            //TODO 1. check if everyone has a token selected.
            // TODO 2. Tell GameController to create players with nonempty name
        });

        // making the first section visible
        playerRegSections.get(0).setVisible(true);
        shownPlayerSections = 1;
    }

    // METHODS

}
