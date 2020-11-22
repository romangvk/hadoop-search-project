package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;

public class LoadFiles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadFiles frame = new LoadFiles();
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
	public LoadFiles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblChooseYourWriters = new JLabel("Choose your writer(s)");
		lblChooseYourWriters.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblChooseYourWriters);
		lblChooseYourWriters.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel writers = new JPanel();
		contentPane.add(writers);
		writers.setLayout(new BoxLayout(writers, BoxLayout.Y_AXIS));
		
		JCheckBox chckbxHugo = new JCheckBox("Hugo");
		chckbxHugo.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxHugo.setHorizontalAlignment(SwingConstants.CENTER);
		writers.add(chckbxHugo);
		
		JCheckBox chckbxShakespeare = new JCheckBox("Shakespeare");
		chckbxShakespeare.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxShakespeare.setHorizontalAlignment(SwingConstants.CENTER);
		writers.add(chckbxShakespeare);
		
		JCheckBox chckbxTolstoy = new JCheckBox("Tolstoy");
		chckbxTolstoy.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxTolstoy.setHorizontalAlignment(SwingConstants.CENTER);
		writers.add(chckbxTolstoy);
		
		JButton btnGenerateInvertedIndices = new JButton("Generate inverted indices");
		btnGenerateInvertedIndices.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnGenerateInvertedIndices);
	}

}
