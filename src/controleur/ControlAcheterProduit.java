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
	
	public Gaulois[] trouverEtalProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String nomVendeur, int quantiteProduit) {
		Etal etalProduit = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etalProduit.acheterProduit(quantiteProduit);
	}
}
