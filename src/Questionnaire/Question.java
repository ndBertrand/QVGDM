/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
package Questionnaire;

import java.util.Random;

import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Question {

	private String question;
	private Reponse[] reponses = new Reponse[4];
	private String publique;
	private int correcte;
	
	
	public Question(String question,String reponses[],int correcte){
		this.question = question;
		for(int i = 0;i<this.reponses.length;i++){
			this.reponses[i] = new Reponse(reponses[i]);
		}
		this.correcte = correcte-1;
		this.reponses[this.correcte].setCorrecte();	
	}
	
	
	
	public String getQuestion() {
		return question;
	}



	public Reponse[] getReponses() {
		return reponses;
	}



	public Reponse getCorrecte(){
		return this.reponses[this.correcte];
	}
	
	public String toString(){
		String chaine = "";
		chaine =  this.question+"\n";
		for(Reponse rep : this.reponses){
			chaine = chaine + rep+"\n";
		}
	    chaine= chaine+"-----------------------------------------------------";
	    return chaine;
				
	}
	
	public int nbreReponseActive(){
		int n = 0;
		for(Reponse rep:this.reponses){
			if(rep.isActive())
				n++;
		}
		return n;
	}
	
	public String[] reponseActive(){
		String[] repActive = new String[2];
		repActive[0] = this.reponses[this.correcte].getReponse();
		int i = 0;
		while(!this.reponses[i].isActive() || i==this.correcte){
			i++;
		}
		repActive[1] = this.reponses[i].getReponse();
		
		return repActive;
	}
	public void cinquanteCinquante(){
		Random rand = new Random();
		int valeur;
		while(nbreReponseActive() > 2){
			valeur = rand.nextInt(4);
			if(valeur !=this.correcte){
				this.reponses[valeur].setDesable();
			}
		}
	}
	
	public void publique(){
		int nbrRepActive;
		nbrRepActive  = nbreReponseActive();
		Random rand = new Random();
		
		int valeur1,valeur2,valeur3 = 0,valeur4 = 0;
		
		
		final DefaultPieDataset pieDataset = new DefaultPieDataset();
		String[] repActive = reponseActive();
		if (nbrRepActive == 2){
			System.out.println(" il nous reste 2"+repActive[0]+ " "+repActive[1]);
			valeur1 = rand.nextInt(75);
			valeur2 = 100 - valeur1;
			
			
			pieDataset.setValue(repActive[0], valeur1);
			pieDataset.setValue(repActive[1], valeur2);
		}
		else if(nbrRepActive ==4){
			valeur1 = rand.nextInt(50);
			valeur2 = 100 - valeur1;
			valeur3 = rand.nextInt(50);
			valeur4 = 100 - valeur3;
			
			pieDataset.setValue(this.reponses[0].getReponse(), valeur1);
			pieDataset.setValue(this.reponses[1].getReponse(), valeur2);
			pieDataset.setValue(this.reponses[2].getReponse(), valeur3);
			pieDataset.setValue(this.reponses[3].getReponse(), valeur4);
		}
		
		final JFreeChart pieChart = ChartFactory.createPieChart("Avis du public", pieDataset, true, false, false);
		final ChartPanel cPanel = new ChartPanel(pieChart);
		
		JDialog dial = new JDialog();
		dial.setTitle("avis du public");
		dial.getContentPane().add(cPanel);
		dial.setSize(400,400);
		
		dial.setVisible(true);
		dial.setLocationRelativeTo(null);
	}
}
