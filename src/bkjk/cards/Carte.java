/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkjk.cards;

/**
 *
 * @author levortex
 */
public class Carte {

    Couleur couleur;
    String nom;
    int valeur;
    String img;

    public Carte(Couleur c, String n, int v) {
        couleur = c;
        nom = n;
        valeur = v;
        img = nom+"_of_"+couleur;
    }

    @Override
    public String toString(){
        return nom+" of "+couleur+", ";
    }

    public int getValeur() {
        return valeur;
    }

}
