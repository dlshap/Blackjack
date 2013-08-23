package com.blackjack.player;

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

	public void disableButton(Play disableAction) {
		// disable button having selected Action
		buttons[disableAction.index()].setEnabled(false);
	}

	public void enableButton(Play enableAction) {
		buttons[enableAction.index()].setEnabled(true);
	}
	
	public void disableAllButtons() {
		for (JButton b:buttons) {
			b.setEnabled(false);
		}
	}
	
	public void enableAllButtons() {
		for (JButton b:buttons) {
			b.setEnabled(true);
		}
		
	}

	private void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
	}
	
	public PlayerView getPlayerView() {
		return playerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Figure out the action from the button that got pressed
		Play buttonAction = Play.NONE;
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource().equals(buttons[i])) {
				buttonAction = Play.action(i);
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

		button = new JButton(Play.DEAL.toString());
		buttons[Play.DEAL.index()] = button;
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
		button = new JButton(Play.HIT.toString());
		buttons[Play.HIT.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Stand");
		button = new JButton(Play.STAND.toString());
		buttons[Play.STAND.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Split");
		button = new JButton(Play.SPLIT.toString());
		buttons[Play.SPLIT.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 2;
		constraints.gridy = 4;
		pane.add(button, constraints);

		button = new JButton("Double");
		button = new JButton(Play.DOUBLE.toString());
		buttons[Play.DOUBLE.index()] = button;
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
	
	public static PlayerPanel testCreatePlayerPanel() {
		// TODO Auto-generated method stub

		final PlayerPanel playerPanel = new PlayerPanel();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
//				PlayerPanel playerPanel = new PlayerPanel();
				playerPanel.setVisible(true);
			}
		});
		
		return playerPanel;
	}

}