package com.blackjack.table;

import com.blackjack.GameConfig;
import com.blackjack.cards.Card;
import com.blackjack.cards.EmptyShoeException;
import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.DeckStackerFactory;
import com.blackjack.strategy.Strategy;

public class PlayController {

	private GameConfig playConfig = new GameConfig();
	private Strategy strategy;
	private Shoe shoe;

	public PlayController() {
		super();
		createShoe();
		pickDeckStacker();
	}

	private void pickDeckStacker() {
		// if only pairs, use that deck stacker; otherwise use fair deck stacker
		// (fair deck)
		if (playConfig.isDrillOnPairs() && (!playConfig.isDrillOnHardHands())
				&& (!playConfig.isDrillOnSoftHands()))
			shoe.setDeckStacker(DeckStackerFactory.getPairsOnlyDeckStacker());
		else
			shoe.setDeckStacker(DeckStackerFactory.getFairDeckStacker()); // for
																			// now
																			// this
																			// is
																			// only
																			// other
																			// option
	}

	private void createShoe() {
		shoe = new Shoe(playConfig.getDeckCount());
	}

	public Card deal() {
		Card nextCard;
		try {
			nextCard = shoe.nextCard();
		} catch (EmptyShoeException e) {
			nextCard = reshuffleShoe();
		}
		return nextCard;
	}

	private Card reshuffleShoe() {
		Card nextCard = null;
		shoe.buildShoe();
		try {
			nextCard = shoe.nextCard();
		} catch (EmptyShoeException e) {
			System.out.println("Fatal Error...can't reshuffle");
		}
		return nextCard;
	}

	public boolean checkPlay(Play play, Card dealerCard, Hand playerHand) {
		if (play.equals(strategy.getPlay(dealerCard, playerHand)))
			return true;
		else
			return false;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;

	}
}
