package main;

public class jaugeClerge extends Jauge{
    protected jaugeClerge jaugeClerge;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public jaugeClerge(String nom, int valeur) {
        super(nom, valeur);

        jaugeClerge = new jaugeClerge("Clergé", 15 + (int)(Math.random() * (35 - 15)));
    }
}
