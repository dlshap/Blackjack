package com.blackjack.testcases;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Card;
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
		
		strategy = BasicStrategy.createBasicStrategy();
		
		
		
//		assertEquals(true,strategy.checkPlay(new Play(), dealerCard, playerHand));

				
	}


}
