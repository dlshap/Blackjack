package com.blackjack.table;

public class Play {
	// 0 = Hit, 1 = Stand, 2 = Double ...
	static public final String[] PLAYCHOICE = { "Hit", "Stand", "Double",
			"Split", "Insure", "Withdraw" };

	private String choice;

	private static String choiceName(int choice) {
		if (choice >= 0 && choice < PLAYCHOICE.length)
			return PLAYCHOICE[choice];
		else
			return "Bad Choice";
	}
	
	private Play() {
		super();
	}
	
	public static Play createHit() {
		Play play = new Play();
		play.setChoice(0);
		return play;
	}

	public static Play createStand() {
		Play play = new Play();
		play.setChoice(1);
		return play;
	}
	
	public static Play createDouble() {
		Play play = new Play();
		play.setChoice(2);
		return play;
	}
	
	public static Play createSplit() {
		Play play = new Play();
		play.setChoice(3);
		return play;
	}


	public static Play createNoPlay() {
		Play play = new Play();
		play.setChoice(-1);
		return play;
	}

	private void setChoice(int choice) {
		this.choice = choiceName(choice);
	}

	public String getChoice() {
		return choice;
	}

	public static Play createPlay() {
		return createNoPlay();
	}
	
	public boolean equals(Play equalsPlay) {
		return (this.getChoice().equals(equalsPlay.getChoice()));
	}

}
