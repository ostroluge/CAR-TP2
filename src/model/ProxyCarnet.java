package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	private BufferedReader outFromClient;
	private BufferedReader inFromServer;

	public ProxyCarnet(String hostname, int port) {
		try {
			this.clientSocket = new Socket(hostname, port);
			this.fluxOut = new ObjectOutputStream(clientSocket.getOutputStream());
			this.fluxIn = new ObjectInputStream(clientSocket.getInputStream());
			this.outFromClient = new BufferedReader(new InputStreamReader(fluxOut));
			this.inFromServer = new BufferedReader(new InputStreamReader(fluxIn));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean ajouterPersonne(Personne personne) {


		return false;
	}

	public boolean modifierPersonne(Personne personne) {


		return false;
	}

	public boolean retirerPersonne(String nom) {

		return false;
	}

	public Personne chercherPersonne(String nom) {

		try {
			fluxOut.writeInt(CHERCHER_PERSONNE);
			fluxOut.writeBytes(nom);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String[] listerPersonnes() {

		return null;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
}
