package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class Strategy {
	
	private Card dealerCard;
	private Hand playerHand;
	
	public Strategy() {
		super();
	}
	
	public boolean checkPlay(Play playChoice, Card dealerCard, Hand playerHand)  {
		this.dealerCard = dealerCard;
		this.playerHand = playerHand;
		
		
		return true;				//correct play
	}
}
