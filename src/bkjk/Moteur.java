/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkjk;

import bkjk.cards.Deck;
import bkjk.buttons.BoutonGo;
import bkjk.buttons.BoutonNew;
import bkjk.buttons.BoutonBetUp;
import bkjk.buttons.BoutonDouble;
import bkjk.buttons.BoutonHit;
import bkjk.buttons.BoutonStand;
import bkjk.buttons.BoutonRecave;
import bkjk.buttons.BoutonBetDown;

/**
 *
 * @author levortex
 */
public class Moteur {

    Deck deck;
    Joueur croupier;
    Joueur flambeur;
    BoutonHit hit;
    BoutonStand stand;
    BoutonNew nouveau;
    BoutonBetUp up;
    BoutonBetDown down;
    BoutonDouble doub;
    BoutonGo go;
    BoutonRecave recave;
    int mise;

    Moteur() {

        deck = new Deck();
        croupier = new Joueur(this);
        flambeur = new Joueur(this);

        hit = new BoutonHit(this);
        hit.addActionListener(hit);
        stand = new BoutonStand(this);
        stand.addActionListener(stand);
        nouveau = new BoutonNew(this);
        nouveau.addActionListener(nouveau);
        up = new BoutonBetUp(this);
        up.addActionListener(up);
        down = new BoutonBetDown(this);
        down.addActionListener(down);
        go = new BoutonGo(this);
        go.addActionListener(go);
        doub = new BoutonDouble(this);
        doub.addActionListener(doub);
        recave = new BoutonRecave(this);
        recave.addActionListener(recave);

        nouvellePartie();

    }

    public void analyseTirage(int tour) {
        if (flambeur.somme() > 21) {
            System.out.println("You Lose!\n");
            stand.setEnabled(false);
            hit.setEnabled(false);
            doub.setEnabled(false);
            nouveau.setEnabled(true);
        } else if (flambeur.cartes.size() == 5) {
            System.out.println("Charlie!\n");
            flambeur.monnaie += mise * 4;
            stand.setEnabled(false);
            hit.setEnabled(false);
            doub.setEnabled(false);
            nouveau.setEnabled(true);
        } else if (flambeur.somme() == 21 && flambeur.cartes.size() == 2) {
            System.out.println("Black Jack!\n");
            flambeur.monnaie += mise * 3;
            stand.setEnabled(false);
            hit.setEnabled(false);
            doub.setEnabled(false);
            nouveau.setEnabled(true);
        } else if (flambeur.somme() == 21) {
            stand();
        } else {
            if (tour == 2) {
                stand();
            } else {
                stand.setEnabled(true);
                hit.setEnabled(true);
                nouveau.setEnabled(false);
                if (tour == 0 && flambeur.monnaie >= mise) {
                    doub.setEnabled(true);
                }
            }
        }
    }

    public void stand() {

        stand.setEnabled(false);
        hit.setEnabled(false);
        nouveau.setEnabled(false);
        doub.setEnabled(false);
        System.out.print("\n");

        do {
            croupier.tire();
        } while (croupier.somme() < flambeur.somme());
        if (croupier.somme() > 21) {
            System.out.println("You Win!\n");
            flambeur.monnaie += mise * 2;
        } else if (croupier.somme() == flambeur.somme()) {
            System.out.println("Draw!\n");
            flambeur.monnaie += mise;
        } else {
            System.out.println("You Lose!\n");
        }

        nouveau.setEnabled(true);

    }

    public void nouvellePartie() {
        mise = 0;
        System.out.println("Monnaie "+flambeur.monnaie+" Mise "+mise);
        stand.setEnabled(false);
        hit.setEnabled(false);
        nouveau.setEnabled(false);
        go.setEnabled(false);
        up.setEnabled(true);
        down.setEnabled(true);
        doub.setEnabled(false);
        recave.setEnabled(true);
    }

    public void go() {

        go.setEnabled(false);
        up.setEnabled(false);
        down.setEnabled(false);
        recave.setEnabled(false);
        

        deck.reinitialise();
        flambeur.reinitialise();
        croupier.reinitialise();

        croupier.tire();
        System.out.println();
        flambeur.tire();
        flambeur.tire();

        analyseTirage(0);

    }

    public Joueur getCroupier() {
        return croupier;
    }

    public void setCroupier(Joueur croupier) {
        this.croupier = croupier;
    }
    
    public Joueur getFlambeur() {
        return flambeur;
    }

    public void setFlambeur(Joueur flambeur) {
        this.flambeur = flambeur;
    }

    public int getMise() {
        return mise;
    }

    public void setMise(int mise) {
        this.mise = mise;
    }

    public BoutonGo getGo() {
        return go;
    }
  
}
