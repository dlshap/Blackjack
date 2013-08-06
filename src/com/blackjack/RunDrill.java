package com.blackjack;

import com.blackjack.player.PlayerView;
import com.blackjack.table.PlayController;

public class RunDrill {
	
	private PlayController playCtr;
	private PlayerView playerView;

	public void play() {
		playCtr = new PlayController();
		playerView = new PlayerView();
		playerView.setPlayCtr(playCtr);
		playerView.startPlay();
	}

}
