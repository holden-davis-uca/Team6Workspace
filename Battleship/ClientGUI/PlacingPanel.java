//Chris Stinson - Team 6
package ClientGUI;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ClientCommunication.*;

public class PlacingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> xcoords = new ArrayList<Integer>();
	private ArrayList<Integer> ycoords = new ArrayList<Integer>();
	private ArrayList<Boolean> isHorizontal = new ArrayList<Boolean>();
	private ArrayList<Integer> usedSpaces = new ArrayList<Integer>();
	private JLabel errorLabel;

// labels that change during program
	// buttonGrid
	private ArrayList<JButton> buttonGrid = new ArrayList<JButton>();
	// ship location
	private JLabel ship_one_location;
	private JLabel ship_two_location;
	public JLabel ship_three_location;
	// ship orientation
	private JLabel ship_one_orientation;
	private JLabel ship_two_orientation;
	private JLabel ship_three_orientation;

	// toolbar fields
	public JLabel currShip;
	public JTextField shipLocation;
	public JRadioButton horizontal;

	public PlacingPanel(PlacingControl pc) {
		this.setLayout(new BorderLayout());

		// create top most label in north
		JLabel label = new JLabel("Place Your Ships!", SwingConstants.CENTER);
		this.add(label, BorderLayout.NORTH);

		// create button grid in east
		JPanel buttonPanel = new JPanel();
		JPanel containerPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,5));
		HashMap<Integer, Character> map = generateHashMap();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				buttonGrid.add(new JButton(map.get(i) + "" + j));
			}
		}
		for (int i = 0; i < buttonGrid.size(); i++) {
			buttonPanel.add(buttonGrid.get(i));
		}
		buttonPanel.setPreferredSize(new Dimension(350, 350));
		containerPanel.add(buttonPanel);
		this.add(containerPanel, BorderLayout.EAST);

		// create ship information on side
		JPanel shipInfoPanel = new JPanel(new GridLayout(0, 1));
		JPanel shipContainerPanel = new JPanel();

		JLabel ship_one_title = new JLabel("Ship one(4-spaces):", SwingConstants.LEFT);
		JLabel ship_two_title = new JLabel("Ship two(3-spaces):", SwingConstants.LEFT);
		JLabel ship_three_title = new JLabel("Ship three(2-spaces):", SwingConstants.LEFT);

		ship_one_location = new JLabel("Location: ", SwingConstants.LEFT);
		ship_two_location = new JLabel("Location: ", SwingConstants.LEFT);
		ship_three_location = new JLabel("Location: ", SwingConstants.LEFT);

		ship_one_orientation = new JLabel("Orientation: ", SwingConstants.LEFT);
		ship_two_orientation = new JLabel("Orientation: ", SwingConstants.LEFT);
		ship_three_orientation = new JLabel("Orientation: ", SwingConstants.LEFT);

		shipInfoPanel.add(ship_one_title);
		shipInfoPanel.add(ship_one_location);
		shipInfoPanel.add(ship_one_orientation);
		shipInfoPanel.add(ship_two_title);
		shipInfoPanel.add(ship_two_location);
		shipInfoPanel.add(ship_two_orientation);
		shipInfoPanel.add(ship_three_title);
		shipInfoPanel.add(ship_three_location);
		shipInfoPanel.add(ship_three_orientation);

		shipContainerPanel.add(shipInfoPanel);
		this.add(shipContainerPanel, BorderLayout.WEST);

		// create user tools in bottom and error label
		JPanel labelBuffer = new JPanel();
		JPanel toolContainer = new JPanel(new BorderLayout());
		JPanel toolBuffer = new JPanel(new GridLayout(2, 0));

		errorLabel = new JLabel("Use the tools below to place your ships!");
		labelBuffer.add(errorLabel);

		JLabel shipLabel = new JLabel("Current Ship:");
		currShip = new JLabel("Ship 1");
		toolBuffer.add(shipLabel);
		toolBuffer.add(currShip);

		shipLocation = new JTextField();
		JLabel positionLabel = new JLabel("Position to Place:");
		toolBuffer.add(positionLabel);
		toolBuffer.add(shipLocation);

		JButton placeShipBtn = new JButton("Place Ship");
		JButton removeShipsBtn = new JButton("Remove All Ships");
		JButton startGameBtn = new JButton("Start Game!");
		toolBuffer.add(placeShipBtn);
		toolBuffer.add(removeShipsBtn);
		toolBuffer.add(startGameBtn);

		placeShipBtn.addActionListener(pc);
		removeShipsBtn.addActionListener(pc);
		startGameBtn.addActionListener(pc);

		horizontal = new JRadioButton("Horizontal");
		toolBuffer.add(horizontal);

		toolContainer.add(labelBuffer, BorderLayout.NORTH);
		toolContainer.add(toolBuffer, BorderLayout.CENTER);
		this.add(toolContainer, BorderLayout.SOUTH);

		this.setSize(700, 700);
		this.setVisible(true);
	}

	// generates a hash map for the x coords
	public HashMap<Integer, Character> generateHashMap() {
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		map.put(0, 'A');
		map.put(1, 'B');
		map.put(2, 'C');
		map.put(3, 'D');
		map.put(4, 'E');

		return map;
	}

	// generates the reverse of the above hash map
	public HashMap<Character, Integer> generateHashMapReverse() {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('B', 1);
		map.put('C', 2);
		map.put('D', 3);
		map.put('E', 4);

		return map;
	}
	
	public HashMap<String, Integer> gridStrToBtnIntKey() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("A0" , 0);
		map.put("A1", 1);
		map.put("A2", 2);
		map.put("A3" , 3);
		map.put("A4", 4);
		map.put("B0", 5);
		map.put("B1", 6);
		map.put("B2" , 7);
		map.put("B3", 8);
		map.put("B4", 9);
		map.put("C0" , 10);
		map.put("C1", 11);
		map.put("C2", 12);
		map.put("C3" , 13);
		map.put("C4", 14);
		map.put("D0", 15);
		map.put("D1", 16);
		map.put("D2" , 17);
		map.put("D3", 18);
		map.put("D4", 19);
		map.put("E0", 20);
		map.put("E1", 21);
		map.put("E2" , 22);
		map.put("E3", 23);
		map.put("E4", 24);

		return map;
	}

	public ArrayList<Integer> getXcoords() {
		return xcoords;
	}

	public void setXcoords(ArrayList<Integer> xcoords) {
		this.xcoords = xcoords;
	}

	public void addXCoord(int x) {
		this.xcoords.add(x);
	}

	public ArrayList<Integer> getYcoord() {
		return ycoords;
	}

	public void setYcoord(ArrayList<Integer> ycoord) {
		this.ycoords = ycoord;
	}

	public void addYCoord(int y) {
		this.xcoords.add(y);
	}

	public ArrayList<Boolean> getIsHorizontal() {
		return isHorizontal;
	}

	public void setIsHorizontal(ArrayList<Boolean> isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	public void addIsHorizontal(boolean result) {
		this.isHorizontal.add(result);
	}

	public void setErrorLabel(String error) {
		errorLabel.setText(error);
	}

	// resets all ship info on panel
	public void resetShips() {
		JButton temp = new JButton();
		for (int i = 0; i < buttonGrid.size(); i++) {
			buttonGrid.get(i).setBackground(temp.getBackground());
		}
		currShip.setText("Ship 1");
		ship_one_location.setText("Location: ");
		ship_two_location.setText("Location: ");
		ship_three_location.setText("Location: ");
		ship_one_orientation.setText("Orientation: ");
		ship_two_orientation.setText("Orientation: ");
		ship_three_orientation.setText("Orientation: ");
		xcoords.clear();
		ycoords.clear();
		isHorizontal.clear();
		usedSpaces.clear();
	}

	// validates the location of a ship selected by the user
	public boolean verifyPlacement(String loc, int shipLength, boolean hor) {

		if (loc.length() != 2) {
			return false;
		}

		if (ship_three_location.getText() != "Location: ") {
			setErrorLabel("All ships have been placed!");
			return false;
		}

		HashMap<Integer, Character> map = generateHashMap();
		HashMap<Character, Integer> mapRev = generateHashMapReverse();
		HashMap<String,Integer> mapKey = gridStrToBtnIntKey();
		char x = loc.charAt(0);
		char y = loc.charAt(1);
		boolean result = false;

		if (!map.containsValue(x)) {
			return result;
		}

		int coords = mapRev.get(x);
		String coordStr = new String(coords + "" + Character.getNumericValue(y));
		coords = mapKey.get(loc);

		if (Character.getNumericValue(y) < 0 || Character.getNumericValue(y) > 4) {
			return result;
		}

		if (shipLength == 0) {
			return result;
		}

		if (hor) {
			if (Character.getNumericValue(y) <= (5 - shipLength)) {
				result = true;
			}

		} else {
			if (shipLength == 4) {
				if (x == 'A'|| x == 'B') {
					result = true;
				}
			} else if (shipLength == 3) {
				if (x == 'A' || x == 'B'|| x == 'C') {
					result = true;
				}
			} else if (shipLength == 2) {
				if (x == 'A' || x == 'B' || x == 'C' || x == 'D') {
					result = true;
				}
			} else {
				result = false;
			}
		}

		if (hor) {
			for (int i = 0; i < buttonGrid.size(); i++) {
				if (i >= coords && i < (coords + shipLength) && usedSpaces.contains(i)) {
					result = false;
				}
			}

		} else {
			if (shipLength == 4) {
				for (int i = 0; i < buttonGrid.size(); i++) {
					if ((i == coords || i == coords + 5 || i == coords + 10 || i == coords + 15)
							&& usedSpaces.contains(i)) {
						result = false;
					}
				}
			} else if (shipLength == 3) {
				for (int i = 0; i < buttonGrid.size(); i++) {
					if ((i == coords || i == coords + 5 || i == coords + 10) && usedSpaces.contains(i)) {
						result = false;
					}
				}
			} else if (shipLength == 2) {
				for (int i = 0; i < buttonGrid.size(); i++) {
					if ((i == coords || i == coords + 5) && usedSpaces.contains(i)) {
						result = false;
					}
				}
			}
		}

		return result;
	}

	// highlights grid for ship just placed
	public void HighlightGrid(String loc, int shipLength, boolean hor) {
		HashMap<Character, Integer> map = generateHashMapReverse();
		HashMap<String,Integer> mapKey = gridStrToBtnIntKey();
		char xchar = loc.charAt(0);
		char ychar = loc.charAt(1);
		int coords = map.get(xchar);
		String coordStr = new String(coords + "" + Character.getNumericValue(ychar));
		coords = mapKey.get(loc);
		if (coords < 0) {
			coords *= -1;
		}
		System.out.println(coords);
		if (hor) {
			for (int i = 0; i < buttonGrid.size(); i++) {
				if (i >= coords && i < (coords + shipLength)) {
					buttonGrid.get(i).setBackground(Color.YELLOW);
					usedSpaces.add(i);
				}
			}

		} else {
			if (shipLength == 4) {
				for (int i = 0; i < buttonGrid.size(); i++) {
					if (i == coords || i == coords + 5 || i == coords + 10 || i == coords + 15) {
						buttonGrid.get(i).setBackground(Color.YELLOW);
						usedSpaces.add(i);
					}
				}
			} else if (shipLength == 3) {
				for (int i = 0; i < buttonGrid.size(); i++) {
					if (i == coords || i == coords + 5 || i == coords + 10) {
						buttonGrid.get(i).setBackground(Color.YELLOW);
						usedSpaces.add(i);
					}
				}
			} else if (shipLength == 2) {
				for (int i = 0; i < buttonGrid.size(); i++) {
					if (i == coords || i == coords + 5) {
						buttonGrid.get(i).setBackground(Color.YELLOW);
						usedSpaces.add(i);
					}
				}
			}
		}
	}

	// fills information about ship in information section and sets the next ship to
	// be placed
	public void NextShip(String loc, boolean hor) {
		String orientation;
		if (hor) {
			orientation = "Horizontal";
		} else {
			orientation = "Vertical";
		}

		if (currShip.getText().equals("Ship 1")) {
			ship_one_location.setText(ship_one_location.getText() + loc);
			ship_one_orientation.setText(ship_one_orientation.getText() + orientation);
			currShip.setText("Ship 2");

		} else if (currShip.getText().equals("Ship 2")) {
			ship_two_location.setText(ship_two_location.getText() + loc);
			ship_two_orientation.setText(ship_two_orientation.getText() + orientation);
			currShip.setText("Ship 3");

		} else if (currShip.getText().equals("Ship 3")) {
			if (ship_three_location.getText().equals("Location: ")) {
				ship_three_location.setText(ship_three_location.getText() + loc);
				ship_three_orientation.setText(ship_three_orientation.getText() + orientation);

			}
			setErrorLabel("All Ships placed. Remove ships or start game");

		}
	}
}
