package SecureSocket;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;
public class SecureServer_Safalta {
	    public static void main(String[] args) {
	        int port = 8443; // secure port

	        try {
	            // Create SSL server socket factory
	            SSLServerSocketFactory sslServerFactory =
	                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	            SSLServerSocket sslServerSocket = 
	                    (SSLServerSocket) sslServerFactory.createServerSocket(port);

	            System.out.println("Secure Server started on port " + port);

	            // Accept client connection
	            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
	            System.out.println("Client connected securely!");

	            // Read from client and send response
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(sslSocket.getInputStream()));
	            PrintWriter out = new PrintWriter(
	                    sslSocket.getOutputStream(), true);

	            String received = in.readLine(); // get line from client
	            System.out.println("Client says: " + received);

	            out.println("Secure Server response: received \"" + received + "\"");

	            // Close
	            out.close();
	            in.close();
	            sslSocket.close();
	            sslServerSocket.close();

	        } catch (IOException ex) {
	            System.err.println("Server error: " + ex.getMessage());
	        }
	    }
	}
