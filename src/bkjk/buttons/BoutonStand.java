/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkjk.buttons;

import bkjk.Moteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author levortex
 */
public class BoutonStand extends JButton implements ActionListener {
    
    Moteur m;
    
    public BoutonStand(Moteur mot){
        super("Stand");
        m = mot;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m.stand();
    }

}
