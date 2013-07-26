package com.blackjack.deckstackers;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;

public class FairDeckStacker extends DeckStacker {

	public FairDeckStacker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FairDeckStacker(boolean shuffle) {
		super(shuffle);
	}

	public void buildShoe() {
		for (int i = 1; i < 14; i++) {
			// loop through suits 1-4: Spades, Hearts, Diamonds, Clubs
			for (int j = 1; j < 5; j++) {
				for (int k = 0; k < shoe.getNumberOfDecks(); k++)
					addCard(i, j);
			}
		}
		if (shuffle)
			shoe.shuffle();
	}

}
