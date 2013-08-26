package com.blackjack.testcases;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.RunDrill;
import com.blackjack.playerui.PlayerPanel;

public class TestPlayerPanel {
	
	PlayerPanel playerPanel;

	@Before
	public void setUp() throws Exception {
		playerPanel = PlayerPanel.testCreatePlayerPanel();
	}

	@Test
	public void testDisableButton() {
//		fail("Not yet implemented");
	}

	@Test
	public void testEnableButton() {
//		fail("Not yet implemented");
	}

	@Test
	public void testDisableAllButtons() {
		playerPanel.disableAllButtons();
	}
	
	
}
