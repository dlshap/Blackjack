package com.blackjack;

import com.blackjack.player.PlayerView;
import com.blackjack.table.PlayController;

public class RunDrill {
	
	public void play() {
		PlayerView playerView = PlayerView.createPlayerView();
		playerView.setPlayCtr(PlayController.createPlayController());
		playerView.startPlay();
	}

}
