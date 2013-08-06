package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class BasicStrategy implements Strategy {
	
	Play play = Play.createPlay();

	@Override
	public Play getPlay(Card dealerCard, Hand playerHand) {
		
		
		return Play.createNoPlay();
	}
	
	

}
