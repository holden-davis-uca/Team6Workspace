package ClientCommunication;

import java.util.*;
//ssss
public class GameData {
	int[][][] gameboard = new int[5][5][2];
	int ship1 = 0;
	int ship2 = 0;
	int ship3 = 0;
	public GameData(int[][][] gameboard, int ship1, int ship2, int ship3) {
		this.gameboard = gameboard;
	}
	
	
	public int[][][] getGamboard(int[][][] gameboard) {
		return gameboard;
	}
	public int getShip1(int ship1) {
		
		return ship1;
	}
	public int getShip2(int ship2) {
		
		return ship2;
	}
	
	public int getShip3(int ship3) {
		
		return ship3;
	}
	public void setGamboard(int[][][] gameboard) {
		this.gameboard = gameboard;
	}
	public void setShip1(int ship1) {
		
		this.ship1 = ship1;
	}
	public void setShip2(int ship2) {
		this.ship2 = ship2;
	}
	
	public void setShip3(int ship3) {
		this.ship3 = ship3;
	}
}
