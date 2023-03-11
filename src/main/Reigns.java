package main;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns  {


    /**
     * Dans la méthode on initialise les questions et on lance une partie
     */
    public static void main(String[] args){
        banqueQuestion questionsPartie1= new banqueQuestion();
        questionsPartie1.init();
        Partie p = new Partie(questionsPartie1);
        p.lancer();

    }

}