/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkjk;

import bkjk.cards.Carte;
import java.util.ArrayList;

/**
 *
 * @author levortex
 */
public class Joueur {
    
    ArrayList<Carte> cartes;
    Moteur m;
    int monnaie;
    
    Joueur(Moteur mot){
        cartes = new ArrayList<Carte>();
        m = mot;
        monnaie = 1000;
        
    }
    
    public int somme(){
        int res = 0;
        int resMax = 0;
        boolean asPresent = false;
        for(Carte carte : cartes){
            res += carte.getValeur();
            resMax += carte.getValeur();
            if(carte.getValeur() == 1 && !asPresent){
                resMax += 10;
                asPresent = true;
            }
        }
        if(resMax<=21){
            return resMax;
        } else {
            return res;
        }
    }
    
    public void reinitialise(){
        cartes.clear();
    }
    
    public void tire(){
        Carte tirage = m.deck.tire();
        cartes.add(tirage);
        System.out.print(tirage);
    }
    
    public ArrayList<Carte> getCartes() {
        return cartes;
    }
    
    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }
    
    public Moteur getM() {
        return m;
    }
    
    public void setM(Moteur m) {
        this.m = m;
    }
    
    public int getMonnaie() {
        return monnaie;
    }
    
    public void setMonnaie(int monnaie) {
        this.monnaie = monnaie;
    }
    
}
