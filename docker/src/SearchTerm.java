package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SearchTerm extends JPanel {

	private String term;

	/**
	 * Create the panel.
	 */
	public SearchTerm(final CardLayout navigation, final JPanel parent, final Cluster cluster) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JButton btnBack = new JButton("Back");
		btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navigation.show(parent, "actions");
			}
		});
		add(btnBack);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		final JLabel lblValidator = new JLabel("");
		lblValidator.setForeground(Color.red);
		panel.add(lblValidator);

		final JTextField txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtSearch);
		txtSearch.setColumns(15);
		txtSearch.setMaximumSize(txtSearch.getPreferredSize());

		final JButton btnSearch = new JButton("Search");
		btnSearch.setEnabled(false);
		panel.add(btnSearch);

		final JTextArea txtResults = new JTextArea();
		txtResults.setEditable(false);
		txtResults.setText("Results");
		add(txtResults);

		txtSearch.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				check();
			}

			public void insertUpdate(DocumentEvent arg0) {
				check();
			}

			public void removeUpdate(DocumentEvent arg0) {
				check();
			}

			public void check() {
				term = txtSearch.getText();
				String txt = "";
				for (String word : term.split(" ", 0)) {
					txt += word + '\n';
				}
				txtResults.setText(txt);
				if (term.split(" ", 0).length != 1) {
					lblValidator.setText("!");
					btnSearch.setEnabled(false);
				} else {
					lblValidator.setText("");
					btnSearch.setEnabled(true);
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtResults.setText(cluster.search(term));
			}
		});
	}

}
