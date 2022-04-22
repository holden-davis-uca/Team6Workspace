//Chris Stinson - Team 6
package ClientGUI;

import java.awt.*;
import javax.swing.*;
import ClientCommunication.*;

public class CreatePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Private data fields for the important GUI components.
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordVerifyField;
	private JLabel errorLabel;
	private JLabel titleLabel;

	// Getter for the text in the username field.
	public String getUsername() {
		return usernameField.getText();
	}

	// Getter for the text in the password field.
	public String getPassword() {
		return new String(passwordField.getPassword());
	}

	// Getter for the text in the second password field.
	public String getPasswordVerify() {
		return new String(passwordVerifyField.getPassword());
	}

	// Setter for the error text.
	public void setError(String error) {
		errorLabel.setText(error);
	}

	// Constructor for the create account panel.
	public CreatePanel(CreateControl cc) {
		// Create the controller and set it in the chat client.
		// CreateAccountControl controller = new CreateAccountControl(container,
		// client);
		// client.setCreateAccountControl(controller);

		// Create a panel for the labels at the top of the GUI.
		JPanel labelPanel = new JPanel(new GridLayout(4, 1, 5, 5));
		errorLabel = new JLabel("", SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		titleLabel = new JLabel("BattleShip - Create", SwingConstants.CENTER);
	    titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel instructionLabel = new JLabel("Enter a username and password to create an account.",
				SwingConstants.CENTER);
		JLabel instructionLabel2 = new JLabel("Your password must be at least 10 characters.", SwingConstants.CENTER);
		labelPanel.add(errorLabel);
		labelPanel.add(titleLabel);
		labelPanel.add(instructionLabel);
		labelPanel.add(instructionLabel2);

		// Create a panel for the account information form.
		JPanel accountPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		JLabel usernameLabel = new JLabel("Username:", SwingConstants.RIGHT);
		usernameField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
		passwordField = new JPasswordField(10);
		JLabel passwordVerifyLabel = new JLabel("Verify Password:", SwingConstants.RIGHT);
		passwordVerifyField = new JPasswordField(10);
		accountPanel.add(usernameLabel);
		accountPanel.add(usernameField);
		accountPanel.add(passwordLabel);
		accountPanel.add(passwordField);
		accountPanel.add(passwordVerifyLabel);
		accountPanel.add(passwordVerifyField);

		// Create a panel for the buttons.
		JPanel buttonPanel = new JPanel();
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(cc);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(cc);
		buttonPanel.add(submitButton);
		buttonPanel.add(cancelButton);

		// Arrange the three panels in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
		grid.add(labelPanel);
		grid.add(accountPanel);
		grid.add(buttonPanel);
		this.add(grid);
	}

}
