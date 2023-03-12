package main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Effets {
    // Atributs

    protected Map<TypeJauge, Integer> effetJauge;
    protected TypeEffet typeEffet;
    protected String effetDesc;


    public Effets(String effetDesc, TypeEffet typeEffet) {
        this.effetDesc = effetDesc;
        this.typeEffet = typeEffet;
        this.effetJauge = new HashMap<TypeJauge, Integer>();
    }

    // Methods

    /**
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     *
     * @param effetJauge La map des effets de jauge
     * @return la chaîne de caractères représentant les effets de la jauge
     */
    public String afficheEffets(Map<TypeJauge, Jauge> effetJauge) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<TypeJauge, Jauge> effet : effetJauge.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            int valeur = effet.getValue().getValeur();
            if (valeur > 0) {
                result.append("+");
            }
            result.append(effet.getValue().getValeur());
        }
        return result.toString();
    }

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param jauges le personnage sur lequel les effets doivent être appliqués
     */
    public void appliqueEffets(Map<TypeJauge, Integer> effets,
                               Map<TypeJauge, Jauge> jauges) {
        for (Map.Entry<TypeJauge, Integer> effet : effets.entrySet()) {

            for (Map.Entry<TypeJauge, Jauge> jauge : jauges.entrySet()) {

                if (jauge.getKey().equals(effet.getKey())) {
                    jauge.getValue().setValeur(jauge.getValue().getValeur() + effet.getValue());
                    this.appliqueEffets(effetJauge, jauges);
                }
            }
        }
    }

    public void ajouterEffets(TypeJauge jauge, int valeur) {
        effetJauge.put(jauge, valeur);
    }
}
