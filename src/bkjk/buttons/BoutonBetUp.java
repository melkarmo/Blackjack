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
public class BoutonBetUp extends JButton implements ActionListener {

    Moteur m;

    public BoutonBetUp(Moteur mot) {
        super("Up");
        m = mot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (m.getFlambeur().getMonnaie() > 0) {
            m.getFlambeur().setMonnaie( m.getFlambeur().getMonnaie() - 100 );
            m.setMise( m.getMise() + 100 );
            m.getGo().setEnabled(true);
        }
        System.out.println("Monnaie "+m.getFlambeur().getMonnaie()+" Mise "+m.getMise());
    }
}
