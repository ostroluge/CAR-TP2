package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ProxyCarnet implements Repertoire {

	public static final int AJOUTER_PERSONNE = 1;
	public static final int MODIFIER_PERSONNE = 2;
	public static final int RETIRER_PERSONNE = 3;
	public static final int CHERCHER_PERSONNE = 4;
	public static final int LISTER_PERSONNES = 5;

	private Socket clientSocket;
	private ObjectOutputStream fluxOut;
	private ObjectInputStream fluxIn;
	
	public ProxyCarnet(String hostname, int port) {
		try {
			this.clientSocket = new Socket(hostname, port);
			this.fluxOut = new ObjectOutputStream(clientSocket.getOutputStream());
			this.fluxIn = new ObjectInputStream(clientSocket.getInputStream());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean ajouterPersonne(Personne personne) {
		
		boolean result = false;
		
		try {
			fluxOut.writeInt(AJOUTER_PERSONNE);
			fluxOut.writeObject(personne);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			result = fluxIn.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean modifierPersonne(Personne personne) {

		boolean result = false;

		try {
			fluxOut.writeInt(MODIFIER_PERSONNE);
			fluxOut.writeObject(personne);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			result = fluxIn.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	public boolean retirerPersonne(String nom) {

		boolean result = false;
		
		try {
			fluxOut.writeInt(RETIRER_PERSONNE);
			fluxOut.writeBytes(nom);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			result = fluxIn.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Personne chercherPersonne(String nom) {

		Personne personne = null;
		
		try {
			fluxOut.writeInt(CHERCHER_PERSONNE);
			fluxOut.writeBytes(nom);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			personne = (Personne) fluxIn.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return personne;
	}

	public String[] listerPersonnes() {
		
		String[] personnes = null;
		
		try {
			fluxOut.writeInt(LISTER_PERSONNES);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			personnes = (String[]) fluxIn.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return personnes;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
}
