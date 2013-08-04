package com.blackjack;

import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.DeckStacker;
import com.blackjack.deckstackers.PairsOnlyDeckStacker;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;
import com.blackjack.table.PlayController;

public class RunBlackJack {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello everyone!");

		RunPairDrill runPairDrill = new RunPairDrill();
		runPairDrill.play();
	}

}
