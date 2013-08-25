package com.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.blackjack.player.PlayerPanel;

public class Card implements Comparable<Card> {

	public enum Suit {
		SPADES, HEARTS, DIAMONDS, CLUBS
	}

	public enum Rank {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
				9), TEN(10), JACK(10), QUEEN(10), KING(10);
		private final int faceValue;

		Rank(int value) {
			this.faceValue = value;
		}

		int faceValue() {
			return this.faceValue;
		}
	}

	private final Rank rank;
	private final Suit suit;
	private final int faceValue;

	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.faceValue = rank.faceValue();
	}

	public Rank rank() {
		return rank;
	}

	public int faceValue() {
		return faceValue;
	}

	public Suit suit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	private static final List<Card> protoDeck = new ArrayList<Card>();

	// Initialize prototype deck
	static {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				protoDeck.add(new Card(rank, suit));
	}

	public static ArrayList<Card> newDeck() {
		return new ArrayList<Card>(protoDeck); // Return copy of prototype deck
	}

	public boolean equals(Card card) {
		if ((this.rank.equals(card.rank)) && (this.suit.equals(card.suit)))
			return true;
		else
			return false;
	}

	public boolean faceEquals(Card card) {
		return (this.faceValue() == card.faceValue());
	}

	public ImageIcon getCardIcon() {
		String imageName = this.rank.toString().toLowerCase() + "_" + this.suit.toString().toLowerCase();
		return createImageIcon("resources/cardIcons/" + imageName + ".png", "");
	}

	protected static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = Card.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public static Card makeCard(Rank rank, Suit suit) {
		return new Card(rank, suit);
	}

	public int compareTo(Card c) {
		if (!(this.rank() == c.rank()))
			return this.rank().compareTo(c.rank());
		else
			return this.suit().compareTo(c.suit());
	}
	
	public static ImageIcon getJokerImage() {
		return createImageIcon("resources/cardIcons/joker.png","Joker");
	}
}
