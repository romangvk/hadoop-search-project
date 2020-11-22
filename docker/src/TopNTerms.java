package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class TopNTerms extends JPanel {

	private JTextField txtN;

	/**
	 * Create the panel.
	 */
	public TopNTerms(final CardLayout navigation, final JPanel parent) {
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
		
		txtN = new JTextField();
		txtN.setMaximumSize(new Dimension(217, 24));
		txtN.setHorizontalAlignment(SwingConstants.LEFT);
		txtN.setColumns(15);
		panel.add(txtN);
		
		JButton btnView = new JButton("View");
		panel.add(btnView);
		
		JTextArea txtrResults = new JTextArea();
		txtrResults.setText("Results");
		txtrResults.setEditable(false);
		add(txtrResults);
	}

}
