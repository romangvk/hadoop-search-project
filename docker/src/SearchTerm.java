package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JTextArea;

public class SearchTerm extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchTerm frame = new SearchTerm();
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
	public SearchTerm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtSearch);
		txtSearch.setColumns(15);
		txtSearch.setMaximumSize( txtSearch.getPreferredSize() );
		
		JButton btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		JTextArea txtrResults = new JTextArea();
		txtrResults.setEditable(false);
		txtrResults.setText("Results");
		contentPane.add(txtrResults);
	}

}
