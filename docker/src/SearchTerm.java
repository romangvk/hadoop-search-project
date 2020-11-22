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
import javax.swing.JTextArea;

public class SearchTerm extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchTerm(final CardLayout navigation, final JPanel parent) {
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
		
		JTextField txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtSearch);
		txtSearch.setColumns(15);
		txtSearch.setMaximumSize( txtSearch.getPreferredSize() );
		
		JButton btnSearch = new JButton("Search");
		
		panel.add(btnSearch);
		
		JTextArea txtResults = new JTextArea();
		txtResults.setEditable(false);
		txtResults.setText("Results");
		add(txtResults);
	}

}
