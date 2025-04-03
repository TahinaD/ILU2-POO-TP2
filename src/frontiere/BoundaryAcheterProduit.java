package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	private void acheterProduitAVendeur(String nomAcheteur, String nomVendeur, String produit) {
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
		System.out.println("Bonjour " + nomAcheteur + ".\n");
		int quantiteAchetee = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
		int quantiteFinale = controlAcheterProduit.acheterProduit(nomVendeur, quantiteAchetee);
		if (quantiteFinale == 0)
			System.out.println(nomAcheteur + " veut acheter " + quantiteAchetee + " " + produit + ", malheureusement il n'y en a plus !\n");
		else if (quantiteFinale < quantiteAchetee)
			System.out.println(nomAcheteur + " veut acheter " + quantiteAchetee + " " + produit + ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteFinale + ". " + nomAcheteur + " achete tout le stock de " + nomVendeur + ".\n" );
		else
			System.out.println(nomAcheteur + " achete " + quantiteAchetee + " " + produit + " à " + nomVendeur + ".\n");
		
	}
	
	private void choisirVendeur(String nomAcheteur, Gaulois[] vendeursProduit, String produit) {
		int choixUtilisateur;
		do {
			StringBuilder question = new StringBuilder();
			question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
			for (int i = 0; i < vendeursProduit.length; i++)
				question.append((i+1) + " - " + vendeursProduit[i].getNom() + "\n");
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			if (choixUtilisateur > 0 && choixUtilisateur < vendeursProduit.length+1) {
				String nomVendeur = vendeursProduit[choixUtilisateur-1].getNom();
				acheterProduitAVendeur(nomAcheteur, nomVendeur, produit);
			} else
				System.out.println("Vous devez entrer un chiffre positif");
		} while (choixUtilisateur > vendeursProduit.length);
		
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée" + nomAcheteur + ", mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			Gaulois[] vendeursProduit = controlAcheterProduit.trouverEtalProduit(produit);
			if (vendeursProduit == null)
				System.out.println("Désolé, personne ne vend ce produit au marché.\n");
			else {
				choisirVendeur(nomAcheteur, vendeursProduit, produit);
			}
		}
	}
}
