package com.blackjack;

import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.DeckStacker;
import com.blackjack.deckstackers.PairsOnlyDeckStacker;
import com.blackjack.player.PlayerView;
import com.blackjack.table.PlayController;

public class RunPairDrill {
	
	private Shoe shoe;
	private PlayController playCtr;
	private PlayerView playerView;
	private DeckStacker deckStacker = new PairsOnlyDeckStacker();

	public void play() {
		shoe = new Shoe(1);
		shoe.setDeckStacker(deckStacker);
		playCtr = new PlayController();
		playerView = new PlayerView();
		playerView.setPlayCtr(playCtr);
		playCtr.deal();
	}

}
