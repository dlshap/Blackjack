package com.blackjack.deckstackers;

public class DeckStackerFactory {
	
	public static DeckStacker getPairsOnlyDeckStacker() {
		return new PairsOnlyDeckStacker();
	}
	
	public static DeckStacker getFairDeckStacker() {
		return new FairDeckStacker();
	}
	
	public static DeckStacker getSoftDeckStacker() {
		return new SoftDeckStacker();
	}
	
}
