package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class BasicStrategy implements Strategy {
	
	
	
	private BasicStrategy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static BasicStrategy createBasicStrategy() {
		return new BasicStrategy();
	}

	@Override
	public Play getPlay(Card dealerCard, Hand playerHand) {
		
		
		return Play.createNoPlay();
	}
	
	

}
