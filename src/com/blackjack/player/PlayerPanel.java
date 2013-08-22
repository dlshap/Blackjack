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
import javax.swing.JPanel;

import com.blackjack.player.PlayerView.Action;

public class PlayerPanel extends JFrame implements ActionListener {
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	PlayerView playerView;
	JPanel panel = new JPanel();

	

	private JButton[] buttons = new JButton[5];

	private PlayerPanel() {
		initPlayerPanel();
		setPlayerView(PlayerView.createPlayerView(this));
		playerView.startPlay();
	}

	private void initPlayerPanel() {
		setTitle("BlackJack Drill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 200);

		// Set up the content pane.
		getContentPane().add(panel);
		addComponentsToPane(panel);

		pack();
		panel.setVisible(true);
	}

	public void disableButton(Action disableAction) {
		// disable button having selected Action
		buttons[disableAction.index()].setEnabled(false);
	}

	public void enableButton(Action enableAction) {
		buttons[enableAction.index()].setEnabled(true);
	}

	private void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Figure out the action from the button that got pressed
		Action buttonAction = Action.NONE;
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource().equals(buttons[i])) {
				buttonAction = Action.action(i);
			}
		}
		playerView.buttonPressed(buttonAction);
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

	private void addComponentsToPane(Container pane) {
		JButton button;
		JLabel label;
		GridBagConstraints constraints;

		pane.setLayout(new GridBagLayout());

		button = new JButton(Action.DEAL.toString());
		buttons[Action.DEAL.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
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
		constraints.gridx = 1;
		constraints.gridy = 3;
		pane.add(label, constraints);

		button = new JButton("Hit");
		button = new JButton(Action.HIT.toString());
		buttons[Action.HIT.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Stand");
		button = new JButton(Action.STAND.toString());
		buttons[Action.STAND.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Split");
		button = new JButton(Action.SPLIT.toString());
		buttons[Action.SPLIT.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 2;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Double");
		button = new JButton(Action.DOUBLE.toString());
		buttons[Action.DOUBLE.index()] = button;
		button.addActionListener(this);
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
	public static void createPlayerPanel() {
		// TODO Auto-generated method stub

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlayerPanel playerPanel = new PlayerPanel();
				playerPanel.setVisible(true);
			}
		});
	}

}