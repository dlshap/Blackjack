package com.blackjack.player;

import com.blackjack.DrillController;
import com.blackjack.cards.Card;
import com.blackjack.table.Hand;

public class PlayerView {

	private PlayerPanel playerPanel;
	private DrillController drillCtr;
	private Hand dealerHand = new Hand();
	private Hand playerHand = new Hand();
	private Card dealerShowCard;

	private PlayerView() {
		super();
		drillCtr = DrillController.createDrillController();
		drillCtr.setPlayerView(this);
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
		drillCtr.startPlay();
	}

	public void playerMove(Play play) {
		// play the next move
		boolean result = drillCtr.checkPlay(play, dealerShowCard, playerHand);
		showResult(result);
	}

	private void showResult(boolean result) {
		// System.out.println(result);
	}

	private void showCards() {
		// TODO Auto-generated method stub
		// System.out.println("Player:\n"+playerHand.toString()+"\n\nDealer: "+dealerCard.toString());
	}

	public void setdrillCtr(DrillController drillCtr) {
		this.drillCtr = drillCtr;
	}

	public void buttonPressed(Play buttonAction) {
		switch (buttonAction) {
		case DEAL:
			System.out.println(drillCtr.deal().toString());
			break;
		case HIT:
		case SPLIT:
		case DOUBLE:
		case STAND:
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
