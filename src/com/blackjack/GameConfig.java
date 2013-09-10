package com.blackjack;

import com.blackjack.gamecontrollers.DrillController;
import com.blackjack.gamecontrollers.DrillController.Drill;


public class GameConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later
	
	// defaults:	
	private int deckCount = 1;
	private String strategy = "Basic";
	private String drill = DrillController.Drill.ALL.toString();
	
	

	public GameConfig() {
		super();
		
		loadSettings();
	}

	private void loadSettings() {
		//temporarily (until loading from file):
		deckCount = 1;
	}

	public int getDeckCount() {
		return deckCount;
	}
	
	
	public String getStrategy() {
		return strategy;
	}

	public void drillChange(Drill drillCommand) {
		drill = drillCommand.toString();
	}
}
