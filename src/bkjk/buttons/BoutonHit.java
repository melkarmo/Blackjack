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
public class BoutonHit extends JButton implements ActionListener {

    Moteur m;

    public BoutonHit(Moteur mot) {
        super("Hit");
        m = mot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m.getFlambeur().tire();
        m.analyseTirage(1);
    }

}
