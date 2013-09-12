package com.blackjack.gamecontrollers;

import com.blackjack.ConfigLoader;
import com.blackjack.strategy.Strategy;

public class GameConfig {
	// Load the configuration file and apply to game
	//
	// Initially, hard-code values...add config file later

	// defaults:
	private int deckCount;
	private Strategy strategy;
	private Drill drill;

	public GameConfig() {
		super();
		loadSettings();
	}

	private void loadSettings() {
		deckCount = ConfigLoader.getDeckCount();
		strategy = ConfigLoader.getStrategy();
		drill = ConfigLoader.getDrill();
	}

	public int getDeckCount() {
		return deckCount;
	}

	public Strategy getStrategy() {
		return strategy;
	}
	
	public Drill getDrill() {
		return drill;
	}

	public void drillChange(Drill drillCommand) {
		drill = drillCommand;
	}
}
