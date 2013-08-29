package com.blackjack;

public class GameConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later
	
	// defaults:	
	private int deckCount = 1;
	private Drill drill = Drill.SOFT;
	private String strategy = "Basic";
	
	public enum Drill {
		PAIRS, SOFT, HARD, ALL;
	}

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
	
	public Drill drill() {
		return drill;
	}

	
	public String getStrategy() {
		return strategy;
	}
	
	
	
	
	
	

}
