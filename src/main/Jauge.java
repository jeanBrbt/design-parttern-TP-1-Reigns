package main;


import java.util.HashMap;

/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Jauge {
    /**
     * Le nom de la jauge
     */
    protected TypeJauge nom;
    /**
     * La valeur de la jauge
     */
    protected int valeur;

    protected HashMap<TypeJauge, Jauge> jauges;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *  @param nom Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public Jauge(TypeJauge nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    public Jauge() {

    }

    public void InitJauge(){
        this.jauges = new HashMap<TypeJauge, Jauge>();
        for (TypeJauge type : TypeJauge.values()) {
            this.ajouterJauge(type, new Jauge(type,15 + (int)(Math.random() * (35 - 15))));
        }
    }

    public void ajouterJauge(TypeJauge type, Jauge jauge){
        this.jauges.put(type, jauge);
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {
        for (Jauge jauge : jauges.values()) {
            afficheJauge(jauge);
        }
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
    public void afficheJauge(Jauge jauge) {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.valeur;i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(i>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.nom;
        System.out.println(resultat);
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */

    public boolean finDuJeu(){
        for (Jauge jauge : jauges.values()) {
            if(jauge.getValeur() <= 0 || jauge.getValeur() >= 50){
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne le nom de la jauge.
     *
     * @return le nom de la jauge
     */
    public TypeJauge getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la jauge.
     *
     * @param nom Le nouveau nom de la jauge
     */
    public void setNom(TypeJauge nom) {
        this.nom = nom;
    }

    /**
     * Retourne la valeur de la jauge.
     *
     * @return la valeur de la jauge
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la jauge.
     *
     * @param valeur La nouvelle valeur de la jauge
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne le type de la jauge.
     *
     * @return le type de la jauge
     */
    public TypeJauge getType() {
        return nom;
    }

    /**
     * Modifie le type de la jauge.
     *
     * @param nom Le nouveau type de la jauge
     */
    public void setType(TypeJauge nom) {
        this.nom = nom;
    }
}
