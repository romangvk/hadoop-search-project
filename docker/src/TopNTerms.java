package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class TopNTerms extends JFrame {

	private JPanel contentPane;
	private JTextField txtN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopNTerms frame = new TopNTerms();
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
	public TopNTerms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setAlignmentX(0.5f);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
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
		contentPane.add(txtrResults);
	}

}
