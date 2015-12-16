package gui;

import models.help.HelpItem;

import javax.swing.*;

/**
 * @author Ani Kristo
 */
public class HelpItemView {
    private JPanel mainPn;
    private JTextArea helpContent;
    private JLabel titleLb;

    public HelpItemView(HelpItem item) {
        helpContent.setText(item.getDescription());
        helpContent.setLineWrap(true);
        titleLb.setText(item.getTitle());
    }

    public JPanel getContent() {
        return mainPn;
    }
}
