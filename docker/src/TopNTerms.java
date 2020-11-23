package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class TopNTerms extends JPanel {

	private int n;

	/**
	 * Create the panel.
	 */
	public TopNTerms(final CardLayout navigation, final JPanel parent, final Cluster cluster) {
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

		final JTextField txtN = new JTextField();
		txtN.setMaximumSize(new Dimension(217, 24));
		txtN.setHorizontalAlignment(SwingConstants.LEFT);
		txtN.setColumns(15);
		panel.add(txtN);
		
		final JButton btnView = new JButton("View");
		panel.add(btnView);

		final JTextArea txtResults = new JTextArea();
		txtResults.setText("Results");
		txtResults.setEditable(false);
		add(txtResults);

		txtN.getDocument().addDocumentListener(new DocumentListener() {

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
				try {
					n = Integer.parseInt(txtN.getText());
					lblValidator.setText("");
					btnView.setEnabled(true);
				} catch (NumberFormatException error) {
					lblValidator.setText("!");
					btnView.setEnabled(false);
				}
			}
		});

		btnView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtResults.setText(cluster.top(n));
			}
		});
	}

}
