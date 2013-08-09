package com.blackjack.table;

public class Play {
	public final String[] PLAYCHOICE = {"Hit","Stand","Double","Split","Insure","Withdraw"};
	
	private String choice;	

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
