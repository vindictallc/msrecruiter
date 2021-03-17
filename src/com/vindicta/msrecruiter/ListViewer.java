package com.vindicta.msrecruiter;

import javax.swing.*;

public class ListViewer extends JFrame {
    JLabel dirLabel;
    JTextField dirPath;
    JButton choose = new JButton("Choose Directory");
    JButton search = new JButton("Search");

    public ListViewer() {
        super("MilSpouse Finder");
        setSize(1200, 800);
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        dirLabel = new JLabel("View PDFs in: ", SwingConstants.LEFT);
        dirPath  = new JTextField(60);

        panel.add(dirLabel);
        panel.add(dirPath);
        panel.add(choose);
        panel.add(search);
        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            //ignore this for default look
        }
    }
}
