//Chris Stinson - Team 6
package ClientCommunication;

import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import ClientGUI.*;

public class PlacingControl implements ActionListener {
	private JPanel container;
	private GameClient client;

	public PlacingControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		PlacingPanel panel = (PlacingPanel) container.getComponent(4);

		if (command.equals("Place Ship")) {
			String shipNum = panel.currShip.getText();
			String location = panel.shipLocation.getText();
			boolean hor = panel.horizontal.isSelected();
			int shipLength = 0;

			//gives a value to shipLength based on ship #
			if (shipNum.equals("Ship 1")) {
				shipLength = 4;
			} else if (shipNum.equals("Ship 2")) {
				shipLength = 3;
			} else if (shipNum.equals("Ship 3")) {
				shipLength = 2;
			}

			//validates the ship placement info
			boolean result = panel.verifyPlacement(location, shipLength, hor);

			if (result) {//if valid
				// save ship data
				HashMap<Character, Integer> map = panel.generateHashMapReverse();
				char x = location.charAt(0);
				char y = location.charAt(1);
				panel.addXCoord(map.get(x));
				panel.addYCoord(Character.getNumericValue(y));
				panel.addIsHorizontal(hor);
				// highlight buttons
				panel.HighlightGrid(location, shipLength, hor);
				// move to next ship
				panel.NextShip(location, hor);
				panel.setErrorLabel("Ship Placed");
			} else {//set error
				if (panel.ship_three_location.getText() != "Location: ") {
					panel.setErrorLabel("All ships have been placed!");
				} else {
					panel.setErrorLabel("Invalid location option. Try again");
				}
			}
			//clears all ship data
		} else if (command.equals("Remove All Ships")) {
			System.out.println("Remove All Ships");
			panel.resetShips();
			
		} else if (command.equals("Start Game!")) {
			//validates that all ships have been placed
			if (!panel.ship_three_location.getText().equals("Location: ")) {
				allShipsPlaced();//build info and send to server
			} else {//set error
				panel.setErrorLabel("Must Set all ships before starting game!");
			}

		}
	}

	public void displayError(String error) {
		PlacingPanel panel = (PlacingPanel) container.getComponent(4);
		panel.setErrorLabel(error);
	}
	
	//sends the ship data to the server
	public void allShipsPlaced() {
		PlacingPanel panel = (PlacingPanel) container.getComponent(4);
		PlacingData data = new PlacingData(panel.getXcoords(), panel.getYcoord(), panel.getIsHorizontal());
		// TODO send data to server
		try {
			client.sendToServer(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//navigate to game MVC
	public void placingSuccess() {
		CardLayout cardLayout = (CardLayout) container.getLayout();
		//Need to uncomment when we get the Game controller/panel
		//cardLayout.show(container, "5");
	}

}
