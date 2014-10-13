package com.kademika.tanks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SetupPanel extends JPanel {

	private MainFrame frame;
	private JLabel labelQuestion;
	private JButton buttonStartGame;
    ButtonGroup buttonGroupTankTypes;
    JPanel panelTankTypes;

    boolean isTankBT7Selected;
	
	public SetupPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
        this.frame = frame;
		setComponents();
	}
	
	private void setComponents() {
		setLayout(new GridBagLayout());

        labelQuestion = new JLabel("Select type of enemy tank:");
        add(labelQuestion, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

        buttonGroupTankTypes = new ButtonGroup();
        panelTankTypes = new JPanel();
        panelTankTypes.setLayout(new GridLayout(2, 1));
        panelTankTypes.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        RBListener listener = new RBListener();
        JRadioButton radioButtonBT7 = new JRadioButton("BT7");
        radioButtonBT7.setActionCommand("BT7");
        radioButtonBT7.addActionListener(listener);
        isTankBT7Selected = true;
        radioButtonBT7.setSelected(true);
        buttonGroupTankTypes.add(radioButtonBT7);
        panelTankTypes.add(radioButtonBT7);
        JRadioButton radioButtonTiger = new JRadioButton("Tiger");
        radioButtonTiger.setActionCommand("Tiger");
        radioButtonTiger.addActionListener(listener);
        buttonGroupTankTypes.add(radioButtonTiger);
        panelTankTypes.add(radioButtonTiger);
        add(panelTankTypes, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 10, 10));

        buttonStartGame = new JButton("Start game");
		add(buttonStartGame, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 10, 10));

		buttonStartGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.loadActionField(isTankBT7Selected);

                SwingWorker swingWorker = new SwingWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        frame.actionField.runTheGame();

                        return null;
                    }
                };
                swingWorker.execute();
            }
        });
	}

    private class RBListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "BT7") {
                isTankBT7Selected = true;
            } else {
                isTankBT7Selected = false;
            }
        }
    }
}
