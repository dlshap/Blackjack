package com.blackjack;

public class GameConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later
	
	private int deckCount;
	private boolean drillOnPairs;
	private boolean drillOnSoftHands;
	private boolean drillOnHardHands;
	private String strategy;

	public GameConfig() {
		super();
		
		getSettings();
	}

	private void getSettings() {
		//temporarily (until loading from file):
		deckCount = 1;
		drillOnPairs = false;
		drillOnSoftHands = true;
		drillOnHardHands = false;
		strategy = "Basic";

		
	}

	public int getDeckCount() {
		return deckCount;
	}

	public boolean isDrillOnPairs() {
		return drillOnPairs;
	}

	public boolean isDrillOnSoftHands() {
		return drillOnSoftHands;
	}

	public boolean isDrillOnHardHands() {
		return drillOnHardHands;
	}
	
	public String getStrategy() {
		return strategy;
	}
	
	
	
	
	
	

}
