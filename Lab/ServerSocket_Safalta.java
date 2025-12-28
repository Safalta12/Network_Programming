package Lab;

import java.io.*;
import java.net.*;
public class ServerSocket_Safalta {
	    public static void main(String[] args) {
	        int port = 5000;

	        ServerSocket serverSocket = null;

	        try {
	            // Create ServerSocket
	            serverSocket = new ServerSocket(port);
	            System.out.println("Server started, listening on port " + port);

	            while (true) {
	                try {
	                    // Accept new client connection
	                    Socket clientSocket = serverSocket.accept();
	                    System.out.println("New client connected: " 
	                            + clientSocket.getInetAddress().getHostAddress());

	                    // Send welcome message to client
	                    PrintWriter out = new PrintWriter(
	                            clientSocket.getOutputStream(), true);
	                    out.println("Welcome! You are connected.");

	                    // Close this client connection
	                    clientSocket.close();

	                } catch (IOException clientError) {
	                    System.out.println("Error while communicating with client: " + clientError.getMessage());
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Server error: " + e.getMessage());
	        } finally {
	            try {
	                if (serverSocket != null) {
	                    serverSocket.close();
	                }
	            } catch (IOException e) {
	                System.out.println("Error closing server: " + e.getMessage());
	            }
	        }
	    }
	}
