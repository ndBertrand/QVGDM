/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import Questionnaire.Questionnaire;
import Questionnaire.Reponse;
import images.Dessin;
import images.MonBouton;

import java.awt.event.*;

public class Game extends JFrame {

	private static int currentQuestion = 0;
	private static int palier = 8;
	Questionnaire Epreuve = new Questionnaire();
	private JButton cinquante = new MonBouton("Eliminer 2 mauvaise réponse", 2);
	private JButton publique = new MonBouton("Aide du publique", 3);
	private JButton ami = new MonBouton("Appeler à un Ami(e)", 4);

	private JButton reponseA = new MonBouton("Reponse", 1);
	private JButton reponseB = new MonBouton("Reponse", 1);
	private JButton reponseC = new MonBouton("Reponse", 1);
	private JButton reponseD = new MonBouton("Reponse", 1);

	private JLabel Question = new JLabel();
	JButton tot;

	private JList<String> gain = new JList();

	public Game() {
		initialisation();
		jouer();
	}

	/* initialisation de la Fenetre et disposition des diffenrent composant */
	public void initialisation() {
		this.setTitle("QVGDM");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

		JPanel panneau1 = new JPanel();
		JPanel sousPan1 = new JPanel();
		JPanel sousPan2 = new JPanel();
		JPanel panneau2 = new JPanel();
		JPanel panneau3 = new JPanel();

		this.setLayout(new BorderLayout());
		this.add(panneau1, BorderLayout.NORTH);
		this.add(panneau2, BorderLayout.CENTER);
		this.add(panneau3, BorderLayout.SOUTH);

		panneau1.setLayout(new BorderLayout());
		panneau1.add(sousPan1, BorderLayout.WEST);
		panneau1.add(sousPan2, BorderLayout.CENTER);

		sousPan1.setLayout(new GridLayout(3, 1));
		sousPan1.add(cinquante);
		sousPan1.add(publique);
		sousPan1.add(ami);

		sousPan2.setBackground(Color.decode("#6A0888"));
		gain.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "1 000 000", "300 000", "150 000", "72 000", "48 000", "12 000", "6 000", "3 000",
					"1 500" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		gain.setBackground(Color.decode("#6A0888"));
		gain.setForeground(Color.decode("#B45F04"));
		gain.setEnabled(false);
		sousPan2.add(gain);

		panneau2.setLayout(new BorderLayout());
		tot = new MonBouton("0", 5);
		panneau2.add(tot, BorderLayout.NORTH);
		Dessin ds = new Dessin("src/images/logo.jpg");
		panneau2.add(ds, BorderLayout.CENTER);
		panneau2.add(Question, BorderLayout.SOUTH);

		panneau3.setLayout(new GridLayout(2, 2));
		panneau3.add(reponseA);
		panneau3.add(reponseB);
		panneau3.add(reponseC);
		panneau3.add(reponseD);

		Question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Question.setBackground(Color.decode("#B45F04"));
		Question.setForeground(Color.white);
		Question.setFont(new java.awt.Font("Times New Roman", 1, 18));
		Question.setOpaque(true);

		cinquante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cinguanteActionPerformed(evt, currentQuestion);
			}
		});

		publique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				publiqueActionPerformed(evt, currentQuestion);
			}
		});

		ami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				amiActionPerformed(evt, currentQuestion);
			}
		});

		reponseA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reponseActionPerformed(evt, currentQuestion, 0);

			}

		});
		reponseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reponseActionPerformed(evt, currentQuestion, 1);
			}

		});
		reponseC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reponseActionPerformed(evt, currentQuestion, 2);
			}
		});
		reponseD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reponseActionPerformed(evt, currentQuestion, 3);
			}
		});
	}

	public void initialisationVariable(int current) {
		Question.setText(Epreuve.getQuestionnaire().get(current).getQuestion());

		reponseA.setText(Epreuve.getQuestionnaire().get(current).getReponses()[0].getReponse());
		reponseB.setText(Epreuve.getQuestionnaire().get(current).getReponses()[1].getReponse());
		reponseC.setText(Epreuve.getQuestionnaire().get(current).getReponses()[2].getReponse());
		reponseD.setText(Epreuve.getQuestionnaire().get(current).getReponses()[3].getReponse());

		reponseA.setEnabled(true);
		reponseB.setEnabled(true);
		reponseC.setEnabled(true);
		reponseD.setEnabled(true);

	}
	/**/

	public void jouer() {

		if (this.currentQuestion < Epreuve.getQuestionnaire().size()) {
			initialisationVariable(this.currentQuestion);
		}

		else {
			String msg;
			if (this.palier == 8) {
				msg = " Désolé vous n'avez répondu correctement à aucune question";
			} else {
				msg = "Votre Gain est de" + this.gain.getSelectedValue();
			}
			JOptionPane.showMessageDialog(null, msg, "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "AU REVOIR", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);

		}
	}

	private void GagnerArgent() {

		gain.setSelectedIndex(palier);
		String gainTotal = gain.getSelectedValue();
		gain.setSelectionBackground(Color.black);
		gain.setSelectionForeground(Color.decode("#B45F04"));
		tot.setText(gainTotal);

	}

	private void updateButton(int current) {
		reponseA.setEnabled(Epreuve.getQuestionnaire().get(current).getReponses()[0].isActive());
		reponseB.setEnabled(Epreuve.getQuestionnaire().get(current).getReponses()[1].isActive());
		reponseC.setEnabled(Epreuve.getQuestionnaire().get(current).getReponses()[2].isActive());
		reponseD.setEnabled(Epreuve.getQuestionnaire().get(current).getReponses()[3].isActive());
	}

	/*
	 * ======================================EVENEMENT==========================
	 * ===============
	 */
	private void cinguanteActionPerformed(ActionEvent evt, int current) {
		// TODO add your handling code here:
		this.Epreuve.getQuestionnaire().get(current).cinquanteCinquante();
		updateButton(current);
		this.cinquante.setEnabled(false);
	}

	private void publiqueActionPerformed(ActionEvent evt, int current) {
		// TODO add your handling code here:
		this.Epreuve.getQuestionnaire().get(current).publique();
		this.publique.setEnabled(false);
	}

	private void amiActionPerformed(ActionEvent evt, int current) {
		// TODO add your handling code here:
		try {
			Runtime.getRuntime().exec("skype");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.ami.setEnabled(false);
	}

	private void reponseActionPerformed(ActionEvent evt, int current, int numRep) {
		// TODO add your handling code here:
		boolean correct = this.Epreuve.getQuestionnaire().get(current).getReponses()[numRep].isCorrecte();
		if (correct) {
			JOptionPane.showMessageDialog(null, "Réponse Correcte", "", JOptionPane.INFORMATION_MESSAGE);
			this.GagnerArgent();
			palier--;
		} else {
			Reponse repCorrect = this.Epreuve.getQuestionnaire().get(current).getCorrecte();
			JOptionPane.showMessageDialog(null, "Réponse Incorrectes", "", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "La bonne réponse était : " + repCorrect.getReponse(), "Correction",
					JOptionPane.ERROR_MESSAGE);

		}
		currentQuestion++;
		jouer();
	}

}
