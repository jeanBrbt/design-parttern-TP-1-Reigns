package main;

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
