package com.blackjack.strategy;

import java.util.ArrayList;

import com.blackjack.cards.Card;
import com.blackjack.player.Play;
import com.blackjack.table.Hand;

public class BasicStrategy implements Strategy {

	private static Play[][] playForPairs = new Play[10][10];

	private BasicStrategy() {
		super();
		buildPlayForPairs();
	}

	public static BasicStrategy createBasicStrategy() {
		return new BasicStrategy();
	}

	public Play getPlay(Card dealerCard, Hand playerHand) {
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
		return play;
	}

	private static void buildPlayForPairs() {
		// playForPairs array index is facevalue - 2
		// Example: Ace = (11-2) = 9
		// Ten, Jack, Queen, King = (10-2) = 8
		// Deuce = (2-2) = 0
		// p[] = {2,3,4,5,6,7,8,9,10,A}

		{// Aces [9]
			Play p[] = { Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT };
			playForPairs[9] = p;
		}
		{// Tens [8]
			Play p[] = { Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND, Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND };
			playForPairs[8] = p;
		}
		{// Nines [7]
			Play p[] = { Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.STAND, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT };
			playForPairs[7] = p;
		}
		{// Eights [6]
			Play p[] = { Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT };
			playForPairs[6] = p;
		}
		{// Sevens [5]
			Play p[] = { Play.SPLIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.SPLIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForPairs[5] = p;
		}
		{// Sixes [4]
			Play p[] = { Play.HIT, Play.SPLIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForPairs[4] = p;
		}
		{// Fives [3]
			Play p[] = { Play.DOUBLE, Play.DOUBLE, Play.DOUBLE, Play.DOUBLE,
					Play.DOUBLE, Play.DOUBLE, Play.DOUBLE, Play.DOUBLE,
					Play.HIT, Play.HIT };
			playForPairs[3] = p;
		}
		{// Fours [2]
			Play p[] = { Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForPairs[2] = p;
		}
		{// Threes [1]
			Play p[] = { Play.HIT, Play.HIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.SPLIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForPairs[1] = p;
		}
		{// Deuces [0]
			Play p[] = { Play.HIT, Play.HIT, Play.SPLIT, Play.SPLIT,
					Play.SPLIT, Play.SPLIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForPairs[0] = p;
		}

	}

	private static void oldBuildPlayForPairs() {

		for (int i = 0; i < 10; i++) {
			// Always split aces
			playForPairs[0][i] = Play.SPLIT;
			// Always stand on 10's
			playForPairs[9][i] = Play.STAND;
			// Always split 8's
			playForPairs[7][i] = Play.SPLIT;
			// Always hit 4's
			playForPairs[3][i] = Play.HIT;
		}

		// 2's and 3's: Split 4-7; otherwise hit

		for (int i = 0; i < 10; i++) {
			playForPairs[1][i] = Play.HIT;
			playForPairs[2][i] = Play.HIT;
		}
		for (int i = 3; i < 7; i++) {
			playForPairs[1][i] = Play.SPLIT;
			playForPairs[2][i] = Play.SPLIT;
		}

		// 5's: Double 2-9; hit 10 & Ace
		for (int i = 1; i < 9; i++)
			playForPairs[4][i] = Play.DOUBLE;
		playForPairs[4][0] = Play.HIT;
		playForPairs[4][9] = Play.HIT;
		// 6's: Split 3-6; otherwise hit
		for (int i = 0; i < 10; i++)
			playForPairs[5][i] = Play.HIT;
		for (int i = 2; i < 6; i++)
			playForPairs[5][i] = Play.SPLIT;
		// 7's: Split 2-7; otherwise hit
		for (int i = 0; i < 10; i++)
			playForPairs[6][i] = Play.HIT;
		for (int i = 1; i < 7; i++)
			playForPairs[6][i] = Play.SPLIT;
		// 9's: Split 2-6 and 8-9; otherwise stand
		for (int i = 1; i < 9; i++) {
			playForPairs[8][i] = Play.SPLIT;
		}
		playForPairs[8][0] = Play.STAND;
		playForPairs[8][6] = Play.STAND;
		playForPairs[8][9] = Play.STAND;
	}

}
