//Riley Williams - Team 6
package ClientGUI;

import java.awt.*;
import javax.swing.*;
import ClientCommunication.*;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 0L;
	private JButton createButton;
	private JButton loginButton;
	private JLabel titleLabel;

	public StartPanel(StartControl sc) {

		JPanel grid = new JPanel();
		GridBagLayout gbl_grid = new GridBagLayout();
		gbl_grid.columnWidths = new int[] { 450, 0 };
		gbl_grid.rowHeights = new int[] { 60, 0, 0, 60, 0, 0, 60, 60, 60, 0 };
		gbl_grid.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_grid.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		grid.setLayout(gbl_grid);
		// Create the title
		titleLabel = new JLabel("BattleShip");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 2;
		grid.add(titleLabel, gbc_titleLabel);

		// Create the login button
		loginButton = new JButton("Login");
		loginButton.addActionListener(sc);
		JPanel buffer = new JPanel();
		buffer.add(loginButton);
		GridBagConstraints gbc_loginButtonBuffer = new GridBagConstraints();
		gbc_loginButtonBuffer.fill = GridBagConstraints.BOTH;
		gbc_loginButtonBuffer.insets = new Insets(0, 0, 5, 0);
		gbc_loginButtonBuffer.gridx = 0;
		gbc_loginButtonBuffer.gridy = 3;
		grid.add(buffer, gbc_loginButtonBuffer);

		// Create the create account button
		createButton = new JButton("Create");
		createButton.addActionListener(sc);
		buffer.add(createButton);

		this.add(grid);

		this.setSize(500, 500);
		this.setVisible(true);
	}
}
