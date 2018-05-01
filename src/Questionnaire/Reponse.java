/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
package Questionnaire;

public class Reponse {

	String reponse;
	boolean correcte = false;
	boolean active = true;
	
	public Reponse(String reponse){
		this.reponse = reponse;
	}
	
	public void setCorrecte(){
		this.correcte = true;
	}
	
	public String getReponse() {
		return reponse;
	}

	public boolean isCorrecte() {
		return correcte;
	}

	public boolean isActive() {
		return active;
	}

	public void setDesable(){
		this.active = false;
	}
	public String toString(){
		return this.reponse+" "+this.correcte+" "+this.active;
	}
}
