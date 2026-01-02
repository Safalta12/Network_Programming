package SecureSocket;

import java.io.*;
import javax.net.ssl.*;
public class SecureClient_Safalta {
	    public static void main(String[] args) {
	        String host = "localhost"; // server host
	        int port = 8443;           // same port

	        try {
	            // Create SSLSocket using default SSL socket factory
	            SSLSocketFactory sslSocketFactory =
	                    (SSLSocketFactory) SSLSocketFactory.getDefault();
	            SSLSocket sslSocket = 
	                    (SSLSocket) sslSocketFactory.createSocket(host, port);

	            System.out.println("Connected securely to server!");

	            // Create I/O streams
	            PrintWriter out = new PrintWriter(
	                    sslSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(sslSocket.getInputStream()));

	            // Send message to server
	            out.println("Hello Secure Server!");

	            // Read response
	            System.out.println("Server says: " + in.readLine());

	            // Close
	            in.close();
	            out.close();
	            sslSocket.close();

	        } catch (IOException ex) {
	            System.err.println("Client error: " + ex.getMessage());
	        }
	    }
	}
