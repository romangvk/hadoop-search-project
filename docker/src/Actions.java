package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class Actions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actions frame = new Actions();
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
	public Actions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblChooseAnAction = new JLabel("Choose an action");
		lblChooseAnAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChooseAnAction.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblChooseAnAction);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnSearch = new JButton("Search for a term");
		panel.add(btnSearch);
		btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnTopN = new JButton("Top N Terms");
		panel.add(btnTopN);
		btnTopN.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

}
