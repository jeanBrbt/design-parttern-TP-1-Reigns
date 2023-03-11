package main;

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

        initGame();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());


        jauges.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        while(!jauges.finDuJeu()){
            nbTours++;
            Question question = Bquestions.getQuestionAleatoire();
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
    private static void initGame(){
        Reigns.personnage= new Personnage();
        Reigns.jauges = new Jauge();
        Reigns.jauges.InitJauge();
    }

}