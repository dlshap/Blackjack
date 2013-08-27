package com.blackjack.table;

import java.util.ArrayList;

import com.blackjack.cards.Card;

public class Hand {

	private ArrayList<Card> hand = new ArrayList<Card>();

	public Hand(ArrayList<Card> hand) {
		super();
		this.hand = hand;
	}

	public void add(Card card) {
		hand.add(card);
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public Hand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String handAsString = null;
		for (Card c : hand) {
			if (handAsString == null)
				handAsString = c.toString();
			else
				handAsString += ("\n" + c.toString());
		}
		return handAsString;
	}

	public int size() {
		return hand.size();
	}

	public void clear() {
		hand.clear();
	}
}
