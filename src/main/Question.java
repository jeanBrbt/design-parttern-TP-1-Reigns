package main;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
    protected String effets;

    protected Effets EffetGauche, EffetDroit;

    /**
     * les effets sur les jauges pour la réponse de droite
     */
    protected Map<TypeJauge, Jauge> effetsJauge;
    protected Map<TypeJauge, Integer> jauges;

    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser
     * @param EffetGauche L'effet de la réponse de gauche
     * @param EffetDroit L'effet de la réponse de droite
     * */
    public Question(String nomPersonnage,
                    String question,
                    Effets EffetGauche,
                    Effets EffetDroit) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.EffetGauche = EffetGauche;
        this.EffetDroit = EffetDroit;
        this.effetsJauge = new TreeMap<>();
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+ EffetGauche.effetDesc
                + ",D: "+ EffetDroit.effetDesc
                + "]";
        System.out.println(result);
        System.out.println("Effet G:"+ EffetGauche.afficheEffets(effetsJauge));
        System.out.println("Effet D:"+ EffetDroit.afficheEffets(effetsJauge));
        System.out.flush();
    }


    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param personnage La question à laquelle il faut répondre
     */
    public void reponseQuestion(Personnage personnage){
        this.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        if(reponse.equals("G")){
            EffetGauche.appliqueEffets(jauges, effetsJauge);
        }else{
            EffetDroit.appliqueEffets(jauges, effetsJauge);
        }
    }

    /**
     * Retourne le nom du personnage associé à la question.
     *
     * @return le nom du personnage associé à la question
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    /**
     * Modifie le nom du personnage associé à la question.
     *
     * @param nomPersonnage le nouveau nom du personnage associé à la question
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    /**
     * Retourne la question.
     *
     * @return la question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question.
     *
     * @param question la nouvelle question
     */
    public void setQuestion(String question) {
        this.question = question;
    }
}
