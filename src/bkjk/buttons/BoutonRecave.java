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
public class BoutonRecave extends JButton implements ActionListener {

    Moteur m;

    public BoutonRecave(Moteur mot) {
        super("Recave");
        m = mot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m.getFlambeur().setMonnaie(1000);
        m.setMise(0);
        m.getGo().setEnabled(false);
        System.out.println("Monnaie " + m.getFlambeur().getMonnaie() + " Mise " + m.getMise());
    }
}