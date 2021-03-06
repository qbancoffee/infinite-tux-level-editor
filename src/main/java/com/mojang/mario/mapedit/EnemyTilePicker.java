/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mojang.mario.mapedit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import com.mojang.mario.*;
import static com.mojang.mario.Art.enemies;
import com.mojang.mario.sprites.Enemy;
/**
 *
 * @author pedro
 */
public class EnemyTilePicker extends javax.swing.JPanel {

private int xTile = -1;
    private int yTile = -1;
    
    public int pickedEnemy;
    public int status = 2;

    @SuppressWarnings("unused")
	private byte paint = 0;
    private NewLevelEditor enemyPickChangedListener;
    /**
     * Creates new form EnemyTilePicker
     */
    public EnemyTilePicker() {
        initComponents();
        Dimension size = new Dimension(256, 256);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        //addMouseListener(this);
        //addMouseMotionListener(this);   
        setOpaque(true);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        xTile = -1;
        yTile = -1;
        repaint();
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xTile = evt.getX() / 16;
        yTile = evt.getY() / 32;

        setPickedEnemy(xTile,getEnemyType(yTile));
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        xTile = evt.getX() / 16;
        yTile = evt.getY() / 32;
        setPickedEnemy(xTile,getEnemyType(yTile));

        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        xTile = evt.getX() / 16;
        yTile = evt.getY() / 32;
        repaint();
    }//GEN-LAST:event_formMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void addNotify()
    {
        super.addNotify();
        Art.init(getGraphicsConfiguration(), null);
    }    
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(new Color(0x8090ff));
        g.fillRect(0, 0, 256, 256);
        
        for (int x=0; x<16; x++)
            for (int y=0; y<8; y++)
            {
                g.drawImage(Art.enemypicker[x][y], (x << 4), (y << 5), null);
            }

        g.setColor(Color.WHITE);
        //int xPickedTile = (pickedEnemy&0xff)%16;
       // int yPickedTile = (pickedEnemy&0xff)/32;
        //g.drawRect(xPickedTile * 16, yPickedTile * 32, 15, 31);

        g.setColor(Color.BLACK);
        g.drawRect(xTile * 16 - 1, yTile * 32 - 1, 17, 33);
    }    





 


   
    public void setPickedEnemy(int row,int enemyType)
    {
        pickedEnemy = enemyType;
        status = row;
        repaint();
        if (enemyPickChangedListener!=null){
           enemyPickChangedListener.setPickedEnemy(pickedEnemy);
        }
    }

        public void addEnemyPickChangedListener(NewLevelEditor editor)
    {
        enemyPickChangedListener = editor;
        if (enemyPickChangedListener!=null){
            enemyPickChangedListener.setPickedEnemy(pickedEnemy);
        }
    }
        
NewLevelEditor getNewLevelEditor(){
    return this.enemyPickChangedListener;
    
}  


int getEnemyType(int et){
    int enemyType = -1;
    
    switch(et){
        case 0:
            enemyType = Enemy.ENEMY_RED_KOOPA;
            break;
        case 1:
            enemyType = Enemy.ENEMY_GREEN_KOOPA;
            break;
        case 2:
            enemyType = Enemy.ENEMY_GOOMBA;
            break;
        case 3:
            enemyType = Enemy.ENEMY_SPIKY;
            break;
        case 4:
            enemyType = Enemy.ENEMY_GOOMBA;
            break;
        case 5:
            enemyType = Enemy.ENEMY_GOOMBA;
            break;
        case 6:
            enemyType = Enemy.ENEMY_FLOWER;
            break;            
    
    
    }
    
return enemyType;
}
}
