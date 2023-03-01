package main;

public class jaugeFinance extends Jauge{
    protected Jauge jaugeFinance;
    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public jaugeFinance(String nom, int valeur) {
        super(nom, valeur);

        jaugeFinance = new jaugeFinance("Finances", 15 + (int)(Math.random() * (35 - 15)));
    }
}
