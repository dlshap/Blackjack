package com.blackjack;

public class GameConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later
	
	private int deckCount;
	private Drill drill;
	private String strategy;
	
	public enum Drill {
		PAIRS, SOFT, HARD, ALL;
	}

	public GameConfig() {
		super();
		
		getSettings();
	}

	private void getSettings() {
		//temporarily (until loading from file):
		deckCount = 1;
		drill = Drill.HARD;
		strategy = "Basic";

		
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
