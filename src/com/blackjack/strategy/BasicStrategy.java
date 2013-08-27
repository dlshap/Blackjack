package com.blackjack.strategy;

import java.util.ArrayList;

import com.blackjack.cards.Card;
import com.blackjack.player.Play;
import com.blackjack.table.Hand;

public class BasicStrategy implements Strategy {

	private static Play[][] playForPairs = new Play[10][10];
	private static Play[][] playForSoftHands = new Play[10][10];

	private BasicStrategy() {
		super();
		playForPairs = BuildPlayForPairs.build();
		playForSoftHands = BuildPlayForSoftHands.build();
	}

	public static BasicStrategy createBasicStrategy() {
		return new BasicStrategy();
	}

	public Play getPlay(Card dealerCard, Hand playerHand) {
		Card nonAce;
		Play play = Play.STAND;
		ArrayList<Card> hand = playerHand.getHand();
		// if hand is two cards only, and it is a pair, get the next play from
		// the pair strategy array
		if ((hand.size() == 2)
				&& (hand.get(0).rank().equals(hand.get(1).rank())))
			// faceValue maps to array elements by subtracting one (Ace = 0,
			// Deuce = 1, etc.)
			play = playForPairs[playerHand.getHand().get(0).faceValue() - 2][dealerCard
					.faceValue() - 2];
		// otherwise (not a pair) if two cards only, and one card is an Ace
		// (faceValue = 11), get the next play from
		// the soft strategy array
		else if ((hand.size() == 2)
				&& (hand.get(0).rank().equals(Card.Rank.ACE) || hand.get(1)
						.rank().equals(Card.Rank.ACE))) {
			//get the non-Ace card
			if (hand.get(0).rank().equals(Card.Rank.ACE))
				nonAce = hand.get(1);
			else
				nonAce = hand.get(0);
			play = playForSoftHands[nonAce.faceValue() - 2][dealerCard
					.faceValue() - 2];
		}
		return play;
	}

}
