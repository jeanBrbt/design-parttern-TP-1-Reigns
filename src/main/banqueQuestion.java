package main;

import java.util.ArrayList;

public class banqueQuestion {
    /**
     * la banque de questions
     */
    public  ArrayList<Question> questions;


    public banqueQuestion() {
        this.questions = new ArrayList<>();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    public Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    public void init(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                new Effets("Oui", TypeEffet.G),
                new Effets("Non", TypeEffet.D));
        question1.EffetGauche.ajouterEffets(TypeJauge.ARMEE, -5);
        question1.EffetGauche.ajouterEffets(TypeJauge.PEUPLE, +5);
        question1.EffetDroit.ajouterEffets(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                new Effets("Importer de la nourriture", TypeEffet.G),
                new Effets("Ne rien faire", TypeEffet.D));
        question2.EffetGauche.ajouterEffets(TypeJauge.FINANCE,-5);
        question2.EffetGauche.ajouterEffets(TypeJauge.PEUPLE, +5);
        question2.EffetDroit.ajouterEffets(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                new Effets("Faire un sacrifice", TypeEffet.G),
                new Effets("Ne rien faire", TypeEffet.D));
        question3.EffetGauche.ajouterEffets(TypeJauge.CLERGE, +5);
        question3.EffetGauche.ajouterEffets(TypeJauge.PEUPLE, -3);
        question3.EffetDroit.ajouterEffets(TypeJauge.CLERGE, -5);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                new Effets("Le soutenir", TypeEffet.G),
                new Effets("Rester neutre", TypeEffet.D));
        question4.EffetGauche.ajouterEffets(TypeJauge.ARMEE, +3);
        question4.EffetGauche.ajouterEffets(TypeJauge.FINANCE, -3);
        question4.EffetGauche.ajouterEffets(TypeJauge.CLERGE, -3);
        question4.EffetDroit.ajouterEffets(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                new Effets("Taxer énormément", TypeEffet.G),
                new Effets("Taxer un tout petit peu", TypeEffet.D));
        question5.EffetGauche.ajouterEffets(TypeJauge.FINANCE, +10);
        question5.EffetGauche.ajouterEffets(TypeJauge.PEUPLE, -5);
        question5.EffetDroit.ajouterEffets(TypeJauge.FINANCE, +1);
        question5.EffetDroit.ajouterEffets(TypeJauge.PEUPLE, -3);
        questions.add(question5);
    }


}
