package model;

import java.util.ArrayList;
import java.util.List;

public class Carnet implements Repertoire {

	public List<Personne> personnes = new ArrayList<>();
	
	public boolean ajouterPersonne(Personne personne) {
		return personnes.add(personne);
	}

	public boolean modifierPersonne(Personne personne) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retirerPersonne(String nom) {
		for (Personne personne : personnes) {
			if (personne.nom.equals(nom)) {
				return personnes.remove(personne);
			}
		}
		return false;
	}

	public Personne chercherPersonne(String nom) {
		for (Personne personne : personnes) {
			if (personne.nom.equals(nom)) {
				return personne;
			}
		}
		return null;
	}

	public String[] listerPersonnes() {
		String[] arrayPersonnes;
		for (Personne personne : personnes) {
		
		}
		return null;
	}

	
}
