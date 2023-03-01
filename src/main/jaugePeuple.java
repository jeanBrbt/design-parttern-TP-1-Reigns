package main;

public class jaugePeuple extends Jauge{
    protected jaugePeuple jaugePeuple;
    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public jaugePeuple(String nom, int valeur) {
        super(nom, valeur);

        jaugePeuple = new jaugePeuple("Peuple", 15 + (int)(Math.random() * (35 - 15)));
    }
}
