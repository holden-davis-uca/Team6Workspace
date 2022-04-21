package ClientCommunication;

import java.util.ArrayList;

public class GameData {
	private ArrayList<Integer> xcoords;
	private ArrayList<Integer> ycoord;
	
	public GameData(ArrayList<Integer> xcoords, ArrayList<Integer> ycoords){
		this.xcoords = xcoords;
		this.ycoord = ycoords;
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
	
	
}
