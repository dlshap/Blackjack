package com.blackjack.deckstackers;

import java.util.ArrayList;

import com.blackjack.cards.Card;


public class FairDeckStacker extends DeckStacker {

	public FairDeckStacker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FairDeckStacker(boolean shuffle) {
		super(shuffle);
	}

	public void buildShoe() {
		for  (int i=0; i< getShoe().getNumberOfDecks(); i++) {
			ArrayList<Card> deck = Card.newDeck();
			for (Card c:deck) {
				getShoe().add(c);
			}
		}
		if (getShuffle())
			shoe.shuffle();
	}

}
