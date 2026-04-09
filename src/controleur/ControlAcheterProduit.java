package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean veritiferIdentite(String chaine) {
		return controlVerifierIdentite.verifierIdentite(chaine);
	}
	
	public String[] rechercherVendeur(String produit) {
		Gaulois[] tableau = village.rechercherVendeursProduit(produit);
		String[] nom = new String[tableau.length];
		for (int i = 0; i < tableau.length; i++) {
			nom[i]= tableau[i].getNom();
		}
		return nom;
	}
	public int acheterProduit(String vendeur,int quantite) {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
			int quantiteReelle =etal.acheterProduit(quantite);	
			return quantiteReelle;
	}

	
}
