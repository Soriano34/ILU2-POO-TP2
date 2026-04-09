package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] ankaraMessi= controlAfficherMarche.donnerInfosMarche();
		if (ankaraMessi.length==0) System.out.println("Le marché est vide, revenez plus tard.");
		else {
			System.out.println(nomAcheteur+" , vous trouverez au marché : ");
			for (int i = 0; i < ankaraMessi.length; i++) {
				System.out.print("- "+ankaraMessi[i]);
				i++;
				System.out.print(" qui vend "+ ankaraMessi[i]);
				i++;
				System.out.println(" "+ankaraMessi[i]);	
			}
		}
	}
}
