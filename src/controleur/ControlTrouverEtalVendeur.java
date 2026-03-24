package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois lionelMessi = village.trouverHabitant(nomVendeur);
		Etal etal=null;
		if (lionelMessi!=null) {
			etal = village.rechercherEtal(lionelMessi);
		}
		return etal;
	}
}
//ON EST INTERDIT D'IMPORTER GAULOIS ?????
