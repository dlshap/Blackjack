package com.blackjack.testcases;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.cards.Shoe;
import com.blackjack.deckstackers.PairsOnlyDeckStacker;

public class TestPairsOnlyDeckStacker {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Shoe shoe = new Shoe(); // one-deck shoe
		shoe.setDeckStacker(new PairsOnlyDeckStacker());
//		 System.out.println(deck);
		 System.out.println(shoe.toString());
//		 assertEquals(deck,shoe.toString());
	}
}
