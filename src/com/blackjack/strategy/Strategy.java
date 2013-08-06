package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public interface Strategy {
	
	public abstract Play getPlay(Card dealerCard, Hand playerHand);
}
