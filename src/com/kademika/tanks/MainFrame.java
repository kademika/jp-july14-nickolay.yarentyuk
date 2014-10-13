package com.kademika.tanks;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.kademika.tanks.bf.BattleField;

public class MainFrame extends JFrame {

	ActionField actionField;
    SetupPanel setupPanel;
    ResultPanel resultPanel;
	
	public MainFrame() throws Exception {

		setFrame();
		loadSetupPanel();
	}
	
	private void setFrame() throws Exception {
		this.setTitle("Tanks");
		this.setLocation(750, 150);
		this.setMinimumSize(new Dimension(BattleField.bfWidth, BattleField.bfHeight + 45));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMenu();

        actionField = new ActionField(this);
        setupPanel = new SetupPanel(this);
        resultPanel = new ResultPanel(this/*, "Defender won."*/);
	}

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        getRootPane().setJMenuBar(menuBar);

        JMenu menuGame = new JMenu("Game");
        menuBar.add(menuGame);

        JMenuItem menuItemNew = new JMenuItem("New");
        menuGame.add(menuItemNew);

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuGame.add(menuItemExit);

        menuItemNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionField.StopGame();

                loadSetupPanel();
            }
        });

        menuItemExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

	public void loadSetupPanel() {
        this.getContentPane().removeAll();
        this.getContentPane().add(setupPanel);
//        this.revalidate();  //  ?
        this.pack();
        this.repaint();
        this.setVisible(true);
	}
	
	public void loadActionField(boolean isTankBT7Selected) {
        actionField.initialize(isTankBT7Selected);
        this.getContentPane().removeAll();
        this.getContentPane().add(actionField);
//        this.revalidate();  //  ?
        this.pack();
        this.repaint();
        this.setVisible(true);
    }

    public void loadResultPanel(boolean defenderWon) {
        this.getContentPane().removeAll();
        resultPanel.setMessage(defenderWon);
        this.getContentPane().add(resultPanel);
//        this.revalidate();  //  ?
        this.pack();
        this.repaint();
        this.setVisible(true);
    }
}

