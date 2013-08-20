package com.blackjack.player;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * GridBagLayoutDemo.java requires no other files.
 */

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.blackjack.table.PlayController;

public class PlayerPanel implements ActionListener {
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	PlayerView playerView;

	public static PlayerPanel createPlayerPanel(PlayerView playerView) {
		PlayerPanel playerPanel = new PlayerPanel();
		PlayerPanel.createAndShowGUI();
		
		playerPanel.setPlayerView(playerView);
		return playerPanel;
	}
	
	private PlayerPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
	
	private static GridBagConstraints defaultConstraints() {
		GridBagConstraints constraints = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			constraints.fill = GridBagConstraints.HORIZONTAL;
		}
		if (shouldWeightX) {
			constraints.weightx = 0.5;
		}
		return constraints;
	}

	private static void addComponentsToPane(Container pane) {
		JButton button;
		JLabel label;
		GridBagConstraints constraints;
		PlayerPanel panel = new PlayerPanel();

		pane.setLayout(new GridBagLayout());

		button = new JButton("Deal");
		button.addActionListener(panel);
		constraints = defaultConstraints();
		// constraints.ipady = 0; // reset to default
		// constraints.weighty = 1.0; // request any extra vertical space
		// constraints.anchor = GridBagConstraints.PAGE_END; // bottom of space
//		constraints.insets = new Insets(100, 0, 0, 0); // top padding
		constraints.gridx = 0; // aligned with button 2
		constraints.gridwidth = 2; // 2 columns wide
		constraints.gridy = 0; // third row
		pane.add(button, constraints);

		label = new JLabel("Dealer:");
		constraints = defaultConstraints();
		constraints.insets = new Insets(40, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 1;
		pane.add(label, constraints);

		label = new JLabel("KING OF HEARTS");
		constraints = defaultConstraints();
		constraints.insets = new Insets(40, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 1;
		pane.add(label, constraints);

		label = new JLabel("Player:");
		constraints = defaultConstraints();
		constraints.insets = new Insets(20, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 2;
		pane.add(label, constraints);

		label = new JLabel("ACE OF SPADES");
		constraints = defaultConstraints();
		constraints.insets = new Insets(20, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 2;
		pane.add(label, constraints);

		label = new JLabel("ACE OF HEARTS");
		constraints = defaultConstraints();
		// constraints.insets = new Insets(20, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 3;
		pane.add(label, constraints);

		button = new JButton("Hit");
		button.addActionListener(panel);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Stand");
		button.addActionListener(panel);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Split");
		button.addActionListener(panel);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 2;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Double");
		button.addActionListener(panel);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 3;
		constraints.gridy = 4;
		pane.add(button, constraints);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Blackjack Drill");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		frame.add(new RunDrillPanel());

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.setLocation(400, 400);
		frame.pack();
		frame.setVisible(true);
	}

//	public static void main(String[] args) {
//		// Schedule a job for the event-dispatching thread:
//		// creating and showing this application's GUI.
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				createAndShowGUI();
//			}
//		});
//	}
}