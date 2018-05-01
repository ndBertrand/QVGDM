/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
package Questionnaire;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {

	private List<Question> questionnaire = new ArrayList<Question>(2);
	
	public Questionnaire(){
		lectureFichier("src/Questionnaire/question.txt");
	}
	
	
	public List<Question> getQuestionnaire() {
		return questionnaire;
	}


	public  void lectureFichier(String nomFichier) {
		int i = 0;
		Question question;
		FileInputStream fInput = null;
		try {

			fInput = new FileInputStream(nomFichier);
			InputStreamReader reader = new InputStreamReader(fInput);
			BufferedReader br = new BufferedReader(reader);

			
			String ligne;

			
			while ((ligne = br.readLine()) != null) {
				
					String split[] = ligne.split(";");
					String rep[] = {split[1],split[2],split[3],split[4]};
					question = new Question(split[0],rep,Integer.parseInt(split[5]));
				    this.questionnaire.add(question);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Fermeture du fichier */
		if (fInput != null) {
			try {
				fInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void afficherQuestion(){
		for(Question q: this.questionnaire){
			System.out.println(q);
		}
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stu
		Questionnaire Q = new Questionnaire();
		Q.questionnaire.get(0).cinquanteCinquante();
		Q.afficherQuestion();
		Q.questionnaire.get(0).publique();

	}*/

}
