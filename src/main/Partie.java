package main;

public class Partie {
    /**
     * nombre de tour joué
     */
    public static int nbTours=0;
    /**
     * le personnage joué
     */
    private static Personnage personnage;

    /**
     * les jauges
     */
    protected static Jauge jauges;
    /**
     * les questions
     */
    protected static banqueQuestion questions;

    public static void setQuestions(banqueQuestion questions) {
        Partie.questions = questions;
    }

    public Partie(banqueQuestion questions) {
        setQuestions(questions);

    }
    public static void initialiserPartie(){
        System.out.println("Bienvenue sur Reigns");
        System.out.println("Création du personnage...");
        personnage= new Personnage();
        jauges = new Jauge();
        jauges.InitJauge();
        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());
        jauges.AfficheJauges();

    }
    public static void toursDeJeu(){
        while(!jauges.finDuJeu()){
            nbTours++;
            Question question = questions.getQuestionAleatoire();
            question.reponseQuestion(personnage);
            jauges.AfficheJauges();
        }

    }
    public static void messageFinDePartie(){
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }
    public  void lancer(){
        // début du jeu
        initialiserPartie();
        // tirage des questions
        toursDeJeu();
        // fin de partie
        messageFinDePartie();
    }
}
