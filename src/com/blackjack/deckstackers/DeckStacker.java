package com.blackjack.deckstackers;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;
import com.blackjack.cards.Shoe;

public abstract class DeckStacker {
	
	protected boolean shuffle = true;
	protected Shoe shoe;
	
	public DeckStacker() {
		super();
	}
	
	public DeckStacker(boolean shuffle) {
		super();
		this.shuffle = shuffle;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	public abstract void buildShoe();
		
	public void addCard(int num, int suit) {
		try {
			shoe.add(new Card(num, suit));
		} catch (InvalidCardException e) {
			System.out.println("Problem building card deck.");
		}
	}

}
