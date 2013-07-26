package com.blackjack.cards;

public class Card {
	
	public static final int Spades = 1;
	public static final int Hearts = 2;
	public static final int Diamonds = 3;
	public static final int Clubs = 4;

	private int faceValue = 0;		// card face faceValue (1-13)
	private int suit = 0;		// card suit (1-4)
	private String[] faceValues = {"Ace","2","3","4","5","6","7","8","9","Ten","Jack","Queen","King"};
	private String[] suits = {"Spades","Hearts","Diamonds","Clubs"};

	public Card(int faceValue, int suit) throws InvalidCardException {
		// TODO Auto-generated constructor stub
		if (faceValue >= 1 && faceValue <=13)
			this.faceValue = faceValue;
		else throw new InvalidCardException("Face value must be from 1 to 13");
		if (suit >= 1 && suit <= 4)
			this.suit = suit;
		else throw new InvalidCardException("Suit must be from 1 to 4");
	}
	
	public String toString() {
		if (faceValue == 0 || suit == 0)
			return("Bad Card");
		else
			return(faceValues[faceValue-1]+" of "+suits[suit-1]);
	}
	
	public int getFaceValue() {
		return faceValue;
	}

	public int getSuit() {
		return suit;
	}
	

}
