package com.blackjack.strategy;

import com.blackjack.player.Play;

public class BuildPlayForSoftHands {
	public static Play[][] build() {
		// playForSoftHands array index is facevalue - 2
		// Example: Ace = (11-2) = 9
		// Ten, Jack, Queen, King = (10-2) = 8
		// Deuce = (2-2) = 0
		// p[] = {2,3,4,5,6,7,8,9,10,A}
		
		Play[][] playForSoftHands = new Play[10][10];

		{// Aces [9]
			Play p[] = { Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND, Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND };
			playForSoftHands[9] = p;
		}
		{// Tens [8]
			Play p[] = { Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND, Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND };
			playForSoftHands[8] = p;
		}
		{// Nines [7]
			Play p[] = { Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND, Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND };
			playForSoftHands[7] = p;
		}
		{// Eights [6]
			Play p[] = { Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND, Play.STAND, Play.STAND, Play.STAND, Play.STAND,
					Play.STAND };
			playForSoftHands[6] = p;
		}
		{// Sevens [5]
			Play p[] = { Play.STAND, Play.DOUBLE, Play.DOUBLE, Play.DOUBLE,
					Play.DOUBLE, Play.STAND, Play.STAND, Play.HIT, Play.HIT,
					Play.HIT };
			playForSoftHands[5] = p;
		}
		{// Sixes [4]
			Play p[] = { Play.HIT, Play.DOUBLE, Play.DOUBLE, Play.DOUBLE,
					Play.DOUBLE, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForSoftHands[4] = p;
		}
		{// Fives [3]
			Play p[] = { Play.HIT, Play.HIT, Play.DOUBLE, Play.DOUBLE,
					Play.DOUBLE, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForSoftHands[3] = p;
		}
		{// Fours [2]
			Play p[] = { Play.HIT, Play.HIT, Play.DOUBLE, Play.DOUBLE,
					Play.DOUBLE, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForSoftHands[2] = p;
		}
		{// Threes [1]
			Play p[] = { Play.HIT, Play.HIT, Play.HIT, Play.DOUBLE,
					Play.DOUBLE, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForSoftHands[1] = p;
		}
		{// Deuces [0]
			Play p[] = { Play.HIT, Play.HIT, Play.HIT, Play.DOUBLE,
					Play.DOUBLE, Play.HIT, Play.HIT, Play.HIT, Play.HIT,
					Play.HIT };
			playForSoftHands[0] = p;
		}
		return playForSoftHands;

	}
}
