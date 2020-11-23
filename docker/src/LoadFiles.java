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
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class LoadFiles extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoadFiles(final CardLayout navigation, final JPanel parent, final Cluster cluster) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel lblChooseYourWriters = new JLabel("Choose your writer(s)");
		lblChooseYourWriters.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChooseYourWriters.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblChooseYourWriters);

		final JRadioButton rdbtnHugo = new JRadioButton("Hugo");
		rdbtnHugo.setSelected(true);
		add(rdbtnHugo);

		final JRadioButton rdbtnShakespeare = new JRadioButton("Shakespeare");
		add(rdbtnShakespeare);

		final JRadioButton rdbtnTolstoy = new JRadioButton("Tolstoy");
		add(rdbtnTolstoy);

		final JRadioButton rdbtnAll = new JRadioButton("All of the above");
		add(rdbtnAll);

		ButtonGroup writers = new ButtonGroup();
		writers.add(rdbtnHugo);
		writers.add(rdbtnShakespeare);
		writers.add(rdbtnTolstoy);
		writers.add(rdbtnAll);

		JButton btnGenerateInvertedIndices = new JButton("Generate inverted indices");
		btnGenerateInvertedIndices.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGenerateInvertedIndices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAll.isSelected())
					cluster.setAllFiles();
				else
					cluster.setFiles(rdbtnHugo.isSelected(), rdbtnShakespeare.isSelected(), rdbtnTolstoy.isSelected());
				// do inverted indices
				navigation.show(parent, "actions");
			}
		});
		add(btnGenerateInvertedIndices);

	}

}