package com.blackjack.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.FairDeckStacker;

public class TestFairDeckStacker {

	// TODO:
	// Need a reference deck string to compare the shoe to (i.e.,
	// {"Ace of SPADES","Ace of HEARTS",...})

	@Test
	public void test1Deck() {
		String deckCheck = null;
		for (Card.Suit s : Card.Suit.values()) {
			for (Card.Rank r : Card.Rank.values()) {
				if (deckCheck == null)
					deckCheck = (r + " of " + s);
				else
					deckCheck += ("\n" + r + " of " + s);
			}
		}
		// deckCheck = "ACE of SPADES";
		Shoe shoe = new Shoe(1); // one-deck shoe
		shoe.setDeckStacker(new FairDeckStacker(false));
		assertEquals(deckCheck, shoe.toString());
		// System.out.println(shoe.toString());
	}
}
