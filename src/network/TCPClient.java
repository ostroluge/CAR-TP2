package network;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {

	public static final String HOSTNAME = "hostname";
	public static final int PORT = 8080;
	
	public static void main(String[] args) {
		int anInteger = 0;
		boolean aBoolean = false;
		String aString = null;
		Object anObject = null;
		
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Socket clientSocket = new Socket(HOSTNAME, PORT);
		
			DataOutputStream outToServer = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			BufferedReader inFromServer = 
					new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// traitement des variables a envoyer
			
			ObjectOutputStream fluxOut = new ObjectOutputStream(outToServer);
			fluxOut.writeInt(anInteger);
			fluxOut.writeBoolean(aBoolean);
			fluxOut.writeUTF(aString);
			fluxOut.writeObject(anObject);
			
			// traitement du retour du serveur
	
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
