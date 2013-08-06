package com.blackjack.table;

public class PlayConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later
	
	private int deckCount;
	private boolean drillOnPairs = true;
	private boolean drillOnSoftHands = true;
	private boolean drillOnHardHands = true;

	public PlayConfig() {
		super();
		//temporarily (until loading from file):
		deckCount = 1;
		drillOnPairs = true;
		drillOnSoftHands = false;
		drillOnHardHands = false;
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
	
	
	
	
	
	

}
