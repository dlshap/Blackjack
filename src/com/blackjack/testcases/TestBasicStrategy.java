package com.blackjack.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.player.Play;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;
import com.blackjack.table.Hand;

public class TestBasicStrategy {

	ArrayList<Card> deck = Card.newDeck();
	Strategy basicStrategy = BasicStrategy.createBasicStrategy();
	Hand playerHand = new Hand();
	Card dealerCard;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAces() {

		playerHand.add(deck.get(0)); // Ace of spades
		playerHand.add(deck.get(0)); // Ace of spades
//		playerHand.add(deck.get(0)); // Ace of spades
		for (int i = 0; i < 10; i++) {
			dealerCard = deck.get(i); // Ace of spades
			assertEquals(Play.SPLIT, basicStrategy.getPlay(dealerCard, playerHand));
		}
	}

	@Test
	public void testNines() {

		playerHand.add(deck.get(8)); // Nine of spades
		playerHand.add(deck.get(8)); // Nine of spades
		dealerCard = deck.get(5); // Six of spades
		assertEquals(Play.SPLIT, basicStrategy.getPlay(dealerCard,
				playerHand));

		dealerCard = deck.get(6); // Seven of spades
		assertEquals(Play.STAND, basicStrategy.getPlay(dealerCard,
				playerHand));
	}

}
