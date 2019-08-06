/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkjk.cards;

import java.util.Random;

import java.util.Stack;

/**
 *
 * @author levortex
 */
public class Deck {

    Stack tirees;
    Carte[] deck;

    public Deck() {
        tirees = new Stack();
        deck = new Carte[52];
        for (int i = 2; i < 11; i++) {
            deck[i - 1] = new Carte(Couleur.clubs, "" + i, i);
            deck[i - 1 + 13] = new Carte(Couleur.hearts, "" + i, i);
            deck[i - 1 + 13 * 2] = new Carte(Couleur.diamonds, "" + i, i);
            deck[i - 1 + 13 * 3] = new Carte(Couleur.spades, "" + i, i);
        }

        deck[0] = new Carte(Couleur.clubs, "ace", 1);
        deck[13] = new Carte(Couleur.hearts, "ace", 1);
        deck[26] = new Carte(Couleur.diamonds, "ace", 1);
        deck[39] = new Carte(Couleur.spades, "ace", 1);

        deck[10] = new Carte(Couleur.clubs, "jack", 10);
        deck[23] = new Carte(Couleur.hearts, "jack", 10);
        deck[36] = new Carte(Couleur.diamonds, "jack", 10);
        deck[49] = new Carte(Couleur.spades, "jack", 10);

        deck[11] = new Carte(Couleur.clubs, "queen", 10);
        deck[24] = new Carte(Couleur.hearts, "queen", 10);
        deck[37] = new Carte(Couleur.diamonds, "queen", 10);
        deck[50] = new Carte(Couleur.spades, "queen", 10);

        deck[12] = new Carte(Couleur.clubs, "king", 10);
        deck[25] = new Carte(Couleur.hearts, "king", 10);
        deck[38] = new Carte(Couleur.diamonds, "king", 10);
        deck[51] = new Carte(Couleur.spades, "king", 10);

    }

    public Carte tire() {
        Random r = new Random();
        int indCarte;
        do {
            indCarte = r.nextInt(52);
        } while (tirees.contains(indCarte));
        tirees.push(indCarte);
        return deck[indCarte];
    }

    public void reinitialise() {
        tirees.clear();
    }

}
