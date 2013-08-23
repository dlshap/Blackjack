package com.blackjack.player;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;

public class PlayerView {

	private PlayerPanel playerPanel;
	private PlayController playCtr;
	private Hand dealerHand = new Hand();
	private Hand playerHand = new Hand();
	private Card dealerShowCard;

	private PlayerView() {
		super();
		playCtr = PlayController.createPlayController();
		playCtr.setPlayerView(this);
	}

	private void setPlayerPanel(PlayerPanel playerPanel) {
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

	// public void disableHit() {
	// playerPanel.disableButton(Action.HIT);
	// }

	public void buttonPressed(Play buttonAction) {
		switch (buttonAction) {
		case DEAL:
			System.out.println(playCtr.deal().toString());
			break;
		default:
			System.out.println(buttonAction.toString());
		}

	}

	public void disableButton(Play play) {
		playerPanel.disableButton(play);

	}

	public void enableButton(Play play) {
		playerPanel.enableButton(play);

	}

	public void disableAllButtons() {
		playerPanel.disableAllButtons();

	}

	public void enableAllButtons() {
		playerPanel.enableAllButtons();

	}
}
