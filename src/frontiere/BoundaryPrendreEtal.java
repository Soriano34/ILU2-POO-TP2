package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) System.out.println("Je suis désolée "+ nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		else { System.out.println("Bonjour "+ nomVendeur+ " ,je vais regarder si je peux vous trouver un étal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) System.out.println("Désolée "+ nomVendeur+ " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			else installerVendeur(nomVendeur);
			}
		}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n Il me faudrait quelques renseignements : ");
		StringBuilder question = new StringBuilder();
		question.append("Quel produit souhaitez vous vendre ?");
		String reponse= Clavier.entrerChaine(question.toString());
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez-vous en vendre ?");
		int quantite = Clavier.entrerEntier(question2.toString());
		int numeroEtal= controlPrendreEtal.prendreEtal(nomVendeur, reponse, quantite);
		if (numeroEtal!=-1) System.out.println("Le vendeur "+ nomVendeur+ " s'est installé à l'étal n°"+numeroEtal);
	}
}
