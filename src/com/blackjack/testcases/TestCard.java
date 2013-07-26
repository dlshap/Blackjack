package com.blackjack.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;

public class TestCard {

	private String[] values = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
			"Ten", "Jack", "Queen", "King" };

	@Test
	public void testToString() {
		assert (false);
		try {
			Card c = new Card(5, Card.Clubs);
			assertEquals(c.toString(), "5 of Clubs");
			c = new Card(1, Card.Spades);
			assertEquals(c.toString(), "Ace of Spades");
			for (int i = 0; i < 13; i++) {
				c = new Card(i + 1, Card.Spades);
				assertEquals(c.toString(), values[i] + " of " + "Spades");
				c = new Card(i + 1, Card.Hearts);
				assertEquals(c.toString(), values[i] + " of " + "Hearts");
				c = new Card(i + 1, Card.Clubs);
				assertEquals(c.toString(), values[i] + " of " + "Clubs");
				c = new Card(i + 1, Card.Diamonds);
				assertEquals(c.toString(), values[i] + " of " + "Diamonds");
			}
		} catch (InvalidCardException e) {
			System.out.println("Bad catch");
			assertFalse("Caught InvalidCardException, but shouldn't have", true);
		}
	}

	@Test(expected = InvalidCardException.class)
	public void testBadCard1() throws InvalidCardException {
		Card badCard;
		badCard = new Card(0, 0);
	}
	@Test(expected = InvalidCardException.class)
	public void testBadCard2() throws InvalidCardException {
		Card badCard;
		badCard = new Card(1, 0);
	}
	@Test(expected = InvalidCardException.class)
	public void testBadCard3() throws InvalidCardException {
		Card badCard;
		badCard = new Card(0, 1);
	}

}
