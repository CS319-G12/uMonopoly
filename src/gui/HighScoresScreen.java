package gui;

import controllers.dbmanagement.HighScoreController;
import models.HighScores;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;

/**
 * @author Ani Kristo
 */
class HighScoresScreen extends Observable {

    private JPanel mainPn;
    private JButton backBtn;
    private JLabel titleLb;

    // CONSTRUCTOR
    HighScoresScreen(HighScoreController controller) {
        List<HighScores> highScores = controller.getHighScores();

        // Content Panel
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        if (highScores.size() > 0) {
            for (int i = 0; i < highScores.size(); i++) {
                content.add(new HighScoresView(i + 1, highScores.get(i)).getContent());
                content.add(Box.createVerticalStrut(20));
            }
            JScrollPane scrollPn = new JScrollPane(content);
            mainPn.add(scrollPn, BorderLayout.CENTER);
        } else {

            // Empty view
            JLabel emptyLb = new JLabel("<html><center>NO RECORDS YET!</center></html>");
            emptyLb.setFont(new Font(emptyLb.getFont().getFontName(), Font.BOLD, 36));

            // Flow Layout panel
            JPanel emptyPn = new JPanel(new FlowLayout(FlowLayout.CENTER));
            emptyPn.add(emptyLb);
            mainPn.add(emptyPn, BorderLayout.CENTER);
        }

        backBtn.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers(Window.NotificationMsg.BACK);
        });
        titleLb.setBorder(BorderFactory.createEmptyBorder(15, 34, 34, 0));
    }


    // METHODS
    public JPanel getContent() {
        return mainPn;
    }
}
