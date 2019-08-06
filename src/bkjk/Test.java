/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkjk;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 *
 * @author levortex
 */
public class Test {

    public static void main(String[] args) {
        
        Moteur m = new Moteur();
        
        JFrame f = new JFrame("Simple Solo Black Jack");
        JPanel p = (JPanel) f.getContentPane();
        
        p.setLayout(new GridLayout(4,2));
        p.add(m.hit);
        p.add(m.stand);
        p.add(m.nouveau);
        p.add(m.up);
        p.add(m.down);
        p.add(m.go);
        p.add(m.doub);
        p.add(m.recave);
        
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }

}
