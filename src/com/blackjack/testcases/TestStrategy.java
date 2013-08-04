package com.blackjack.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Card;
import com.blackjack.cards.InvalidCardException;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

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
		
		assertEquals(true,strategy.checkPlay(new Play(), dealerCard, playerHand));

				
	}


}
