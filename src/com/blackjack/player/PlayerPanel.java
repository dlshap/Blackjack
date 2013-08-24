package com.blackjack.player;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.blackjack.table.Hand;

public class PlayerPanel extends JFrame implements ActionListener {
	PlayerView playerView;
	JPanel panel = new JPanel();
	JLabel dealerCardText, playerCardText1, playerCardText2;

	private JButton[] buttons = new JButton[5];
	
	public void showCards(Hand playerHand, Hand dealerHand) {
		dealerCardText.setText(dealerHand.getHand().get(0).toString());
		playerCardText1.setText(playerHand.getHand().get(0).toString());
		playerCardText2.setText(playerHand.getHand().get(1).toString());
	}
	
	

	private PlayerPanel() {
		// show the panel
		initPlayerPanel();
		
		// attach a view to the panel
		setPlayerView(PlayerView.createPlayerView(this));
		
		// start the drill
		playerView.startPlay();
	}

	private void initPlayerPanel() {
		setTitle("BlackJack Drill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 200);

		// Set up the content pane.
		getContentPane().add(panel);
		addComponentsToPane(panel);

		// don't let them do anything yet
		disableAllButtons();

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
		for (JButton b : buttons) {
			b.setEnabled(false);
		}
	}

	public void enableAllButtons() {
		for (JButton b : buttons) {
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
		final boolean shouldFill = true;
		final boolean shouldWeightX = true;

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

		label = new JLabel("Dealer:");
		constraints = defaultConstraints();
		constraints.insets = new Insets(10, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 0;
		pane.add(label, constraints);

		dealerCardText = new JLabel();
		constraints = defaultConstraints();
		constraints.insets = new Insets(10, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 0;
		pane.add(dealerCardText, constraints);

		label = new JLabel("Player:");
		constraints = defaultConstraints();
		constraints.insets = new Insets(10, 0, 0, 0); // top padding
		constraints.gridx = 0;
		constraints.gridy = 1;
		pane.add(label, constraints);

		playerCardText1 = new JLabel(" ");
		constraints = defaultConstraints();
		constraints.insets = new Insets(10, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 1;
		pane.add(playerCardText1, constraints);

		playerCardText2 = new JLabel(" ");
		constraints = defaultConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		pane.add(playerCardText2, constraints);
		
		JPanel buttonPanel = new JPanel();
		constraints = defaultConstraints();
		constraints.gridy=3;
		constraints.gridwidth=4;
		pane.add(buttonPanel,constraints);
		
		button = new JButton(Play.DEAL.toString());
		button.setPreferredSize(new Dimension(200,30));
		buttons[Play.DEAL.index()] = button;
		button.addActionListener(this);
		constraints.insets = new Insets(10, 0, 0, 0); // top padding
		constraints = defaultConstraints();
		constraints.gridx = 0; // aligned with button 2
//		constraints.gridwidth = 4; // 2 columns wide
		constraints.gridy = 0; // third row
		buttonPanel.add(button, constraints);
		
		JPanel buttonPanel2 = new JPanel();
		constraints = defaultConstraints();
		constraints.gridy=4;
		constraints.gridwidth=4;
		pane.add(buttonPanel2,constraints);

		button = new JButton("Hit");
		button = new JButton(Play.HIT.toString());
		buttons[Play.HIT.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
//		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		button.setPreferredSize(null);
		constraints.gridx = 0;
		constraints.gridy = 1;
		buttonPanel2.add(button, constraints);

		button = new JButton("Stand");
		button = new JButton(Play.STAND.toString());
		buttons[Play.STAND.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
//		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 1;
		constraints.gridy = 1;
		buttonPanel2.add(button, constraints);

		button = new JButton("Split");
		button = new JButton(Play.SPLIT.toString());
		buttons[Play.SPLIT.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
//		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 2;
		constraints.gridy = 4;
		buttonPanel2.add(button, constraints);

		button = new JButton("Double");
		button = new JButton(Play.DOUBLE.toString());
		buttons[Play.DOUBLE.index()] = button;
		button.addActionListener(this);
		constraints = defaultConstraints();
//		constraints.insets = new Insets(60, 0, 0, 0); // top padding
		constraints.gridx = 3;
		constraints.gridy = 4;
		buttonPanel2.add(button, constraints);

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
				// PlayerPanel playerPanel = new PlayerPanel();
				playerPanel.setVisible(true);
			}
		});

		return playerPanel;
	}
}