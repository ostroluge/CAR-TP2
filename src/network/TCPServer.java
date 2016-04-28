package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Instruction;
import model.ProxyCarnet;

public class TCPServer {
	
	public static void main(String[] args) throws Exception {

		ServerSocket welcomeSocket = new ServerSocket(TCPClient.PORT);
		
		while (true) {
			
			Socket connectionSocket = welcomeSocket.accept();
			
			ObjectInputStream inputObject = new ObjectInputStream(connectionSocket.getInputStream());
			ObjectOutputStream outputObject = new ObjectOutputStream(connectionSocket.getOutputStream());
			
			Instruction instruction = (Instruction) inputObject.readObject();
			
			switch (instruction.codeInstruction) {
				case ProxyCarnet.AJOUTER_PERSONNE:
					break;
				case ProxyCarnet.CHERCHER_PERSONNE:
					break;
				case ProxyCarnet.LISTER_PERSONNES:
					break;
				case ProxyCarnet.MODIFIER_PERSONNE:
					break;
				case ProxyCarnet.RETIRER_PERSONNE:
					break;
					
			}
		}
	}
}
