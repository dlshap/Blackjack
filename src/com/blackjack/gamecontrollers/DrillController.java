package com.blackjack.gamecontrollers;

import com.blackjack.GameConfig;
import com.blackjack.cards.Card;
import com.blackjack.cards.EmptyShoeException;
import com.blackjack.cards.Hand;
import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.DeckStackerFactory;
import com.blackjack.player.Play;
import com.blackjack.player.PlayerView;
import com.blackjack.strategy.BasicStrategy;
import com.blackjack.strategy.Strategy;

public class DrillController {

	public enum Drill {
		PAIRS, SOFT, HARD, ALL, NONE;
	}

	private GameConfig playConfig = new GameConfig();
	private Strategy strategy = BasicStrategy.createBasicStrategy();
	private Shoe shoe;
	private PlayerView playerView;
	private Drill drill = Drill.PAIRS;		//TO DO: go to panel to get default

	private DrillController() {
		super();
		createShoe();
		pickDeckStacker();
	}

	private void createShoe() {
		shoe = new Shoe(playConfig.getDeckCount());
	}

	private void pickDeckStacker() {
		shoe.setDeckStacker(DeckStackerFactory.getDeckStacker(drill()));
	}

	private Card reshuffleShoe() {
		playerView.clearCards();
		shoe.buildShoe();
		return deal();
	}

	public Drill drill() {
		return drill;
	}

	public static Drill drill(String drillString) {
		for (Drill d : Drill.values()) {
			if (drillString.toUpperCase().equals(d.toString().toUpperCase()))
				return d;
		}
		return Drill.NONE;
	}

	public static DrillController createDrillController(PlayerView playerView) {
		DrillController drillController = new DrillController();
		drillController.setPlayerView(playerView);
		return drillController;
	}

	public void startPlay() {
		setupPanelForNewGame(); // disable buttons until ready to play
		waitForDeal(); // enable "Deal" button and wait for user
	}

	private Card deal() {
		Card nextCard;
		try {
			nextCard = shoe.nextCard();
		} catch (EmptyShoeException e) {
			nextCard = reshuffleShoe();
		}
		return nextCard;
	}

	public boolean checkPlay(Play play, Card dealerCard, Hand playerHand) {
		Play correctPlay = strategy.getPlay(dealerCard, playerHand);
		if (play == correctPlay)
			return true;
		else
			return false;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;

	}

	private void dealAHand() {
		playerView.emptyHands();
		playerView.givePlayerACard(deal());
		playerView.giveDealerACard(deal());
		playerView.givePlayerACard(deal());
		playerView.showCards();
	}

	private void waitForDeal() {
		playerView.enableButton(Play.DEAL);

	}

	private void waitForPlay() {
		playerView.disableButton(Play.DEAL);
	}

	private void setupPanelForNewGame() {
		playerView.clearCards();
		playerView.disableAllButtons();
	}

	public void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
	}

	public void doAction(Play buttonAction) {
		switch (buttonAction) {
		case DEAL:
			playerView.enableAllButtons();
			dealAHand();
			waitForPlay();
			break;
		case HIT:
		case SPLIT:
		case STAND:
		case DOUBLE:
			Card dealerCard = playerView.getDealerCard();
			Hand playerHand = playerView.getPlayerHand();
			boolean result = checkPlay(buttonAction, dealerCard, playerHand);
			System.out.print(buttonAction.toString() + ": ");
			if (result)
				playerView.enableButton(Play.DEAL);
			playerView.showResult(result);
			break;
		default:
		}

	}

	public void drillChange(Drill drillCommand) {
		drill = drillCommand;
		playConfig.drillChange(drill);
		pickDeckStacker();
		playerView.clearCards();
		waitForDeal();
	}

}
