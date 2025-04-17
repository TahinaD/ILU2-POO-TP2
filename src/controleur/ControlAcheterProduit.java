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

	public boolean verifierIdentite(String nomHabitant) {
		return controlVerifierIdentite.verifierIdentite(nomHabitant);
	}
	
	public String[] trouverEtalProduit(String produit) {
		String[] nomVendeurs = null;
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs != null) {
			nomVendeurs = new String[vendeurs.length];
			for (int i = 0; i < vendeurs.length; i++)
				nomVendeurs[i] = vendeurs[i].getNom();
		}
		return nomVendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int quantiteProduit) {
		Etal etalProduit = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etalProduit.acheterProduit(quantiteProduit);
	}
}
