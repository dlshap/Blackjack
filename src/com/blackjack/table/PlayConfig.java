package com.blackjack.table;

public class PlayConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later
	
	private int deckCount;
	private boolean drillOnPairs;
	private boolean drillOnSoftHands;
	private boolean drillOnHardHands;
	private String strategy;

	public PlayConfig() {
		super();
		
		getSettings();
	}

	private void getSettings() {
		//temporarily (until loading from file):
		deckCount = 1;
		drillOnPairs = true;
		drillOnSoftHands = false;
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
