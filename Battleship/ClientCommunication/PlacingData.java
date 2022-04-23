//Chris Stinson - Team 6
package ClientCommunication;

import java.io.Serializable;
import java.util.*;

public class PlacingData implements Serializable{
	private ArrayList<Integer> xcoords;
	private ArrayList<Integer> ycoord;
	private ArrayList<Boolean> isHorizontal;

	public PlacingData(ArrayList<Integer> xcoords, ArrayList<Integer> ycoords, ArrayList<Boolean> isHorizontal) {
		this.xcoords = xcoords;
		this.ycoord = ycoords;
		this.isHorizontal = isHorizontal;
	}

	public ArrayList<Integer> getXcoords() {
		return xcoords;
	}

	public void setXcoords(ArrayList<Integer> xcoords) {
		this.xcoords = xcoords;
	}

	public ArrayList<Integer> getYcoord() {
		return ycoord;
	}

	public void setYcoord(ArrayList<Integer> ycoord) {
		this.ycoord = ycoord;
	}

	public ArrayList<Boolean> getIsHorizontal() {
		return isHorizontal;
	}

	public void setIsHorizontal(ArrayList<Boolean> isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

}
