package controleur;

import villagegaulois.Etal; // J'ai LE DROIT ?

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal messi=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return (messi!=null);
	}

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Etal messi = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		String[] donneesVente = new String[5];
		donneesVente=messi.etatEtal();
		messi.libererEtal();
		return donneesVente;
	}

}
