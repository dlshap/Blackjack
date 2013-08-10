package com.blackjack.table;

public class Play {
	// 0 = Hit, 1 = Stand, 2 = Double ...
	static public final String[] PLAYCHOICE = { "Hit", "Stand", "Double",
			"Split", "Insure", "Withdraw" };

	private String choice;

	static String choiceName(int choice) {
		if (choice >= 0 && choice < PLAYCHOICE.length)
			return PLAYCHOICE[choice];
		else
			return "Bad Choice";
	}

	public static Play createNoPlay() {
		Play play = new Play();
		play.setChoice("No play");
		return play;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getChoice() {
		return choice;
	}

	public static Play createPlay() {
		return createNoPlay();
	}

}
