package com.blackjack.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class TestBasicStrategy {

	ArrayList<Card> deck = Card.newDeck();
	Strategy basicStrategy = BasicStrategy.createBasicStrategy();
	Hand playerHand = new Hand();
	Card dealerCard;
	Play expectedPlay;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAces() {

		playerHand.add(deck.get(0)); // Ace of spades
		playerHand.add(deck.get(0)); // Ace of spades
		expectedPlay = Play.createSplit();
		for (int i = 0; i < 10; i++) {
			dealerCard = deck.get(i); // Ace of spades
			assertTrue(expectedPlay.equals(basicStrategy.getPlay(dealerCard,
					playerHand)));
		}
	}

	@Test
	public void testNines() {

		playerHand.add(deck.get(8)); // Nine of spades
		playerHand.add(deck.get(8)); // Nine of spades
		dealerCard = deck.get(5); // Six of spades
		expectedPlay = Play.createSplit();
		assertTrue(expectedPlay.equals(basicStrategy.getPlay(dealerCard,
				playerHand)));

		dealerCard = deck.get(6); // Seven of spades
		expectedPlay = Play.createStand();
		assertTrue(expectedPlay.equals(basicStrategy.getPlay(dealerCard,
				playerHand)));
	}

}
