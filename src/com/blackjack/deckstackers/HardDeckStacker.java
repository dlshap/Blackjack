package com.blackjack.deckstackers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.blackjack.cards.Card;
import com.blackjack.cards.Card.Rank;

public class HardDeckStacker extends DeckStacker {

	// shoe is declared in SuperClass (DeckStacker)
	private int numberOfDecks, numberOfPairs, cardsLeft;
	private ArrayList<Card> decks = new ArrayList<Card>();
	// private ArrayList<Card> stackedDeck = new ArrayList<Card>();
	private ArrayList<Card> aces = new ArrayList<Card>(); // take out the aces
	private ArrayList<Card> playerCards = new ArrayList<Card>(); // dealer cards
	private Card dealerCard;

	public HardDeckStacker() {
		super(false); // never shuffle soft-deck
	}

	@Override
	public void buildShoe() {
		// each sequence of three cards will be a pair surrounding dealer's card
		// (any other)
		// i.e., dealer's card in middle
		// example: 2 Clubs, Queen Diamonds, 2 Hearts
		// for more than one deck the pair can be same suit

		// strategy:
		// 1) arrange decks in numerical sequence
		// 2) pull out aces into aces array
		// 3) deal 2 to player (no aces) and 1 to dealer (which might include
		// aces)

		numberOfDecks = shoe.getNumberOfDecks();
		decks.clear();
		aces.clear();
		playerCards.clear();

		buildDecks(numberOfDecks); // build original decks
		pullOutAces(); // get the rest of the aces
		dealCards(); // no Blackjacks
		buildTheShoe(); // put into shoe
	}

	private void getDealerCard() {
		// Chance of an ace is # aces/# cards + # aces
		int a = aces.size();
		int d = decks.size();
		double aceRatio = (double) aces.size()
				/ (double) (aces.size() + decks.size());
		int aceChance = (int) (aceRatio * 100.);
		int acePick = (int) (Math.random() * 100);
		if (acePick <= aceChance)
			dealerCard = aces.remove(0);
		else
			dealerCard = decks.remove(0);
	}

	private void dealCards() {
		System.out.println(decks.toString());
		Collections.shuffle(decks);
		System.out.println(decks.toString());
		while (decks.size() > 2) {
			playerCards.add(decks.remove(0));
			getDealerCard(); // get dealer card (might be ace)
			playerCards.add(decks.remove(0));
		}

	}

	private void buildTheShoe() {
		while (playerCards.size() > 0)
			shoe.add(playerCards.remove(0));
	}

	private void pullOutAces() {
		sortDecksAcesLow();
		Card c = decks.remove(0);
		while (c.isRank(Rank.ACE)) {
			aces.add(c);
			c = decks.remove(0);
		}
		decks.add(c); // put back last drawn card (not an ace)
	}

	private void sortDecksAcesLow() {
		class RankComparator implements Comparator<Card> {
			public int compare(Card c1, Card c2) {
				if (c1.isRank(Rank.ACE) && c2.isNotRank(Rank.ACE)) {
					return -1;
				} else if (c1.isNotRank(Rank.ACE) && c2.isRank(Rank.ACE))
					return 1;
				else
					return (c1.rank().compareTo(c2.rank()));
			}
		}
		RankComparator rc = new RankComparator();
		Collections.sort(decks, rc);
		// System.out.println(decks);
	}

	private void buildDecks(int numberOfDecks2) {
		// //shuffle the suits and sort in rank (2-A) order
		// ArrayList<Card> shuffleSuits = new ArrayList<Card>();
		for (int i = 0; i < numberOfDecks; i++) {
			decks.addAll(newDeck);
		}
		Collections.shuffle(decks); // shuffle the suits
	}

}
