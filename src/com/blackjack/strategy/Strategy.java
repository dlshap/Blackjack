package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.cards.Hand;
import com.blackjack.player.Play;

public interface Strategy {
	
	public abstract Play getPlay(Card dealerCard, Hand playerHand);
}
