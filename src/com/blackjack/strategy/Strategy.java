package com.blackjack.strategy;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;

public class Strategy {
	private Card dealerCard;
	private Hand playerHand;
	final String[] plays = {"Hit","Stand","Double","Split","Withdraw"};
	
	public String getCorrectPlay(Card dealerCard, Hand playerHand)  {
		this.dealerCard = dealerCard;
		this.playerHand = playerHand;
		
		
		return plays[0];				//temp
	}
}
