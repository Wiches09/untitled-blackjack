/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Waiting;

import Gameplay.Game.GamePOJO;
import Main.MainRunner;
import UI.Controller.CustomFrame;
import UI.Lobby.LobbyController;

import javax.swing.*;
import java.awt.Font;

/**
 * @author Yongyut Chanuphat
 */
public class WaitingRoomGUI extends CustomFrame {
    private WaitingRoomController controller;

    public WaitingRoomGUI(WaitingRoomController controller) {
        init();
        setAllowStartButton(false);
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundWaitingPanel = new javax.swing.JPanel();
        waitingPanel = new javax.swing.JPanel();
        waitingLabel = new javax.swing.JLabel();
        playerPanel = new javax.swing.JPanel();
        playerOneLabel = new javax.swing.JLabel();
        playerTwoLabel = new javax.swing.JLabel();
        passcodeLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundWaitingPanel.setBackground(new java.awt.Color(0, 51, 51));
        backgroundWaitingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 10));
        backgroundWaitingPanel.setForeground(new java.awt.Color(0, 102, 51));
        backgroundWaitingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        waitingPanel.setBackground(new java.awt.Color(102, 102, 102));
        waitingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        waitingPanel.setLayout(new java.awt.GridBagLayout());

        waitingLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        waitingLabel.setForeground(new java.awt.Color(255, 255, 255));
        waitingLabel.setText("Waiting");
        waitingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                waitTingGraphic(evt);
            }
        });
        waitingPanel.add(waitingLabel, new java.awt.GridBagConstraints());

        backgroundWaitingPanel.add(waitingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 430, 130));

        playerPanel.setBackground(new java.awt.Color(204, 0, 51));
        playerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 5));

        playerOneLabel.setBackground(new java.awt.Color(255, 255, 255));
        playerOneLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        playerOneLabel.setForeground(new java.awt.Color(255, 255, 255));
        playerOneLabel.setText("Player :");
        playerOneLabel.setMaximumSize(new java.awt.Dimension(400, 48));
        playerOneLabel.setMinimumSize(new java.awt.Dimension(400, 48));
        playerOneLabel.setPreferredSize(new java.awt.Dimension(400, 48));

        playerTwoLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        playerTwoLabel.setForeground(new java.awt.Color(255, 255, 255));
        playerTwoLabel.setText("Player :");
        playerTwoLabel.setMaximumSize(new java.awt.Dimension(400, 48));
        playerTwoLabel.setMinimumSize(new java.awt.Dimension(400, 48));
        playerTwoLabel.setPreferredSize(new java.awt.Dimension(400, 48));

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerOneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerTwoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addComponent(playerOneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(playerTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        backgroundWaitingPanel.add(playerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 430, 140));

        passcodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        passcodeLabel.setForeground(new java.awt.Color(255, 255, 255));
        passcodeLabel.setText("PASSCODE : XXXXX");
        backgroundWaitingPanel.add(passcodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, 430, 50));

        startButton.setBackground(new java.awt.Color(255, 51, 51));
        startButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        backgroundWaitingPanel.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 140, 60));

        getContentPane().add(backgroundWaitingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        // set Player 1 ready state
        controller.startGame();
    }//GEN-LAST:event_startButtonActionPerformed

    public void init() {
        initComponents();
        this.setLocationRelativeTo(null);
        passcodeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        waitingLabel.setFont(new Font("Arial", Font.BOLD, 36));
        playerOneLabel.setFont(new Font("Arial", Font.BOLD, 36));
        playerTwoLabel.setFont(new Font("Arial", Font.BOLD, 36));
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundWaitingPanel;
    private javax.swing.JLabel passcodeLabel;
    private javax.swing.JLabel playerOneLabel;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JLabel playerTwoLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel waitingLabel;
    private javax.swing.JPanel waitingPanel;
    // End of variables declaration//GEN-END:variables

    public void setAllowStartButton(boolean status) {
        startButton.setEnabled(status);
    }

    @Override
    public void onSwitch() {
        String pass = MainRunner.getGameContext().getGame().getGame().getPasscode();
        passcodeLabel.setText("Passcode : " + pass);
        System.out.println(MainRunner.getGameContext().getPlayers()[0].getPlayer().getUsername());
        System.out.println(MainRunner.getGameContext().getPlayers()[1].getPlayer().getUsername());
        playerOneLabel.setText("Player : " + MainRunner.getGameContext().getPlayers()[0].getPlayer().getUsername());
        this.setTitle("Passcode : " + MainRunner.getGameContext().getGame().getGame().getPasscode());
    }

    @Override
    public void onUpdate() {
        String labelTextA = "Player1 : waiting...";
        String labelTextB = "Player2 : waiting...";
        boolean statusA = MainRunner.getGameContext().getPlayers()[0].getPlayer().isReady();
        boolean statusB = MainRunner.getGameContext().getPlayers()[1].getPlayer().isReady();
        String usernameA = MainRunner.getGameContext().getPlayers()[0].getPlayer().getUsername();
        String usernameB = MainRunner.getGameContext().getPlayers()[1].getPlayer().getUsername();
        if (usernameA != null) {
            labelTextA = "Player1 : " + usernameA;
        }
        if (usernameB != null) {
            labelTextB = "Player2 : " + usernameB;
        }
        System.out.println(!statusA);
        System.out.println(statusB);
        if (statusA == false && statusB == true){
            System.out.println("two players joined the room.");
            startButton.setEnabled(true);
        }
        System.out.println(usernameA + "    /     " + usernameB);
        playerOneLabel.setText(labelTextA);
        playerTwoLabel.setText(labelTextB);
    }
}
