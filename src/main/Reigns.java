package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns  {
    /**
     * le personnage joué
     */
    private static Personnage personnage;

    /**
     * les jauges
     */
    protected static Jauge jauges;

    /**
     * la banque de questions
     */
    private static ArrayList<Question> questions;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){
        banqueQuestion Bquestions= new banqueQuestion();
        Bquestions.init();

        // début du jeu
        System.out.println("Bienvenue sur Reigns");
        System.out.println("Création du personnage...");

        initPersonnage();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        jauges.InitJauge();

        jauges.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        while(!jauges.finDuJeu()){
            nbTours++;
            Question question = Bquestions.getQuestionAleatoire();
            //reponseQuestion(question);
            question.reponseQuestion(personnage);
            jauges.AfficheJauges();
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }



    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    private static void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine;
        if(genre==1){
            roiReine = Genre.ROI;
        }else{
            roiReine = Genre.REINE;
        }

        Reigns.personnage = new Personnage(nom,roiReine);
        Reigns.jauges = new Jauge();
    }

}