package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;

public class Cards extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cards frame = new Cards();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Cards() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        final JPanel cards;

        final CardLayout navigation = new CardLayout();
        cards = new JPanel(navigation);

        LoadFiles l = new LoadFiles(navigation, cards);
        cards.add(l, "loadfiles");

        Actions a = new Actions(navigation, cards);
        cards.add(a, "actions");

        SearchTerm s = new SearchTerm(navigation, cards);
        cards.add(s, "search");

        TopNTerms t = new TopNTerms(navigation, cards);
        cards.add(t, "topn");

        navigation.show(cards, "loadfiles");
        contentPane.add(cards);
    }
}
