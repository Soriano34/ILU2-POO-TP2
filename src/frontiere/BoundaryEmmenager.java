package frontiere;

import java.security.UnrecoverableEntryException;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois "+nomVisiteur);
					StringBuilder question2 = new StringBuilder();
					question2.append("Quelle est votre force ?");
					int choixForce=-1;
					choixForce=Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, choixForce);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide "+ nomVisiteur);
		StringBuilder question = new StringBuilder();
		question.append("Quelle est votre force ?");
		int choix=-1; 
		choix = Clavier.entrerEntier(question.toString());
		StringBuilder question1= new StringBuilder();
		StringBuilder question2= new StringBuilder();
		question1.append("Quelle est la force de votre potion la plus forte que vous produisez ?");
		question2.append("Quelle est la force de votre potion la plus faible que vous produisez ? ");
		int effetPotionMin=-1, effetPotionMax=-2;
		while (effetPotionMax< effetPotionMin) {
			effetPotionMin= Clavier.entrerEntier(question2.toString());
			effetPotionMax= Clavier.entrerEntier(question1.toString());
		if (effetPotionMax<effetPotionMin) System.out.println("Attention Druide, vous vous êtes trompé entre le maximum et le minimum.");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, choix, effetPotionMin, effetPotionMax);

	}
}
