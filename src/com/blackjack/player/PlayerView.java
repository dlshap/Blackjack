package com.blackjack.player;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;
import com.blackjack.table.PlayController;

public class PlayerView {
	
	private PlayController playCtr;
	private Card dealerCard;
	private Hand playerHand;
	
	public void deal() {
		playerHand.add(playCtr.deal());
		dealerCard = playCtr.deal();
		playerHand.add(playCtr.deal());
		showCards();
	}
	
	public void playerMove(Play play) {
		boolean result = playCtr.pickPlay(play, dealerCard, playerHand);
		showResult(result);
	}

	private void showResult(boolean result) {
		System.out.println(result);		
	}

	private void showCards() {
		// TODO Auto-generated method stub
		System.out.println("Player: "+playerHand.toString()+"\n\nDealer: "+dealerCard.toString());
	}

	public void setPlayCtr(PlayController playCtr) {
		this.playCtr = playCtr;
	}

}
