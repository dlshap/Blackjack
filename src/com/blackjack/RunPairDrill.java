package com.blackjack;

import com.blackjack.cards.Card;
import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.DeckStacker;
import com.blackjack.deckstackers.PairsOnlyDeckStacker;
import com.blackjack.player.PlayerView;
import com.blackjack.table.Hand;
import com.blackjack.table.PlayController;

public class RunPairDrill {
	
	private Shoe shoe;
	private PlayController playCtr;
	private PlayerView playerView;
	private DeckStacker deckStacker = new PairsOnlyDeckStacker();
	private Hand playerHand = new Hand();
	private Card dealerCard;

	public void play() {
		shoe = new Shoe(1);
		shoe.setDeckStacker(deckStacker);
		playCtr = new PlayController();
		playCtr.setShoe(shoe);
		playerView = new PlayerView();
		playerView.setPlayCtr(playCtr);
		playerHand.add(playCtr.deal());
		dealerCard = playCtr.deal();
		playerHand.add(playCtr.deal());
		
		System.out.println("Player:\n"+playerHand.toString());
		System.out.println("Dealer: "+dealerCard.toString());
	}

}
