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
public class BoutonDouble extends JButton implements ActionListener {

    Moteur m;

    public BoutonDouble(Moteur mot) {
        super("Double");
        m = mot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setEnabled(false);
        m.getFlambeur().setMonnaie( m.getFlambeur().getMonnaie() - m.getMise() );
        m.setMise( m.getMise() + m.getMise() );
        System.out.print("\nDouble! Monnaie "+m.getFlambeur().getMonnaie()+" Mise "+m.getMise()+", ");
        m.getFlambeur().tire();
        m.analyseTirage(2);
    }
}
