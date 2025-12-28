package Lab;

import java.io.*;
import java.net.*;

public class ReadFromServer_Safalta {

	    	    public static void main(String[] args) {
	    	        try {
	    	            // Connect to the server at localhost:5000
	    	            Socket socket = new Socket("localhost", 5000);
	    	            System.out.println("Connected to server...");

	    	            // Create input stream to read text from the server
	    	            BufferedReader in = new BufferedReader(
	    	                    new InputStreamReader(socket.getInputStream()));

	    	            String message;
	    	            System.out.println("Reading from socket:");
	    	            while ((message = in.readLine()) != null) {
	    	                if (message.equals("END")) break; // Stop when END is received
	    	                System.out.println(message);
	    	            }

	    	            // Close streams and socket
	    	            in.close();
	    	            socket.close();
	    	            System.out.println("Connection closed.");

	    	        } catch (IOException e) {
	    	            e.printStackTrace();
	    	        }
	    	    }
	    	}
