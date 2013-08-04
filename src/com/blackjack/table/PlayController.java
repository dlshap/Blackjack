package com.blackjack.table;

import com.blackjack.cards.Card;
import com.blackjack.cards.EmptyShoeException;
import com.blackjack.cards.Shoe;
import com.blackjack.strategy.Strategy;

public class PlayController {
	private Strategy strategy;
	private Shoe shoe;

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

	public boolean pickPlay(Play play, Card dealerCard, Hand playerHand) {
		return strategy.checkPlay(play, dealerCard, playerHand);
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
		
	}
}
