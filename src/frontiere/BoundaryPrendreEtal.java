package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur))
			System.out.println("Je suis d�sol� " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.\n");
		else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			if (!controlPrendreEtal.resteEtals())
				System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			else
				installerVendeur(nomVendeur);
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements.\n");
		String produit = Clavier.entrerChaine("Quel produit vendez-vous ?\n");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1)
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal + "\n");
	}
}
