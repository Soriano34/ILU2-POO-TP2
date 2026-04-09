package frontiere;

import java.util.Iterator;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean oui = controlAcheterProduit.veritiferIdentite(nomAcheteur);
		if (!oui) {System.out.println("Je suis désolée " +nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici"); return;}
		StringBuilder question = new StringBuilder();
		question.append("Quel produit voulez vous acheter ?");
		String produit = Clavier.entrerChaine(question.toString());
		String[] tableauVendeur = controlAcheterProduit.rechercherVendeur(produit);
		if (tableauVendeur.length==0) System.out.println("Désolé, personne ne vend ce produit au marché");
		StringBuilder question2 = new StringBuilder();
		question2.append("Chez quel commerçant voulez vous acheter des "+ produit);
		int i=1;
		for (String string : tableauVendeur) {
			System.out.println(i+" - "+string); i++;
	}
		int indice=Clavier.entrerEntier(" ");
		System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ produit);
		StringBuilder combien = new StringBuilder();
		combien.append("Combien de "+ produit+ " voulez-vous acheter ?");
		int qte= Clavier.entrerEntier(combien.toString());
		int quantiteReelle= controlAcheterProduit.acheterProduit(tableauVendeur[indice], qte);
		if (quantiteReelle==qte) System.out.println(nomAcheteur+" achète "+ quantiteReelle+" " +produit+ " à"+tableauVendeur[indice]);
		if (quantiteReelle<qte) System.out.println(nomAcheteur+" veut acheter "+ indice+ " "+tableauVendeur[indice]+" malheureusement "+produit+);
		
	}
}
