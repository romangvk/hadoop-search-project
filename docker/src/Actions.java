package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Actions extends JPanel {

	/**
	 * Create the panel.
	 */
	public Actions(final CardLayout navigation, final JPanel parent) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel lblChooseAnAction = new JLabel("Choose an action");
		lblChooseAnAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChooseAnAction.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblChooseAnAction);

		JPanel panel = new JPanel();
		add(panel);

		JButton btnSearch = new JButton("Search for a term");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navigation.show(parent, "search");

			}
		});
		add(btnSearch);
		btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton btnTopN = new JButton("Top N Terms");
		btnTopN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navigation.show(parent, "topn");

			}
		});
		add(btnTopN);
		btnTopN.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

}
