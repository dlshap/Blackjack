package com.blackjack.player;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class PlayerView {

	private PlayerPanel playerPanel;
	private PlayController playCtr;
	private Hand dealerHand = new Hand();
	private Hand playerHand = new Hand();
	private Card dealerShowCard;

	private PlayerView() {
		super();
	}

	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}

	public static PlayerView createPlayerView(PlayerPanel playerPanel) {
		PlayerView playerView = new PlayerView();
		playerView.setPlayerPanel(playerPanel);
		return playerView;
	}

	public void startPlay() {
		playCtr.startPlay();
	}

	public void deal() {
		playerHand.add(playCtr.deal());
		dealerShowCard = playCtr.deal();
		dealerHand.add(dealerShowCard);
		playerHand.add(playCtr.deal());
		showCards();
	}

	public void playerMove(Play play) {
		// play the next move
		boolean result = playCtr.checkPlay(play, dealerShowCard, playerHand);
		showResult(result);
	}

	private void showResult(boolean result) {
		// System.out.println(result);
	}

	private void showCards() {
		// TODO Auto-generated method stub
		// System.out.println("Player:\n"+playerHand.toString()+"\n\nDealer: "+dealerCard.toString());
	}

	public void setPlayCtr(PlayController playCtr) {
		this.playCtr = playCtr;
	}
	
	public void disableHit() {
		playerPanel.disableButton(PlayerPanel.PlayerAction.HIT);
	}
}
