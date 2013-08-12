package com.blackjack.deckstackers;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;
import com.blackjack.cards.Shoe;

public abstract class DeckStacker {
	
	private boolean shuffle = true;
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
	
	protected Shoe getShoe() {
		return this.shoe;
	}
	
	protected boolean getShuffle() {
		return shuffle;
	}

	public abstract void buildShoe();
		
//	public void addCard(int num, int suit) {
//		try {
//			this.shoe.add(new Card(num, suit));
//		} catch (InvalidCardException e) {
//			System.out.println("Problem building card deck.");
//		}
//	}

}
