package gui;

import models.help.Help;
import models.help.HelpItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;

/**
 * @author Ani Kristo
 */
public class HelpScreen extends Observable {

    // ATTRIBUTES
    private JPanel mainPn;
    private JLabel titleLb;
    private JButton backBtn;

    // CONSTRUCTOR
    public HelpScreen(Help help) {

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        List<HelpItem> items = help.getHelpItems();
        for (HelpItem item : items) {
            content.add(new HelpItemView(item).getContent());
            content.add(Box.createVerticalStrut(20));
        }

        JScrollPane scrollPn = new JScrollPane(content);
        scrollPn.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        mainPn.add(scrollPn, BorderLayout.CENTER);

        titleLb.setBorder(BorderFactory.createEmptyBorder(15, 34, 34, 0));

        backBtn.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers(Window.NotificationMsg.BACK);
        });

        SwingUtilities.invokeLater(() -> scrollPn.getVerticalScrollBar().setValue(0));
    }

    // METHODS
    public JPanel getContent(boolean sourceIsGameScreen) {
        if (sourceIsGameScreen)
            backBtn.setVisible(false);
        else
            backBtn.setVisible(true);
        return mainPn;
    }
}
