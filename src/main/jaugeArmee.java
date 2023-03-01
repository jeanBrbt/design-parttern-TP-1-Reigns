package main;

public class jaugeArmee extends Jauge{
    protected Jauge jaugeArmee;
    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public jaugeArmee(String nom, int valeur) {
        super(nom, valeur);

        jaugeArmee = new jaugeArmee("Armée", 15 + (int)(Math.random() * (35 - 15)));
    }
}
