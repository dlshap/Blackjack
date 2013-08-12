package com.blackjack.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class TestBasicStrategy {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPlay() {
		Strategy basicStrategy = BasicStrategy.createBasicStrategy();
		Hand playerHand = new Hand();
		Card dealerCard = null;
		try {
			dealerCard = new Card(4, 1);
			playerHand.add(new Card(2, 2));
			playerHand.add(new Card(2, 3));
		} catch (InvalidCardException e) {
			System.out.println("Bad catch");
			assertFalse("Caught InvalidCardException, but shouldn't have", true);
		}
		Play play1 = Play.createSplit();
		Play splitPlay = Play.createSplit();
		System.out.println(play1.equals(splitPlay));
		assertTrue(Play.createSplit().equals(basicStrategy.getPlay(dealerCard, playerHand)));
	}
}
