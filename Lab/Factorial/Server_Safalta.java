package Factorial;

import java.io.*;
import java.net.*;
public class Server_Safalta {
	    public static void main(String[] args) {
	        try {
	            // Create server socket on port 6000
	            ServerSocket serverSocket = new ServerSocket(6000);
	            System.out.println("Server started and waiting for client...");

	            // Accept connection from client
	            Socket socket = serverSocket.accept();
	            System.out.println("Client connected.");

	            // Read number from client
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	            String numStr = in.readLine();  // read as string
	            int num = Integer.parseInt(numStr);

	            System.out.println("Received number: " + num);

	            // Compute factorial
	            long factorial = 1;
	            for (int i = 1; i <= num; i++) {
	                factorial *= i;
	            }

	            // Send result back to client
	            PrintWriter out = new PrintWriter(
	                    socket.getOutputStream(), true);
	            out.println(factorial);

	            // Close resources
	            in.close();
	            out.close();
	            socket.close();
	            serverSocket.close();
	            System.out.println("Server closed.");

	        } catch (IOException e) {
	            System.out.println("Server error: " + e.getMessage());
	        }
	    }
	}
