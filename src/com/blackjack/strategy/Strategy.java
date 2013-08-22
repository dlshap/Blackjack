package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.player.Play;
import com.blackjack.table.Hand;

public interface Strategy {
	
	public abstract Play getPlay(Card dealerCard, Hand playerHand);
}
