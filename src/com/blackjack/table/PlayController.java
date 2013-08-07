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

	private PlayController() {
		super();
	}

	public static PlayController createPlayController() {
		PlayController playController = new PlayController();
		playController.createShoe();
		playController.pickDeckStacker();
		return playController;
	}

	private void pickDeckStacker() {
		// if only pairs, use that deck stacker; otherwise use fair deck stacker
		if (playConfig.isDrillOnPairs() && (!playConfig.isDrillOnHardHands())
				&& (!playConfig.isDrillOnSoftHands()))
			shoe.setDeckStacker(DeckStackerFactory.getPairsOnlyDeckStacker());
		else
			// for now this is only other option...later we'll have more stackers
			shoe.setDeckStacker(DeckStackerFactory.getFairDeckStacker());
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
		shoe.buildShoe();
		return deal();
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
