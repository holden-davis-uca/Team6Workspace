package ClientCommunication;

import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.*;
import ClientGUI.*;

public class GameControl {
	private JPanel container;
	private GameClient client;

	public GameControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	public void actionPerformed(ActionEvent ae) {
		//gametsss
		int gameover = 0;
	    int error = 0;
	    int x = 0; 
	    int y =0;
	    int horizontal = 0;
		int[][][] gameBoard = new int[5][5][2];
		for (int i = 0; i < 3; i++)
		{

		    if (horizontal == 1)
		    {				
		    		for(int j = 0; j < (i + 2); j++) {
		    			gameBoard[x + j][y][0] = 1;
		    			gameBoard[x + j][y][1] = i+2;
		    		}
		    }
		    else
		    {
		    	for(int j = 0; j < (i + 2); j++) {
		    		gameBoard[x][y + j][0] = 1;
		    		gameBoard[x][y + j][1] = i+2;
		    	}	
		    }
		}
		int ship1 = 0;
		int ship2 = 0;
		int ship3 = 0;

			    if(gameBoard[x][y][0] == 1) 
			    {
			    	if(gameBoard[x][y][1] == 2) {
			    		ship1 = ship1 + 1;
				    	System.out.println("Ship Hit!");
			    	}
			    	if(gameBoard[x][y][1] == 3) {
			    		ship2 = ship2 + 1;
				    	System.out.println("Ship Hit!");
			    	}
			    	if(gameBoard[x][y][1] == 4) {
			    		ship3 = ship3 + 1;
				    	System.out.println("Ship Hit!");
			    	}
			    }
			    else
			    {
			    	System.out.println("Miss!");
			    }
			    if(ship1 == 2 && ship2 == 3 && ship3 == 4) 
			    {
			    	gameover = 1;
			    	System.out.println("GameOver!");

			    }
			

	}
}
