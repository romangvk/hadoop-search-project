package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class LoadFiles extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoadFiles(final CardLayout navigation, final JPanel parent) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel lblChooseYourWriters = new JLabel("Choose your writer(s)");
		lblChooseYourWriters.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChooseYourWriters.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblChooseYourWriters);

		JCheckBox chckbxHugo = new JCheckBox("Hugo");
		add(chckbxHugo);

		JCheckBox chckbxShakespeare = new JCheckBox("Shakespeare");
		add(chckbxShakespeare);

		JCheckBox chckbxTolstoy = new JCheckBox("Tolstoy");
		add(chckbxTolstoy);

		JButton btnGenerateInvertedIndices = new JButton("Generate inverted indices");
		btnGenerateInvertedIndices.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGenerateInvertedIndices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navigation.show(parent, "actions");
			}
		});
		add(btnGenerateInvertedIndices);

	}

}