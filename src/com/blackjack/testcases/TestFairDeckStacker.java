package com.blackjack.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.FairDeckStacker;

public class TestFairDeckStacker {
	
	// TODO:
	// Need a reference deck string to compare the shoe to (i.e., {"Ace of Spades","Ace of Hearts",...})

	@Test
	public void test1Deck() {
		String deck = "Ace of Spades\nAce of Hearts\nAce of Diamonds\nAce of Clubs\n"
				+ "2 of Spades\n2 of Hearts\n2 of Diamonds\n2 of Clubs\n"
				+ "3 of Spades\n3 of Hearts\n3 of Diamonds\n3 of Clubs\n"
				+ "4 of Spades\n4 of Hearts\n4 of Diamonds\n4 of Clubs\n"
				+ "5 of Spades\n5 of Hearts\n5 of Diamonds\n5 of Clubs\n"
				+ "6 of Spades\n6 of Hearts\n6 of Diamonds\n6 of Clubs\n"
				+ "7 of Spades\n7 of Hearts\n7 of Diamonds\n7 of Clubs\n"
				+ "8 of Spades\n8 of Hearts\n8 of Diamonds\n8 of Clubs\n"
				+ "9 of Spades\n9 of Hearts\n9 of Diamonds\n9 of Clubs\n"
				+ "Ten of Spades\nTen of Hearts\nTen of Diamonds\nTen of Clubs\n"
				+ "Jack of Spades\nJack of Hearts\nJack of Diamonds\nJack of Clubs\n"
				+ "Queen of Spades\nQueen of Hearts\nQueen of Diamonds\nQueen of Clubs\n"
				+ "King of Spades\nKing of Hearts\nKing of Diamonds\nKing of Clubs";

		Shoe shoe = new Shoe(1); // one-deck shoe
		shoe.setDeckStacker(new FairDeckStacker(false));
//		 System.out.println(deck);
//		 System.out.println(shoe.toString());
		 assertEquals(deck,shoe.toString());
	}

	@Test
	public void testShoeNoShuffle() {
		Shoe shoe = new Shoe(20);
		shoe.setDeckStacker(new FairDeckStacker(false)); // don't shuffle
		System.out.println("\n\nNo shuffle:");
		System.out.println(shoe.toString());
	}

}
