package com.blackjack.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;
import com.blackjack.table.Hand;

public class TestStrategy {
	
	private Card dealerCard;
	private Hand playerHand = new Hand();
	private Strategy strategy;


	@Before
	public void setUp() throws Exception {
	}

	
	
	@Test
	public void testBasicStrategy() {
		
		strategy = new BasicStrategy();
		
		try {
		dealerCard = new Card(6,1);
		playerHand.add(new Card(3,1));
		playerHand.add(new Card(5,1));
		} catch (InvalidCardException e) {
			assertFalse("Invalid Card",true);
		}
		
		assertEquals("Hit",strategy.getCorrectPlay(dealerCard, playerHand));

				
	}


}
