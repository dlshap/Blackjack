package com.blackjack.player;

import com.blackjack.cards.Card;
import com.blackjack.table.Hand;
import com.blackjack.table.Play;

public class PlayerView {

	public enum Action {
		HIT(0), STAND(1), SPLIT(2), DOUBLE(3), DEAL(4), NONE(-1);

		private int index;

		Action(int index) {
			this.index = index;
		}

		public int index() {
			return this.index;
		}

		public static Action action(int index) {
			for (Action a : Action.values()) {
				if (a.index() == index)
					return a;
			}
			return Action.NONE;
		}

		public String toString() {
			String label = this.name().substring(0, 1)
					+ this.name().substring(1).toLowerCase();
			return label;
		}
	}
	
	private PlayerPanel playerPanel;
	private PlayController playCtr;
	private Hand dealerHand = new Hand();
	private Hand playerHand = new Hand();
	private Card dealerShowCard;

	private PlayerView() {
		super();
		playCtr = PlayController.createPlayController();
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
		playerPanel.disableButton(Action.HIT);
		playerPanel.disableButton(Action.STAND);
		playerPanel.disableButton(Action.SPLIT);
		playerPanel.disableButton(Action.DOUBLE);
//		playCtr.startPlay();
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
	
//	public void disableHit() {
//		playerPanel.disableButton(Action.HIT);
//	}

	public void buttonPressed(Action buttonAction) {
		System.out.println(buttonAction.toString());
		
	}
}
