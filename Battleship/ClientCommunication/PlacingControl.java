//Chris Stinson - Team 6
package ClientCommunication;

import java.awt.event.*;
import java.util.HashMap;
import ClientGUI.PlacingPanel;

public class PlacingControl implements ActionListener{
	private PlacingPanel container;
	//private GameClient client;
	
	public PlacingControl(PlacingPanel container/*, GameClient client*/) {
		this.container = container;
		//this.client = client;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		PlacingPanel panel = container;

		if (command == "Place Ship") {
			System.out.println("Place Ship");
			String shipNum = panel.currShip.getText();
			String location = panel.shipLocation.getText();
			boolean hor = panel.horizontal.isSelected();
			int shipLength = 0;

			if (shipNum == "Ship 1" || shipNum == "Ship 2") {
				shipLength = 5;
			} else if (shipNum == "Ship 3" || shipNum == "Ship 4") {
				shipLength = 3;
			} else if (shipNum == "Ship 5") {
				shipLength = 2;
			}

			boolean result = panel.verifyPlacement(location, shipLength, hor);

			if (result) {
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
			} else {
				if (panel.ship_five_location.getText() != "Location: ") {
					panel.setErrorLabel("All ships have been placed!");
				}else {
					panel.setErrorLabel("Invalid location option. Try again");
				}					
			}

		} else if (command == "Remove All Ships") {
			System.out.println("Remove All Ships");
			panel.resetShips();		

		} else if (command == "Start Game!") {
			if (panel.ship_five_location.getText() != "Location: ") {
				allShipsPlaced();
			}
			else {
				panel.setErrorLabel("Must Set all ships before starting game!");
			}
			
		}
	}
	
	public void DisplayError(String error) {
		PlacingPanel panel = container;
		panel.setErrorLabel(error);
	}
	
	public void allShipsPlaced() {
		PlacingPanel panel = container;
		PlacingData data = new PlacingData(panel.getXcoords(), panel.getYcoord(), panel.getIsHorizontal());
		//TODO send data to server
	}
	
		
}
